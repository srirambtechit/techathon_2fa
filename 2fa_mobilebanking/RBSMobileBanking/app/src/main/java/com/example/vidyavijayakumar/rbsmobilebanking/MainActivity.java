package com.example.vidyavijayakumar.rbsmobilebanking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void callSignIn(View v){

        Intent intent = new Intent(MainActivity.this, sign_in.class);
        startActivity(intent);
    }

    public void callSignUp(View v){

        Intent intent = new Intent(MainActivity.this, sign_up.class);
        startActivity(intent);
    }
}
