package com.example.hsuser4.poll_messenger.Activities.Activities.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by hsuser4 on 2017/02/09.
 */

public class DisplayRecords {
    //Declare variables
    @SerializedName("poll_guid")
    String poll_guid;
    @SerializedName("poll_title")
    String poll_title;
    @SerializedName("poll_description")
    String poll_description;
    @SerializedName("question")
    String question;
    @SerializedName("answers")
    private ArrayList<DisplayRecords> Answers;
    @SerializedName("start_date")
    String start_date;
    @SerializedName("end_date")
    String end_date;
    @SerializedName("thanks_message")
    String thanks_message;
    @SerializedName("closed_message")
    String closed_message;
    @SerializedName("notification_text")
    String notification_text;
    @SerializedName("share_url")
    String share_url;
    @SerializedName("author")
    String author;
    @SerializedName("ans_count")
    int ans_count;


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
    public String getPoll_description() {
        return poll_description;
    }

    public void setPoll_description(String poll_description) {
        this.poll_description = poll_description;
    }

    public String getquestion() {
        return question;
    }

    public void setPoll_question(String question) {
        this.question = question;
    }

    public ArrayList<DisplayRecords> getAnswers() {
        return Answers;
    }

    public void setAnswers(ArrayList<DisplayRecords> answers) {
        Answers = answers;
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


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getThanks_message() {
        return thanks_message;
    }

    public void setThanks_message(String thanks_message) {
        this.thanks_message = thanks_message;
    }

    public String getClosed_message() {
        return closed_message;
    }

    public void setClosed_message(String closed_message) {
        this.closed_message = closed_message;
    }

    public String getNotification_text() {
        return notification_text;
    }

    public void setNotification_text(String notification_text) {
        this.notification_text = notification_text;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public int getAns_count() {
        return ans_count;
    }

    public void setAns_count(int ans_count) {
        this.ans_count = ans_count;
    }

}
