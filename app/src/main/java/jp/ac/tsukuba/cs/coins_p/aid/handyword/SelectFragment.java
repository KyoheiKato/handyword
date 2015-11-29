package jp.ac.tsukuba.cs.coins_p.aid.handyword;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class SelectFragment extends Fragment {

    private static final String WEAK = "weak";
    private static final String LEARNED = "learned";
    private static final String NOT_LEARNED = "not_learned";
    private static final String ALL = "all";
    private static final String QUESTION_TYPE = "question_type";

    private String mQuestionType;

    private SelectFragmentCallback mListener;

    public interface SelectFragmentCallback {
        void onWordCardsSelected();
        void onQuizSelected();
    }

    public SelectFragment() {}

    public static SelectFragment newInstance(String question_type) {
        SelectFragment fragment = new SelectFragment();
        Bundle args = new Bundle();
        args.putString(QUESTION_TYPE, question_type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mQuestionType = getArguments().getString(QUESTION_TYPE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_select, container, false);
    }

    @Override
    public void onStart(){
        super.onStart();
        initTextView();
        initButtons();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof SelectFragmentCallback) {
            mListener = (SelectFragmentCallback) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement SelectFragmentCallback");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void initTextView(){
        TextView textView = (TextView)getActivity().findViewById(R.id.text_question_type);
        textView.setText(getQuestionTypeText(mQuestionType));
    }

    public void initButtons(){
        Button quizButton = (Button)getActivity().findViewById(R.id.button_quiz);
        quizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onQuizSelected();
            }
        });
        Button wordCardsButton = (Button)getActivity().findViewById(R.id.button_word_card);
        wordCardsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onWordCardsSelected();
            }
        });
    }

    public String getQuestionTypeText(String questionType){
        String response;
        switch (questionType){
            case WEAK:
                response = "苦手な単語";
                break;
            case LEARNED:
                response = "最近覚えた単語";
                break;
            case NOT_LEARNED:
                response = "まだ覚えていない単語";
                break;
            case ALL:
                response = "すべての単語";
                break;
            default:
                response = "すべての単語";
                break;
        }
        return response;
    }

}
