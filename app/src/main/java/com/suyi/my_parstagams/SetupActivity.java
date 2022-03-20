package com.suyi.my_parstagams;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SetupActivity extends AppCompatActivity {

    public static final String TAG = "SetupActivity";
    private EditText etUserName;
    private EditText etPassword;
    private Button btnCreate;
    private Button btnToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        etUserName = findViewById(R.id.etUserName2);
        etPassword = findViewById(R.id.etPassword2);
        btnCreate = findViewById(R.id.btnCreate);
        btnToLogin = findViewById(R.id.btnToLogin);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG,"onClick create button");
                String username = etUserName.getText().toString();
                String password = etPassword.getText().toString();
                setupUser(username,password);
            }
        });

        btnToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG,"onClick to Login button");
                goLoginPage();
            }
        });
    }

    private void goLoginPage() {
        Intent i = new Intent(this,LoginActivity.class);
        startActivity(i);
        finish();
    }

    private void setupUser(String username, String password) {
        Log.i(TAG,"Attempting to setup user" + username);
        // Create the ParseUser
        ParseUser user = new ParseUser();
        // Set core properties
        user.setUsername(username);
        user.setPassword(password);
        // Invoke signUpInBackground
        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    // Hooray! Let them use the app now.
                    goLoginPage();
                } else {
                    Log.e(TAG,"Issue with Setup", e);
                    // Sign up didn't succeed. Look at the ParseException
                    // to figure out what went wrong
                }
            }
        });
    }
}
