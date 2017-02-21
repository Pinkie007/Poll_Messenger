package com.example.hsuser4.poll_messenger.Activities.Activities.Model;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by hsuser4 on 2017/02/21.
 */

public class PollAnswerModel extends RealmObject {

    @PrimaryKey
    @SerializedName("answer_id")
    public int answerID;

    @SerializedName("answer")
    public String answerDescription;

    @SerializedName("poll_guid")
    public String pollIdentifier;

    public int getAnswerID() {
        return answerID;
    }

    public void setAnswerID(int answerID) {
        this.answerID = answerID;
    }

    public String getAnswerDescription() {
        return answerDescription;
    }

    public void setAnswerDescription(String answerDescription) {
        this.answerDescription = answerDescription;
    }

    public String getPollIdentifier() {
        return pollIdentifier;
    }

    public void setPollIdentifier(String pollIdentifier) {
        this.pollIdentifier = pollIdentifier;
    }
}
