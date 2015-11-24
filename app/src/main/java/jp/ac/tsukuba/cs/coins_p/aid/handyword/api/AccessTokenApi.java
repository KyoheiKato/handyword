package jp.ac.tsukuba.cs.coins_p.aid.handyword.api;

import jp.ac.tsukuba.cs.coins_p.aid.handyword.pojo.AccessTokenResult;
import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;
public interface AccessTokenApi {

    @FormUrlEncoded
    @POST("/OAuth2-13")
    void getAccessToken(@Field("grant_type") String grantType, @Field("client_id") String clientId,
                        @Field("client_secret") String clientSecret,
                        @Field("scope") String scope,
                        Callback<AccessTokenResult> cb);

    @FormUrlEncoded
    @POST("/OAuth2-13")
    AccessTokenResult getAccessToken(@Field("grant_type") String grantType, @Field("client_id") String clientId,
                        @Field("client_secret") String clientSecret,
                        @Field("scope") String scope);
}