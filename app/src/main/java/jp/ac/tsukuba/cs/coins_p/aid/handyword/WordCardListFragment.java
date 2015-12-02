package jp.ac.tsukuba.cs.coins_p.aid.handyword;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import jp.ac.tsukuba.cs.coins_p.aid.handyword.database.model.WordCardModel;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.database.schema.WordCard;


public class WordCardListFragment extends Fragment {
    private OnItemClickListener mListener;

    public WordCardListFragment() {}
    public static WordCardListFragment newInstance() {
        WordCardListFragment fragment = new WordCardListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_word_card_list, container, false);
    }

    @Override
    public void onStart(){
        super.onStart();
        initListView();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnItemClickListener) {
            mListener = (OnItemClickListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnItemClickListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void initListView(){
        ListView lv = (ListView)getActivity().findViewById(R.id.list_view);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mListener.onItemClick(parent, view, position, id);
            }
        });
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_expandable_list_item_1, getStringArray());

        lv.setAdapter(adapter);
    }

    public String[] getStringArray(){
        List<WordCard> words = WordCardModel.getInstance().findAll();
        String[] stringArray = new String[words.size()];
        for ( int i = 0; i < words.size(); ++i ) {
            stringArray[i] = words.get(i).getTranslatedWord();
            Log.d("wordCard : ", stringArray[i]);
        }
        return stringArray;
    }

    public interface OnItemClickListener {
        void onItemClick(AdapterView<?> parent, View view, int position, long id);
    }
}