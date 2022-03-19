package com.suyi.my_parstagams;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("oAtnYGH9248ARLn7YDZbwnbTCzU2MVOcgfjTqQqZ")
                .clientKey("AmtEQzGnPPbTZ4AuZYjUogCFbjY1rSVeyyvDa2dG")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
