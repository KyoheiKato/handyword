package jp.ac.tsukuba.cs.coins_p.aid.handyword.wordcard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.Bind;
import butterknife.ButterKnife;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.R;

public class WordCardDetailActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_card_detail);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
    }
}
