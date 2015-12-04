package jp.ac.tsukuba.cs.coins_p.aid.handyword;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import jp.ac.tsukuba.cs.coins_p.aid.handyword.api.endpoint.TranslationEndpoint;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.wordcard.AddWordCardActivity;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.wordcard.WordCardsListActivity;

public class MainActivity extends AppCompatActivity {
    TranslationEndpoint translationEndpoint = new TranslationEndpoint();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initButtons();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void initButtons(){
        Button weakButton = (Button)findViewById(R.id.button_weak);
        weakButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WordCardsListActivity.class);
                intent.putExtra("wordCardsType", "weak");
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
        Button notLearnedButton = (Button)findViewById(R.id.button_not_learned);
        notLearnedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WordCardsListActivity.class);
                intent.putExtra("wordCardsType", "notLearned");
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
        Button allButton = (Button)findViewById(R.id.button_all);
        allButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WordCardsListActivity.class);
                intent.putExtra("wordCardsType", "all");
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
        Button addButton = (Button)findViewById(R.id.button_add);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddWordCardActivity.class);
                startActivity(intent);
            }
        });
    }
}
