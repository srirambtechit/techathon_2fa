package com.example.vidyavijayakumar.rbsmobilebanking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Banking extends AppCompatActivity {

    SessionManagement session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banking);


        session = new SessionManagement(getApplicationContext());


    }


    public void onClicklogout(View arg0) {
        // Clear the session data
        // This will clear all session data and
        // redirect user to LoginActivity
        session.logoutUser();
    }


}

