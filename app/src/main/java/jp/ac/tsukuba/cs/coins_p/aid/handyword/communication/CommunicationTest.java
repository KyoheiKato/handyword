package jp.ac.tsukuba.cs.coins_p.aid.handyword.communication;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.RetroFit.RequestCallback;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.RetroFit.RequestListener;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.RetroFit.RetroFitApi;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.communication.rest.getDicItem.GetDicItemResult;
import retrofit.RestAdapter;
import retrofit.RetrofitError;

public class CommunicationTest extends AppCompatActivity {
    private static final String API = "http://public.dejizo.jp/NetDicV09.asmx";

    RestAdapter restAdapter = new RestAdapter.Builder()
        .setEndpoint(API)
        .build();
    RetroFitApi api = restAdapter.create(RetroFitApi.class);
    //api.getSearchDicItem("EJdict", "dict", "HEADWORD", "STARTWITH", "AND", "XHTML", "20", "0");

    public class GetDicItemResultListener implements RequestListener<GetDicItemResult> {
        @Override
        public void onSuccess(GetDicItemResult response) {
            Log.d("rest", "onSuccess!!!");
        }
        @Override
        public void onFailure(RetrofitError error) {
            Log.d("rest", "onFailure!!!");
        }
    }
}
