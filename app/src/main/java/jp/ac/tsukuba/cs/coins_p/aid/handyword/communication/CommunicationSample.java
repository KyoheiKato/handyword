package jp.ac.tsukuba.cs.coins_p.aid.handyword.communication;

import android.util.Log;

import jp.ac.tsukuba.cs.coins_p.aid.handyword.pojo.AccessTokenResult;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.pojo.TranslationResult;
import lombok.Getter;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.converter.SimpleXMLConverter;

public class CommunicationSample {

    private static final String ACCESS_TOKEN_API = "https://datamarket.accesscontrol.windows.net/v2";
    private static final String TRANSLATION_API = "http://api.microsofttranslator.com/V2/Http.svc";
    final String GRANT_TYPE = "client_credentials";
    final String CLIENT_ID = "handyword";
    final String CLIENT_SECRET = "Coins2015uTsukubaKyouheikatoUmezu";
    final String SCOPE = "http://api.microsofttranslator.com";

    private AccessTokenApi accessTokenApi;
    private TranslationApi translationApi;

    @Getter
    private String accessToken;
    @Getter
    private String translatedString;


    public CommunicationSample() {
        accessTokenApi = new RestAdapter.Builder()
                .setEndpoint(ACCESS_TOKEN_API)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build()
                .create(AccessTokenApi.class);
        translationApi = new RestAdapter.Builder()
                .setEndpoint(TRANSLATION_API)
                .setConverter(new SimpleXMLConverter())
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build()
                .create(TranslationApi.class);
    }

    public void sampleQuery(){
        accessTokenApi.getAccessToken(GRANT_TYPE, CLIENT_ID, CLIENT_SECRET, SCOPE, new GetAccessTokenListener());
    }

    public class GetAccessTokenListener implements Callback<AccessTokenResult> {
        @Override
        public void success(AccessTokenResult accessTokenResult, Response response) {
            accessToken = accessTokenResult.getAccessToken();
            Log.d("GetAccessTokenListener", "onSuccess!!!" + accessToken);
            translationApi.translate("Bearer " + accessToken, "こんにちは", "ja", "en",
                    "text/plain", "general", new TranslateListener());
        }

        @Override
        public void failure(RetrofitError error) {
            Log.e("GetAccessTokenListener", "onFailure! " + error);
        }
    }

    public class TranslateListener implements Callback<TranslationResult> {
        @Override
        public void success(TranslationResult translationResult, Response response) {
            translatedString = translationResult.getTranslatedString();
            Log.d("TranslateListener", "onSuccess!!!" + translatedString);
        }

        @Override
        public void failure(RetrofitError error) {
            Log.e("TranslateListener", "onFailure! " + error);
        }
    }
}
