package jp.ac.tsukuba.cs.coins_p.aid.handyword.wordcard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

import jp.ac.tsukuba.cs.coins_p.aid.handyword.R;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.api.endpoint.TranslationEndpoint;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.api.schema.Translation;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.database.model.WordCardModel;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.database.schema.WordCard;
import rx.Subscriber;

public class AddWordCardActivity extends AppCompatActivity {

    private String translatedRawString = "";
    private EditText japaneseEditText;
    private EditText englishEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_word_card);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        japaneseEditText = (EditText)findViewById(R.id.edit_text_japanese);
        englishEditText = (EditText)findViewById(R.id.edit_text_english);
        initButtons();
    }

    public void initButtons(){
        Button translationButtonJaToEn = (Button)findViewById(R.id.button_translate_en_to_ja);
        translationButtonJaToEn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                translate(japaneseEditText.getText().toString());
            }
        });

        Button registerButton = (Button)findViewById(R.id.button_register);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WordCard wordCard = new WordCard();
                wordCard.setWord(japaneseEditText.getText().toString());
                wordCard.setTranslatedWord(englishEditText.getText().toString());
                wordCard.setCreatedAt(new Date());
                wordCard.setUpdatedAt(new Date());
                WordCardModel.getInstance().initRealmInstance(AddWordCardActivity.this);
                WordCardModel.getInstance().saveWordCard(wordCard);
                finish();
            }
        });

        Button menuButton = (Button)findViewById(R.id.button_menu);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    public void translate(final String rawString){
        TranslationEndpoint translationEndpoint = new TranslationEndpoint();
        translationEndpoint.translate(rawString, new Subscriber<Translation>() {
            @Override
            public void onCompleted() {
                setTranslatedWordOnEditText(translatedRawString);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("WordCard", "get translated word error", e);
            }

            @Override
            public void onNext(Translation translation) {
                translatedRawString = translation.getTranslatedString();
            }
        });
    }

    public void setTranslatedWordOnEditText(String translatedRawString){
        englishEditText.setText(translatedRawString);
    }

}
