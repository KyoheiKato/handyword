package jp.ac.tsukuba.cs.coins_p.aid.handyword.api;

import jp.ac.tsukuba.cs.coins_p.aid.handyword.pojo.TranslationResult;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface TranslationApi {
    @GET("/Translate")
    void translate(@Query("appId") String appId, @Query("text") String text,
                   @Query("from") String from, @Query("to") String to,
                   @Query("contentType") String contentType, @Query("category") String category,
                   Callback<TranslationResult> cb);

    @GET("/Translate")
    TranslationResult translate(@Query("appId") String appId, @Query("text") String text,
                   @Query("from") String from, @Query("to") String to,
                   @Query("contentType") String contentType, @Query("category") String category);
}
