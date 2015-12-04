package jp.ac.tsukuba.cs.coins_p.aid.handyword.wordcard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import jp.ac.tsukuba.cs.coins_p.aid.handyword.R;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.database.model.WordCardModel;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.database.schema.WordCard;

public class WordCardDetailActivity extends AppCompatActivity {

    int wordCardId;
    int[] wordCardIdArray;
    int currentIdIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_card_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        wordCardId = getIntent().getIntExtra("id", 0);
        wordCardIdArray = getIntent().getIntArrayExtra("idArray");
        currentIdIndex = findIdPosition(wordCardIdArray, wordCardId);
        initView(wordCardId);
    }

    public void initView(int id){
        WordCardModel.getInstance().initRealmInstance(this);
        setTextViews(id);

        Button previousButton = (Button)findViewById(R.id.button_previous);
        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentIdIndex > 0){
                    currentIdIndex--;
                    setTextViews(wordCardIdArray[currentIdIndex]);
                }
            }
        });

        Button nextButton = (Button)findViewById(R.id.button_next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentIdIndex < wordCardIdArray.length - 1){
                    currentIdIndex++;
                    setTextViews(wordCardIdArray[currentIdIndex]);
                }
            }
        });

        Button menuButton = (Button)findViewById(R.id.back_menu_button);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public int findIdPosition(int[] idArray, int id){
        for(int i = 0; i < idArray.length; i++){
            if(id == idArray[i]){
                return i;
            }
        }
        return -1;
    }

    public void setTextViews(int id){
        WordCard wordCard = WordCardModel.getInstance().getWordCard(id);
        TextView japaneseWord = (TextView)findViewById(R.id.text_japanese);
        japaneseWord.setText(wordCard.getWord());
        TextView englishWord = (TextView)findViewById(R.id.text_english);
        englishWord.setText(wordCard.getTranslatedWord());
    }

}
