package jp.ac.tsukuba.cs.coins_p.aid.handyword.wordcard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.R;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.database.model.WordCardModel;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.database.schema.WordCard;

public class WordCardQuestionActivity extends AppCompatActivity {
    @Bind(R.id.before_translate_japanese_text)
    TextView japaneseText;
    @Bind(R.id.after_translate_english_text)
    TextView englishText;
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_card_question);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        setRandomWordCardView();
    }

    private void setRandomWordCardView() {
        WordCard randomWordCard = WordCardModel.getInstance().getRandomWordCard();

        // TODO catch null exception
        if (randomWordCard == null) {
            finish();
        }

        japaneseText.setText(randomWordCard.getWord());
        englishText.setText(randomWordCard.getTranslatedWord());
    }

    @OnClick(R.id.display_or_hide_button)
    public void displayOrHideEnglish(Button displayOrHideButton) {
        if (englishText.getVisibility() == View.VISIBLE) {
            englishText.setVisibility(View.INVISIBLE);
            displayOrHideButton.setText(getString(R.string.question_word_no_display_button));
        }
        else if (englishText.getVisibility() == View.INVISIBLE) {
            englishText.setVisibility(View.VISIBLE);
            displayOrHideButton.setText(getString(R.string.question_word_display_button));
        }
    }

    @OnClick(R.id.next_question_button)
    public void displayNextQuestionButton() {
        setRandomWordCardView();
    }

    @OnClick(R.id.back_menu_button)
    public void backToMenuActivity() {
        finish();
    }
}
