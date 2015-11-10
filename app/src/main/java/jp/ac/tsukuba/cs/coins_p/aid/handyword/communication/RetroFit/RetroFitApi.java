package jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.RetroFit;

import jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.jsonschema2pojo.searchDicItem.SearchDicItemResult;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface RetroFitApi {
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
    @GET("/SearchDicItemLite")
    void getSearchDicItemResult(@Query("Dic") String dic, @Query("Word") String word,
                                @Query("Scope") String scope, @Query("Match") String match,
                                @Query("Merge") String merge, @Query("Prof") String prof,
                                @Query("PageSize") String pageSize, @Query("PageIndex") String pageIndex,
                                Callback<SearchDicItemResult> cb);

    @GET("/GetDicItemLite")
    void getDicItem(@Query("Dic") String dic, @Query("Item") String item,
                    @Query("Loc") String loc, @Query("Prof") String prof,
                    Callback<SearchDicItemResult> cb);
}
