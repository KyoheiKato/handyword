package jp.ac.tsukuba.cs.coins_p.aid.handyword.communication;

import android.util.Log;

import jp.ac.tsukuba.cs.coins_p.aid.handyword.MainActivity;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.converter.CustomXMLConverter;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.pojo.AccessTokenResult;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.pojo.TranslationResult;
import lombok.Setter;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class Translation extends Thread{

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

    private MainActivity mainActivity;

    @Setter
    private String stringToTranslate;

    public Translation(MainActivity activity) {
        mainActivity = activity;
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

    public void run(){
        mainActivity.setSampleString(translate(stringToTranslate));
    }

    public String translate(final String string){
        String accessToken;
        accessToken = accessTokenApi.getAccessToken(GRANT_TYPE, CLIENT_ID, CLIENT_SECRET,
                SCOPE).getAccessToken();
        String translatedString;
        translatedString = translationApi.translate("Bearer " + accessToken, string,
                JAPANESE, ENGLISH, "text/plain", "general").getTranslatedString();
        Log.d("Translation", "" + translatedString);
        return translatedString;
    }

    public class GetAccessTokenListener implements Callback<AccessTokenResult> {
        @Override
        public void success(AccessTokenResult accessTokenResult, Response response) {
            Log.d("GetAccessTokenListener", "onSuccess!");
        }

        @Override
        public void failure(RetrofitError error) {
            Log.e("GetAccessTokenListener", "onFailure!", error);
        }
    }

    public class TranslateListener implements Callback<TranslationResult> {
        @Override
        public void success(TranslationResult translationResult, Response response) {
            Log.d("TranslateListener", "onSuccess!");
        }

        @Override
        public void failure(RetrofitError error) {
            Log.e("TranslateListener", "onFailure!", error);
        }
    }
}
