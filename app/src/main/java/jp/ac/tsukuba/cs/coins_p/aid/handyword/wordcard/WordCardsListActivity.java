package jp.ac.tsukuba.cs.coins_p.aid.handyword.wordcard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.R;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.database.model.WordCardModel;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.database.schema.WordCard;


public class WordCardsListActivity extends AppCompatActivity {
    private static final String MENU_TYPE = "MenuType";

    private List<WordCard> wordCardList;

    @Bind(R.id.word_card_list)
    ListView wordCardListView;
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_cards_list);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        initWordCardListView();
    }

    private void initWordCardListView() {
        wordCardList = WordCardModel.getInstance().findAll();
        WordCardListAdapter adapter = new WordCardListAdapter(this, wordCardList);
        wordCardListView.setAdapter(adapter);
    }

    @OnClick(R.id.back_menu_button)
    public void backToMenuActivity() {
        finish();
    }

    @OnItemClick(R.id.word_card_list)
    public void moveToWordCardDetail(int position) {
        WordCard selectedWordCard = wordCardList.get(position);
        Intent intent = new Intent(this, WordCardDetailActivity.class);
        startActivity(intent);
    }

    public static Intent createNewIntent(Context context, String menuType) {
        Intent intent = new Intent(context, WordCardsListActivity.class);
        intent.putExtra(MENU_TYPE, menuType);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        return intent;
    }
}
