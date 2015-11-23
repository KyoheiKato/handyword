package jp.ac.tsukuba.cs.coins_p.aid.handyword.translation;

import jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.AccessTokenApi;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.TranslationApi;
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
        void onTranslationSuccess();
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

    private AccessTokenApi accessTokenApi;
    private TranslationApi translationApi;

    private Translation translation;
    TranslationCallback translationCallback;

    @Setter
    private String accessToken;
    @Setter @Getter
    private String translatedString;
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

    public void translate(final String string, TranslationCallback translationCallback){
        this.translationCallback = translationCallback;
        stringToTranslate = string;
        accessTokenApi.getAccessToken(GRANT_TYPE, CLIENT_ID, CLIENT_SECRET, SCOPE,
                new GetAccessTokenListener());
    }

    public class GetAccessTokenListener implements Callback<AccessTokenResult> {
        @Override
        public void success(AccessTokenResult accessTokenResult, Response response) {
            accessToken = accessTokenResult.getAccessToken();
            translationApi.translate("Bearer " + accessToken, stringToTranslate, JAPANESE, ENGLISH,
                    "text/plain", "general", new TranslateListener());
        }

        @Override
        public void failure(RetrofitError error) {
            translationCallback.onTranslationFailure(error);
        }
    }

    public class TranslateListener implements Callback<TranslationResult> {
        @Override
        public void success(TranslationResult translationResult, Response response) {
            translatedString = translationResult.getTranslatedString();
            translationCallback.onTranslationSuccess();
        }

        @Override
        public void failure(RetrofitError error) {
            translationCallback.onTranslationFailure(error);
        }
    }
}
