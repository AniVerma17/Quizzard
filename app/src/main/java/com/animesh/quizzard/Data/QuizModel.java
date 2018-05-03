package com.animesh.quizzard.Data;

//Data model for quiz questions
public class QuizModel {
    //Question string
    private String ques;

    //Options
    private String option1;
    private String option2;
    private String option3;

    //Correct answer
    private String answer;

    //Setters and getters
    public String getQues() {
        return ques;
    }

    public void setQues(String ques) {
        this.ques = ques;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String optionA) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String optionB) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOptionC(String optionC) {
        this.option3 = option3;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
