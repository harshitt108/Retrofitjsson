package com.example.retrofitjsson;

import com.example.retrofitjsson.model.Feed;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface RedditApi {

    String BASE_URL ="https://www.reddit.com/";
    @Headers ( "Content type :application/json" )
    @GET(".json")
    Call <Feed> getData();
}
