package com.example.hsuser4.poll_messenger.Activities.Activities.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hsuser4 on 2017/02/14.
 */

public class Poll_Answer {
    @SerializedName("answer_id")
    int answer_id;
    @SerializedName("answer")
    int answer;

    public int getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(int answer_id) {
        this.answer_id = answer_id;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }




}
