package jp.ac.tsukuba.cs.coins_p.aid.handyword.communication;

import android.util.Log;

import jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.pojo.AccessToken;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.converter.SimpleXMLConverter;

public class CommunicationSample {

    private static final String API = "https://datamarket.accesscontrol.windows.net/v2";
    private MicrosoftTranslationApi msApi;
    private SimpleXMLConverter simpleXMLConverter = new SimpleXMLConverter();
    String GRANT_TYPE = "client_credentials";
    String CLIENT_ID = "handyword";
    String CLIENT_SECRET = "Coins2015uTsukubaKyouheikatoUmezu";
    String SCOPE = "http://api.microsofttranslator.com";

    public CommunicationSample() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(API)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        msApi = restAdapter.create(MicrosoftTranslationApi.class);
    }

    public void sampleQuery(){
        msApi.getAccessToken(GRANT_TYPE, CLIENT_ID, CLIENT_SECRET, SCOPE, new AccessTokenListener());
    }

    public class AccessTokenListener implements Callback<AccessToken> {
        @Override
        public void success(AccessToken AccessToken, Response response) {
            Log.d("CommunicationSample", "onSuccess!!!" + AccessToken.getAccessToken());
        }

        @Override
        public void failure(RetrofitError error) {
            Log.e("CommunicationSample", "onFailure! " + error);
        }
    }
}
