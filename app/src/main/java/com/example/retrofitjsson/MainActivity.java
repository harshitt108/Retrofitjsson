package com.example.retrofitjsson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.example.retrofitjsson.model.Feed;
import com.example.retrofitjsson.model.children.Children;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String BASE_URL ="https://www.reddit.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        Button button =(Button) findViewById ( R.id.btnGetData );

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl ( BASE_URL )
                .addConverterFactory ( GsonConverterFactory.create () )
                .build ();

        RedditApi redditApi = retrofit.create ( RedditApi.class );
        Call <Feed> call =redditApi.getData ();

        call.enqueue ( new Callback <Feed> ( ) {
            @Override
            public void onResponse(Call <Feed> call , Response <Feed> response) {
                Log.d ( "","on Response : server response:"+ response.toString () );
                Log.d ("","on Response: received information" +response.body ().toString ());

                ArrayList<Children> childrenList = response.body().getData ().getChildren ();
                for(int i=0;i<=childrenList.size ();i++){

                    Log.d ( "","onResponse:\n"+
                            "kind: " +childrenList.get ( i ).getKind () + "\n"+
                            "get title: " + childrenList.get(i).getData ().getTitle () +"\n"+
                            "subredit: " +childrenList.get ( i ).getData ().getSubreddit () +"\n"+
                            "auther_fullname : " +childrenList.get(i).getData ().getAuthor_fullname () + "\n"+
                                    "------------------------------------------------------------\n\n" );
                }

            }

            @Override
            public void onFailure(Call <Feed> call , Throwable t) {

                Log.e("onFailure","Something went wrong"+t.getMessage ());
                Toast.makeText (MainActivity.this,"Something went Wrong" ,Toast.LENGTH_SHORT).show();

            }
        } );

    }
}