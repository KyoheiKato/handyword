package jp.ac.tsukuba.cs.coins_p.aid.handyword.communication;

import jp.ac.tsukuba.cs.coins_p.aid.handyword.pojo.AccessTokenResult;
import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;
public interface AccessTokenApi {
    /**
     * アノテーションでGET/POST/PUT/DELETEを指定。
     * カッコ内はリクエストのホスト部以降を指定。
     *
     * 戻り型をvoidとすることで勝手に別スレッドで通信処理を行ってくれる。
     *
     * コールバックにPOJOのオブジェクトを指定するとPOJO変換してくれる。
     */
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