package jp.ac.tsukuba.cs.coins_p.aid.handyword.wordcard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.R;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.database.model.WordCardModel;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.database.schema.WordCard;

public class WordCardDetailActivity extends AppCompatActivity {
    private static final String WORD_CARD_ID = "WordCardId";

    @Bind(R.id.before_translate_japanese_text)
    TextView japaneseText;
    @Bind(R.id.after_translate_english_text)
    TextView englishText;
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_card_detail);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        initWordCardTexts();
    }

    private void initWordCardTexts() {
        WordCard wordCard = WordCardModel.getInstance().findById(getIntent().getIntExtra(WORD_CARD_ID, 0));
        japaneseText.setText(wordCard.getWord());
        englishText.setText(wordCard.getTranslatedWord());
    }

    @OnClick(R.id.back_list_button)
    public void moveToWordCardListActivity() {
        finish();
    }

    public static Intent createNewIntent(Context context, int wordCardId) {
        Intent intent = new Intent(context, WordCardDetailActivity.class);
        intent.putExtra(WORD_CARD_ID, wordCardId);
        return intent;
    }
}
