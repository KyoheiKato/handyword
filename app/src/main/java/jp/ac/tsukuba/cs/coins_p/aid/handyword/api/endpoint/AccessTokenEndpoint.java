package jp.ac.tsukuba.cs.coins_p.aid.handyword.api.endpoint;

import android.util.Log;

import java.util.Calendar;
import java.util.Date;

import jp.ac.tsukuba.cs.coins_p.aid.handyword.BuildConfig;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.api.MicrosoftTranslateApi;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.api.schema.AccessToken;
import retrofit.RestAdapter;
import retrofit.android.AndroidLog;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class AccessTokenEndpoint extends Endpoint {

    private static final String TAG = AccessTokenEndpoint.class.getSimpleName();
    private static final String ACCESS_TOKEN_API = "https://datamarket.accesscontrol.windows.net/v2";
    private static final String GRANT_TYPE = "client_credentials";
    private static final String SCOPE = "http://api.microsofttranslator.com";

    private static AccessTokenEndpoint instance = new AccessTokenEndpoint();

    public interface AccessTokenCallback {
        void doOnNext(AccessToken accessToken);
    }

    public static AccessTokenEndpoint getInstance() {
        return instance;
    }

    private AccessToken currentAccessToken;

    private AccessTokenEndpoint() {
         microsoftTranslateApi = new RestAdapter.Builder()
                 .setEndpoint(ACCESS_TOKEN_API)
                 .setLog(new AndroidLog(TAG))
                 .setLogLevel(RestAdapter.LogLevel.FULL)
                 .build()
                 .create(MicrosoftTranslateApi.class);
        currentAccessToken = null;
    }

    public void getAccessToken(final AccessTokenCallback callback) {
        microsoftTranslateApi.getAccessToken(
                GRANT_TYPE, BuildConfig.CLIENT_ID,
                BuildConfig.CLIENT_SECRET, SCOPE)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.newThread())
        .subscribe(new Subscriber<AccessToken>() {
            @Override
            public void onCompleted() {
                callback.doOnNext(currentAccessToken);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "get access token error", e);
            }

            @Override
            public void onNext(AccessToken accessToken) {
                currentAccessToken = accessToken;
                currentAccessToken.setEffectiveTime(calcEffectiveTime());
            }
        });
    }

    private static Date calcEffectiveTime() {
        final long tenMinutesMillis = 60000 * 10;
        Calendar calendar = Calendar.getInstance();

        return new Date(calendar.getTimeInMillis() + tenMinutesMillis);
    }

    public boolean isAccessTokenEffective() {
        return currentAccessToken != null && currentAccessToken.getEffectiveTime().before(new Date());
    }

    public AccessToken getCurrentAccessToken() {
        return currentAccessToken;
    }
}
