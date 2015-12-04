package jp.ac.tsukuba.cs.coins_p.aid.handyword.wordcard;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.R;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.api.endpoint.TranslationEndpoint;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.api.schema.Translation;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.database.model.WordCardModel;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.database.schema.WordCard;
import rx.Subscriber;

public class WordCardRegisterActivity extends AppCompatActivity {
    private static final String TAG = WordCardRegisterActivity.class.getSimpleName();
    private ProgressDialog progressDialog;

    @Bind(R.id.edit_text_japanese)
    EditText japaneseText;
    @Bind(R.id.edit_text_english)
    EditText englishText;
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_word_card);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
    }

    @OnClick(R.id.button_translate_en_to_ja)
    public void translateWord(){
        showProgress(getString(R.string.register_word_translate_dialog_title), getString(R.string.register_word_translate_dialog_message));
        final Context context = this;
        TranslationEndpoint.getInstance().translate(japaneseText.getText().toString(), new Subscriber<Translation>() {
            @Override
            public void onCompleted() {
                progressDialog.dismiss();
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "translate word error", e);
                progressDialog.dismiss();
                Toast.makeText(context, getString(R.string.register_word_caution_error), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNext(Translation translation) {
                englishText.setText(translation.getTranslatedString());
            }
        });
    }

    @OnClick(R.id.word_register_button)
    public void registerWordCard() {
        WordCard newWordCard = WordCardModel.createWordCardWith(japaneseText.getText().toString(), englishText.getText().toString());
        WordCardModel.getInstance().saveWordCard(newWordCard);
        // TODO get by ActivityForResult
        finish();
    }

    @OnClick(R.id.back_menu_button)
    public void backToMenuActivity() {
        showCautionDialog();
    }

    // Utils
    private void showProgress(String dialogTitle, String dialogMessage) {
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle(dialogTitle);
        progressDialog.setMessage(dialogMessage);
        progressDialog.setCancelable(false);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
    }

    private void showCautionDialog() {
        if (!japaneseText.getText().toString().isEmpty() || !englishText.getText().toString().isEmpty()) {
            AlertDialog alertDialog = new AlertDialog.Builder(this)
                    .setTitle(getString(R.string.register_word_caution_dialog_title))
                    .setMessage(getString(R.string.register_word_caution_dialog_message))
                    .setPositiveButton(getString(R.string.message_ok), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .setNegativeButton(getString(R.string.message_cancel), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create();
            alertDialog.show();
        } else {
            finish();
        }
    }
}
