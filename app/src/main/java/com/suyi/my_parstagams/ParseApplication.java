package com.suyi.my_parstagams;

import android.app.Application;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("oAtnYGH9248ARLn7YDZbwnbTCzU2MVOcgfjTqQqZ")
                .clientKey("AmtEQzGnPPbTZ4AuZYjUogCFbjY1rSVeyyvDa2dG")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
