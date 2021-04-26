package com.example.retrofitapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiModel implements Parcelable {
    public static final Creator<ApiModel> CREATOR = new Creator<ApiModel>() {
        @Override
        public ApiModel createFromParcel(Parcel in) {
            return new ApiModel(in);
        }

        @Override
        public ApiModel[] newArray(int size) {
            return new ApiModel[size];
        }
    };
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("bio")
    @Expose
    public String bio;
    @SerializedName("realname")
    @Expose
    private String realname;
    @SerializedName("team")
    @Expose
    private String team;
    @SerializedName("firstappearance")
    @Expose
    private String firstappearance;
    @SerializedName("createdby")
    @Expose
    private String createdby;
    @SerializedName("publisher")
    @Expose
    private String publisher;
    @SerializedName("imageurl")
    @Expose
    private String imageurl;

    public ApiModel(Parcel in) {
        name = in.readString();
        realname = in.readString();
        team = in.readString();
        firstappearance = in.readString();
        createdby = in.readString();
        publisher = in.readString();
        imageurl = in.readString();
        bio = in.readString();
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getFirstappearance() {
        return firstappearance;
    }

    public void setFirstappearance(String firstappearance) {
        this.firstappearance = firstappearance;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(realname);
        parcel.writeString(team);
        parcel.writeString(firstappearance);
        parcel.writeString(createdby);
        parcel.writeString(publisher);
        parcel.writeString(imageurl);
        parcel.writeString(bio);
    }
}

