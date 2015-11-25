package jp.ac.tsukuba.cs.coins_p.aid.handyword.api.endpoint;

import jp.ac.tsukuba.cs.coins_p.aid.handyword.BuildConfig;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
public class AccessToken {

    public interface AccessTokenCallback {
        void onGetAccessTokenSuccess(String translatedString);
        void onGetAccessTokenFailure(RetrofitError error);
    }

    private static final String ACCESS_TOKEN_API = "https://datamarket.accesscontrol.windows.net/v2";
    final String GRANT_TYPE = "client_credentials";
    final String SCOPE = "http://api.microsofttranslator.com";

    private AccessTokenApi accessTokenApi;
    private AccessTokenCallback accessTokenCallback;

    public AccessToken() {
        accessTokenApi = new RestAdapter.Builder()
                .setEndpoint(ACCESS_TOKEN_API)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build()
                .create(AccessTokenApi.class);
    }

    public void getAccessToken(AccessTokenCallback accessTokenCallback) {
        this.accessTokenCallback = accessTokenCallback;
        accessTokenApi.getAccessToken(GRANT_TYPE, BuildConfig.CLIENT_ID, BuildConfig.CLIENT_SECRET,
                SCOPE, new GetAccessTokenListener());
    }

    public class GetAccessTokenListener implements Callback<jp.ac.tsukuba.cs.coins_p.aid.handyword.api.schema.AccessToken> {
        @Override
        public void success(jp.ac.tsukuba.cs.coins_p.aid.handyword.api.schema.AccessToken accessToken, Response response) {
            accessTokenCallback.onGetAccessTokenSuccess(accessToken.getAccessToken());
        }

        @Override
        public void failure(RetrofitError error) {
            accessTokenCallback.onGetAccessTokenFailure(error);
        }
    }
}
