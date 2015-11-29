package jp.ac.tsukuba.cs.coins_p.aid.handyword;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class AnswerFragment extends Fragment {

    private AnswerFragmentCallback mCallback;

    public AnswerFragment() {}

    public static AnswerFragment newInstance() {
        AnswerFragment fragment = new AnswerFragment();
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
        return inflater.inflate(R.layout.fragment_answer, container, false);
    }
    @Override
    public void onStart(){
        super.onStart();
        initButtons();
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof AnswerFragmentCallback) {
            mCallback = (AnswerFragmentCallback) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement AnswerFragmentCallback");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallback = null;
    }

    public void initButtons(){
        Button correctButton = (Button)getActivity().findViewById(R.id.button_correct);
        correctButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.onCorrectButtonClicked();
            }
        });
        Button wrongButton = (Button)getActivity().findViewById(R.id.button_wrong);
        wrongButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.onWrongButtonClicked();
            }
        });}

    public interface AnswerFragmentCallback {
        void onCorrectButtonClicked();
        void onWrongButtonClicked();
    }
}
