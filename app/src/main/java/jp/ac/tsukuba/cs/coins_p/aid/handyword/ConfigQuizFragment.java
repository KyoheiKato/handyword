package jp.ac.tsukuba.cs.coins_p.aid.handyword;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ConfigQuizFragment extends Fragment {
    private OnStartButtonClickedListener mListener;

    public ConfigQuizFragment() {}

    public static ConfigQuizFragment newInstance() {
        ConfigQuizFragment fragment = new ConfigQuizFragment();
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
        Button button = (Button)getActivity().findViewById(R.id.button_start);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            mListener.onStartButtonClicked();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_config_quiz, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnStartButtonClickedListener) {
            mListener = (OnStartButtonClickedListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnStartButtonClickedListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnStartButtonClickedListener {
        void onStartButtonClicked();
    }
}
