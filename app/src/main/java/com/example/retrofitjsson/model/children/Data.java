package com.example.retrofitjsson.model.children;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("subreddit")
    @Expose
    private String subreddit;

    @SerializedName("author_fullname")
    @Expose
    private String author_fullname;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubreddit() {
        return subreddit;
    }

    public void setSubreddit(String subreddit) {
        this.subreddit = subreddit;
    }

    public String getAuthor_fullname() {
        return author_fullname;
    }

    public void setAuthor_fullname(String author_fullname) {
        this.author_fullname = author_fullname;
    }

    @Override
    public String toString() {
        return "Data{" +
                "title='" + title + '\'' +
                ", subreddit='" + subreddit + '\'' +
                ", author_fullname='" + author_fullname + '\'' +
                '}';
    }
}

