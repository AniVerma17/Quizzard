package com.animesh.quizzard;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.animesh.quizzard.Data.QuizModel;

public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.QuizItemHolder>{
    private QuizModel[] mQuizList;
    private Context mContext;

    private boolean[] ans;

    public QuizAdapter(Context ctx, QuizModel[] ql, boolean[] ans){
        this.mContext = ctx;
        this.mQuizList = ql;
        this.ans = ans;
    }

    @NonNull
    @Override
    public QuizItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_quiz_item, parent, false);
        QuizItemHolder viewHolder = new QuizItemHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final QuizItemHolder holder, final int position) {
        final QuizModel qItem = mQuizList[position];

        holder.q.setText(qItem.getQues());
        holder.opt1.setText(qItem.getOption1());
        holder.opt2.setText(qItem.getOption2());
        holder.opt3.setText(qItem.getOption3());
        holder.opt_radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String checkedAns = "NA";
                switch (checkedId){
                    case R.id.opt1: checkedAns = holder.opt1.getText().toString();break;
                    case R.id.opt2: checkedAns = holder.opt2.getText().toString();break;
                    case R.id.opt3: checkedAns = holder.opt3.getText().toString();break;
                }
                ans[position] = checkedAns.equalsIgnoreCase(qItem.getAnswer());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mQuizList.length;
    }

    public boolean[] getAnswered(){
        return ans;
    }

    class QuizItemHolder extends RecyclerView.ViewHolder{

        TextView q;
        RadioGroup opt_radio;
        RadioButton opt1, opt2, opt3;

        QuizItemHolder(View v){
            super(v);
            q = v.findViewById(R.id.textQues);
            opt_radio = v.findViewById(R.id.option_set);
            opt1 = v.findViewById(R.id.opt1);
            opt2 = v.findViewById(R.id.opt2);
            opt3 = v.findViewById(R.id.opt3);
        }
    }
}
