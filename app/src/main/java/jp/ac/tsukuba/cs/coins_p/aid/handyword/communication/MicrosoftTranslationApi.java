package jp.ac.tsukuba.cs.coins_p.aid.handyword.communication;

import jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.pojo.AccessToken;
import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;
public interface MicrosoftTranslationApi {
    /**
     * アノテーションでGET/POST/PUT/DELETEを指定。
     * カッコ内はリクエストのホスト部以降を指定。
     *
     * 戻り型をvoidとすることで勝手に別スレッドで通信処理を行ってくれる。
     *
     * メソッドの引数とアノテーションの組み合わせで
     * リクエストパラメータを生成する。
     * 下記の例では?name="hoge"が付与される
     *
     * コールバックにPOJOのオブジェクトを指定するとPOJO変換してくれる。
     */
    @FormUrlEncoded
    @POST("/OAuth2-13")
    void getAccessToken(@Field("grant_type") String grantType, @Field("client_id") String clientId,
                        @Field("client_secret") String clientSecret,
                        @Field("scope") String scope,
                        Callback<AccessToken> cb);
}