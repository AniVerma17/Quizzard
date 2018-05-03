package com.animesh.quizzard.Data;

import android.content.Context;

import com.animesh.quizzard.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class QuizRender {

    private static QuizModel[] mQuizList;
    private Context mContext;

    public QuizRender(Context ctx){
        this.mContext = ctx;
    }

    public QuizModel[] getQuiz() {
        String json = mContext.getString(R.string.json_data);
        Gson gs = new GsonBuilder().create();
        mQuizList = gs.fromJson(json, QuizModel[].class);
        return mQuizList;
    }
}
