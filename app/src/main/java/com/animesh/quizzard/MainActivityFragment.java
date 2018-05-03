package com.animesh.quizzard;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.animesh.quizzard.Data.QuizModel;
import com.animesh.quizzard.Data.QuizRender;

public class MainActivityFragment extends Fragment {

    private RecyclerView mQuizView;
    private FloatingActionButton submitButton;
    private QuizModel[] mQuizList;
    private QuizAdapter qAdapter;

    private boolean[] answerCheck;
    private int score = 0;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        mQuizView = root.findViewById(R.id.quiz_view);
        submitButton = root.findViewById(R.id.button_submit);
        QuizRender render = new QuizRender(getActivity());
        mQuizList = render.getQuiz();
        answerCheck = new boolean[mQuizList.length];
        mQuizView.setLayoutManager(new LinearLayoutManager(getActivity()));
        qAdapter = new QuizAdapter(getActivity(), mQuizList, answerCheck);
        mQuizView.setAdapter(qAdapter);
        mQuizView.setItemAnimator(new DefaultItemAnimator());
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answerCheck = qAdapter.getAnswered();
                for(boolean flag:answerCheck){
                    if(flag)
                        score++;
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Quiz Result");
                builder.setMessage("You scored "+ score +"/"+ answerCheck.length);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        score = 0;
                    }
                });
                builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        score = 0;
                    }
                });
                AlertDialog resultDialog = builder.create();
                resultDialog.show();
            }
        });
        return root;
    }

}
