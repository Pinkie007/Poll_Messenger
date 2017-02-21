package com.example.hsuser4.poll_messenger.Activities.Activities.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by hsuser4 on 2017/02/20.
 */

public class PostModel {
    //Declare variables
    @SerializedName("pollGuid")
    String poll_guid;
    @SerializedName("ansId")
    private List<PostModel>ansId;
    String location;
    String manufacturer;
    String device_model;
    String os_version;
    String user_name;
    String user_id;
    String date_voted;

    public String getPoll_guid() {
        return poll_guid;
    }

    public void setPoll_guid(String poll_guid) {
        this.poll_guid = poll_guid;
    }

    public List<PostModel> getAnsId() {
        return ansId;
    }

    public void setAnsId(List<PostModel> ansId) {
        this.ansId = ansId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDevice_model() {
        return device_model;
    }

    public void setDevice_model(String device_model) {
        this.device_model = device_model;
    }

    public String getOs_version() {
        return os_version;
    }

    public void setOs_version(String os_version) {
        this.os_version = os_version;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getDate_voted() {
        return date_voted;
    }

    public void setDate_voted(String date_voted) {
        this.date_voted = date_voted;
    }




}