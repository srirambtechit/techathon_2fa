package com.example.vidyavijayakumar.rbsmobilebanking;

import android.content.ComponentCallbacks;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class sign_up extends AppCompatActivity implements ComponentCallbacks{

    private String hostURL="xx";
    EditText txtHostName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        txtHostName = (EditText) findViewById(R.id.hostName);



    }

    public void callSignIn(View v){

        hostURL=txtHostName.getText().toString();
        System.out.println(txtHostName.getText().toString());
        System.out.println("hostname in sign up page"+hostURL);


        Intent serviceIntent=new Intent(this, httpService.class);

        System.out.println("hostname in sign up page"+hostURL);

        serviceIntent.putExtra("hostName",hostURL);
        startService(serviceIntent);



        Intent intent = new Intent(sign_up.this, sign_in.class);
            startActivity(intent);
        }

}
