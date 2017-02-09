package com.example.hsuser4.poll_messenger.Activities.Activities.Model;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


class save_polls extends RealmObject {

    //Declare variables
    @PrimaryKey
    String poll_guid;
    String poll_title;
    String question;
    String start_date;
    String end_date;
    private ArrayList<save_polls> Answers;


   public void setAnswer(List<String> answer) {
        this.answer = answer;
    }

    private List<String> answer;

    public String getPoll_guid() {
        return poll_guid;
    }

    public void setPoll_guid(String poll_guid) {
        this.poll_guid = poll_guid;
    }

    public String getPoll_title() {
        return poll_title;
    }

    public void setPoll_title(String poll_title) {
        this.poll_title = poll_title;
    }

    public String getquestion() {
        return question;
    }

    public void setPoll_question(String question) {
        this.question = question;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

}
