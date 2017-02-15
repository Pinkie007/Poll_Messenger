package com.example.hsuser4.poll_messenger.Activities.Activities.Model;

/**
 * Created by hsuser4 on 2017/02/14.
 */

public class PollData {
    //Declare variables
    String poll_guid;
    String question;
    String answer;
    String end_date;
    String start_date;

    public String getPoll_guid() {
        return poll_guid;
    }

    public void setPoll_guid(String poll_guid) {
        this.poll_guid = poll_guid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }



}
