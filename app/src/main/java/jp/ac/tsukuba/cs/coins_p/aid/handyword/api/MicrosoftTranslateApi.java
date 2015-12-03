package jp.ac.tsukuba.cs.coins_p.aid.handyword.api;

import jp.ac.tsukuba.cs.coins_p.aid.handyword.api.schema.AccessToken;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.api.schema.Translation;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;
import rx.Observable;

public interface MicrosoftTranslateApi {
    @FormUrlEncoded
    @POST("/OAuth2-13")
    Observable<AccessToken> getAccessToken(
            @Field("grant_type") String grantType,
            @Field("client_id") String clientId,
            @Field("client_secret") String clientSecret,
            @Field("scope") String scope
    );

    @GET("/Translate")
    Observable<Translation> getTranslatedWord(
            @Query("appId") String appId,
            @Query("text") String text,
            @Query("from") String from,
            @Query("to") String to,
            @Query("contentType") String contentType,
            @Query("category") String category
    );
}
