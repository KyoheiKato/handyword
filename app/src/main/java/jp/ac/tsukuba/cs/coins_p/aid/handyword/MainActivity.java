package jp.ac.tsukuba.cs.coins_p.aid.handyword;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.database.model.WordCardModel;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.wordcard.AddWordCardActivity;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.wordcard.WordCardsListActivity;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.menu_weak_words_button)
    Button weakWordsButton;
    @Bind(R.id.menu_not_learned_words_button)
    Button notLearnedWordsButton;
    @Bind(R.id.menu_all_words_button)
    Button allWordsButton;
    @Bind(R.id.menu_add_words_button)
    Button addWordsButton;
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        WordCardModel.getInstance().initRealmInstance(getApplicationContext());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        // TODO preference activity
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick({
            R.id.menu_weak_words_button,
            R.id.menu_not_learned_words_button,
            R.id.menu_all_words_button,
            R.id.menu_add_words_button
    })
    public void moveToFuncActivity(Button menuButton) {
        String menuType;
        switch (menuButton.getId()) {
            case R.id.menu_weak_words_button:
                menuType = "weak";
                break;
            case R.id.menu_not_learned_words_button:
                menuType = "notLearned";
                break;
            case R.id.menu_all_words_button:
                menuType = "all";
                break;
            case R.id.menu_add_words_button:
                Intent intent = new Intent(this, AddWordCardActivity.class);
                startActivity(intent);
                return;
            default:
                menuType = null;
                break;
        }
        Intent intent = WordCardsListActivity.createNewIntent(this, menuType);
        startActivity(intent);
    }
}
