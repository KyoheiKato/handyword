package jp.ac.tsukuba.cs.coins_p.aid.handyword.communication;

import android.util.Log;

import jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.RetroFit.RetroFitApi;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.jsonschema2pojo.searchDicItem.SearchDicItemResult;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.converter.SimpleXMLConverter;

public class CommunicationSample {

    private static final String API = "http://public.dejizo.jp/NetDicV09.asmx";
    private RetroFitApi retroFitApi;

    public void CommunicationSample() {
        SearchDicItemResult searchDicItemResult;
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(API)
                .setConverter(new SimpleXMLConverter())
                .build();
        retroFitApi = restAdapter.create(RetroFitApi.class);

    }

    public void sampleQuery(){
        retroFitApi.getSearchDicItemResult("EJdict", "dict", "HEADWORD", "STARTWITH", "AND", "XHTML", "20", "0",
                new GetDicItemResultListener());
    }

    public class GetDicItemResultListener implements Callback<SearchDicItemResult> {
        @Override
        public void success(SearchDicItemResult searchDicItemResult, Response response) {
            Log.d("rest", "onSuccess!!!");
        }

        @Override
        public void failure(RetrofitError error) {
            Log.d("rest", "onFailure!!!");
        }
    }
}
