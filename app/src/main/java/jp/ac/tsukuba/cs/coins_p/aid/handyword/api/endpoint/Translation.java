package jp.ac.tsukuba.cs.coins_p.aid.handyword.api.endpoint;

import jp.ac.tsukuba.cs.coins_p.aid.handyword.api.converter.CustomXMLConverter;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class Translation extends Endpoint {

    public interface TranslationCallback {
        void onTranslationSuccess(String translatedString);
        void onTranslationFailure(RetrofitError error);
        void onAccessTokenGetFailure(RetrofitError error);
    }

    private static final String TRANSLATION_API = "http://api.microsofttranslator.com/V2/Http.svc";

    private TranslationApi translationApi;

    TranslationCallback translationCallback;

    public Translation() {
        translationApi = new RestAdapter.Builder()
                .setEndpoint(TRANSLATION_API)
                .setConverter(new CustomXMLConverter())
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build()
                .create(TranslationApi.class);
    }

    public void translate(final String string, final String from, final String to,
                          final TranslationCallback cb) {
        translationCallback = cb;
        AccessToken accessToken = new AccessToken();
        accessToken.getAccessToken(new AccessToken.AccessTokenCallback() {
            @Override
            public void onGetAccessTokenSuccess(String accessToken) {
                translationApi.translate("Bearer " + accessToken, string, from, to, "text/plain",
                        "general", new TranslateListener());
            }

            @Override
            public void onGetAccessTokenFailure(RetrofitError error) {
                translationCallback.onAccessTokenGetFailure(error);
            }
        });
    }

    public class TranslateListener implements Callback<jp.ac.tsukuba.cs.coins_p.aid.handyword.api.schema.Translation> {
        @Override
        public void success(jp.ac.tsukuba.cs.coins_p.aid.handyword.api.schema.Translation translation, Response response) {
            translationCallback.onTranslationSuccess(translation.getTranslatedString());
        }

        @Override
        public void failure(RetrofitError error) {
            translationCallback.onTranslationFailure(error);
        }
    }
}
