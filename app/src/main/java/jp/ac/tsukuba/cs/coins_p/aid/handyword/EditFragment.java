package jp.ac.tsukuba.cs.coins_p.aid.handyword;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

import jp.ac.tsukuba.cs.coins_p.aid.handyword.database.model.WordCardModel;
import jp.ac.tsukuba.cs.coins_p.aid.handyword.database.schema.WordCard;


public class EditFragment extends Fragment {
    private OnFragmentInteractionListener mListener;

    public EditFragment() {}

    public static EditFragment newInstance() {
        EditFragment fragment = new EditFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart(){
        super.onStart();
        Button button = (Button)getActivity().findViewById(R.id.button_register);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText japanese = (EditText)getActivity().findViewById(R.id.japanese);
                EditText english = (EditText)getActivity().findViewById(R.id.english);

                WordCard wordCard = new WordCard();
                wordCard.setWord(japanese.getText().toString());
                wordCard.setTranslatedWord(english.getText().toString());
                wordCard.setCreatedAt(new Date());
                wordCard.setUpdatedAt(new Date());

                WordCardModel.getInstance().saveWordCard(wordCard);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_edit, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement AnswerFragmentCallback");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction();
    }
}
