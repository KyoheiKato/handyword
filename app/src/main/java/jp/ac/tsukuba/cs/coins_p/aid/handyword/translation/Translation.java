package jp.ac.tsukuba.cs.coins_p.aid.handyword.translation;

import jp.ac.tsukuba.cs.coins_p.aid.handyword.api.AccessTokenApi;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.api.TranslationApi;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.converter.CustomXMLConverter;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.pojo.AccessTokenResult;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.pojo.TranslationResult;
import lombok.Getter;
import lombok.Setter;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class Translation {
    public interface TranslationCallback {
        void onTranslationSuccess(String translatedString);
        void onTranslationFailure(RetrofitError error);
    }

    private static final String ACCESS_TOKEN_API = "https://datamarket.accesscontrol.windows.net/v2";
    private static final String TRANSLATION_API = "http://api.microsofttranslator.com/V2/Http.svc";
    final String GRANT_TYPE = "client_credentials";
    final String CLIENT_ID = "handyword";
    final String CLIENT_SECRET = "Coins2015uTsukubaKyouheikatoUmezu";
    final String SCOPE = "http://api.microsofttranslator.com";
    final String JAPANESE = "ja";
    final String ENGLISH = "en";

    private String translationFrom = JAPANESE;
    private String translationTo = ENGLISH;

    private AccessTokenApi accessTokenApi;
    private TranslationApi translationApi;

    TranslationCallback translationCallback;

    @Setter
    private String accessToken;
    @Setter
    private String stringToTranslate;

    public Translation() {
        accessTokenApi = new RestAdapter.Builder()
                .setEndpoint(ACCESS_TOKEN_API)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build()
                .create(AccessTokenApi.class);
        translationApi = new RestAdapter.Builder()
                .setEndpoint(TRANSLATION_API)
                .setConverter(new CustomXMLConverter())
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build()
                .create(TranslationApi.class);
    }

    public void translate(final String stringToTranslate, String translationFrom,
                          String translationTo, TranslationCallback translationCallback){
        this.translationCallback = translationCallback;
        this.stringToTranslate = stringToTranslate;
        this.translationFrom = translationFrom;
        this.translationTo = translationTo;
        accessTokenApi.getAccessToken(GRANT_TYPE, CLIENT_ID, CLIENT_SECRET, SCOPE,
                new GetAccessTokenListener());
    }

    public class GetAccessTokenListener implements Callback<AccessTokenResult> {
        @Override
        public void success(AccessTokenResult accessTokenResult, Response response) {
            accessToken = accessTokenResult.getAccessToken();
            translationApi.translate("Bearer " + accessToken, stringToTranslate, translationFrom,
                    translationTo, "text/plain", "general", new TranslateListener());
        }

        @Override
        public void failure(RetrofitError error) {
            translationCallback.onTranslationFailure(error);
        }
    }

    public class TranslateListener implements Callback<TranslationResult> {
        @Override
        public void success(TranslationResult translationResult, Response response) {
            translationCallback.onTranslationSuccess(translationResult.getTranslatedString());
        }

        @Override
        public void failure(RetrofitError error) {
            translationCallback.onTranslationFailure(error);
        }
    }
}