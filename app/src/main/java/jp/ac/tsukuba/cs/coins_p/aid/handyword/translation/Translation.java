package jp.ac.tsukuba.cs.coins_p.aid.handyword.translation;

import jp.ac.tsukuba.cs.coins_p.aid.handyword.AccessToken;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.api.converter.CustomXMLConverter;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.api.schema.TranslationEntity;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Query;

public class Translation {

    public interface TranslationApi {
    @GET("/Translate")
    void translate(@Query("appId") String appId, @Query("text") String text,
                   @Query("from") String from, @Query("to") String to,
                   @Query("contentType") String contentType, @Query("category") String category,
                   Callback<TranslationEntity> cb);
    }

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

    public class TranslateListener implements Callback<TranslationEntity> {
        @Override
        public void success(TranslationEntity translationEntity, Response response) {
            translationCallback.onTranslationSuccess(translationEntity.getTranslatedString());
        }

        @Override
        public void failure(RetrofitError error) {
            translationCallback.onTranslationFailure(error);
        }
    }
}
