package jp.ac.tsukuba.cs.coins_p.aid.handyword.communication;

import android.util.Log;

import jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.RetroFit.dejizoApi;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.jsonschema2pojo.getDicItem.GetDicItemResult;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.jsonschema2pojo.searchDicItem.DicItemTitle;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.jsonschema2pojo.searchDicItem.SearchDicItemResult;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.converter.SimpleXMLConverter;

public class CommunicationSample {

    private static final String API = "http://public.dejizo.jp/NetDicV09.asmx";
    private dejizoApi dejizoApi;
    private SimpleXMLConverter simpleXMLConverter = new SimpleXMLConverter();

    public void CommunicationSample() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(API)
                .setConverter(simpleXMLConverter)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        dejizoApi = restAdapter.create(dejizoApi.class);
    }

    public void sampleQuery(){
        dejizoApi.getSearchDicItemResult("EJdict", "dict", "HEADWORD", "STARTWITH", "AND", "XHTML",
                "20", "0", new GetDicItemResultListener());
        dejizoApi.getDicItem("EJdict", "011357", "", "XHTML", new GetDicItemListener());
    }

    public class GetDicItemResultListener implements Callback<SearchDicItemResult> {
        @Override
        public void success(SearchDicItemResult searchDicItemResult, Response response) {
            Log.d("GetDicItemResult", "onSuccess!!!");
        }

        @Override
        public void failure(RetrofitError error) {
            Log.d("GetDicItemResult", "onFailure!!!" + error);
        }
    }

    public class GetDicItemListener implements Callback<GetDicItemResult> {
        @Override
        public void success(GetDicItemResult GetDicItemResult, Response response) {
            Log.d("GetDicItem", "onSuccess!!!");
        }

        @Override
        public void failure(RetrofitError error) {
            Log.d("GetDicItem", "onFailure!!!" + error);
        }
    }
}
