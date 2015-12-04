package jp.ac.tsukuba.cs.coins_p.aid.handyword.api.endpoint;

import jp.ac.tsukuba.cs.coins_p.aid.handyword.api.MicrosoftTranslateApi;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.api.converter.CustomXMLConverter;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.api.schema.AccessToken;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.api.schema.Translation;
import retrofit.RestAdapter;
import retrofit.android.AndroidLog;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class TranslationEndpoint extends Endpoint {

    private static final String TAG = TranslationEndpoint.class.getSimpleName();
    private static final String TRANSLATION_API = "http://api.microsofttranslator.com/V2/Http.svc";
    private static final String JAPANESE = "ja";
    private static final String ENGLISH = "en";
    private static final String CONTENT_TYPE = "text/plain";
    private static final String CATEGORY = "general";
    private static final TranslationEndpoint instance = new TranslationEndpoint();

    private TranslationEndpoint() {
        microsoftTranslateApi = new RestAdapter.Builder()
                .setEndpoint(TRANSLATION_API)
                .setConverter(new CustomXMLConverter())
                .setLog(new AndroidLog(TAG))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build()
                .create(MicrosoftTranslateApi.class);
    }

    public static TranslationEndpoint getInstance() {
        return instance;
    }

    public void translate(final String rawString, final Subscriber<Translation> subscriber) {
        AccessTokenEndpoint accessTokenEndpoint = AccessTokenEndpoint.getInstance();
        if (accessTokenEndpoint.isAccessTokenEffective()) {
            microsoftTranslateApi.getTranslatedWord(
                    "Bearer " + accessTokenEndpoint.getCurrentAccessToken().getAccessToken(),
                    rawString,
                    JAPANESE,
                    ENGLISH,
                    CONTENT_TYPE,
                    CATEGORY
            )
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.newThread())
            .subscribe(subscriber);
        } else {
            accessTokenEndpoint.getAccessToken(new AccessTokenEndpoint.AccessTokenCallback() {
                @Override
                public void doOnNext(AccessToken accessToken) {
                    microsoftTranslateApi.getTranslatedWord(
                            "Bearer " + accessToken.getAccessToken(),
                            rawString,
                            JAPANESE,
                            ENGLISH,
                            CONTENT_TYPE,
                            CATEGORY
                    )
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.newThread())
                    .subscribe(subscriber);
                }
            });
        }
    }
}
