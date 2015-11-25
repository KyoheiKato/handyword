package jp.ac.tsukuba.cs.coins_p.aid.handyword;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import jp.ac.tsukuba.cs.coins_p.aid.handyword.api.endpoint.Translation;
import retrofit.RetrofitError;

public class MainActivity extends AppCompatActivity {
    Translation translation = new Translation();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        translation.translate("筑波大学", "ja", "en", new Translation.TranslationCallback() {
            @Override
            public void onTranslationSuccess(String translatedString) {
                Log.d("MainActivity", "onTranslationSuccess " + translatedString);
                TextView textView = (TextView) findViewById(R.id.SampleText);
                textView.setText(translatedString);
            }

            @Override
            public void onTranslationFailure(RetrofitError error) {
                Log.e("MainActivity", "onTranslationFailure!", error);
            }

            @Override
            public void onAccessTokenGetFailure(RetrofitError error) {
                Log.e("MainActivity", "onAccessTokenGetFailure!", error);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
