package com.example.vidyavijayakumar.rbsmobilebanking;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class TransactionActivity extends AppCompatActivity {

    String jsonString;
    JSONObject transaction;
    JSONObject transact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);

        Intent intent = getIntent();

        jsonString = intent.getStringExtra("jsonString");
        System.out.println("jsonString check"+jsonString);

        //converting to json again here
        try {
            transaction = new JSONObject(jsonString);


            transact= transaction.getJSONObject("transaction");

            TextView idTextView = (TextView) findViewById(R.id.text_view_id);
            idTextView.setText("ID : "+transact.getString("id"));

            TextView accountTextView = (TextView) findViewById(R.id.textView_toAcc);
          accountTextView.setText("To :"+transact.getString("toAccount"));

            TextView amountTextView = (TextView) findViewById(R.id.textView_toAmt);
            amountTextView.setText("Amount :" +transact.getString("amount"));

            TextView createdTextView = (TextView) findViewById(R.id.textView_created);
            createdTextView.setText("Created at :"+ transaction.getString("customerId"));

        }catch(JSONException e){
            e.printStackTrace();
        }

        //Setting the ui



    }

    public void postYes(View v){
        AsyncT asyncT = new AsyncT("true");
        asyncT.execute();

        // Alert Dialog Manager
        AlertDialogManager alert = new AlertDialogManager();
        alert.showAlertDialog(TransactionActivity.this, "Transaction Status","Approved ", true);

        Intent intent=new Intent(this, Banking.class);
        startActivity(intent);



    }

    public void postNo(View v){
        AsyncT asyncT = new AsyncT("false");
        asyncT.execute();

        AlertDialogManager alert = new AlertDialogManager();
        alert.showAlertDialog(TransactionActivity.this, "Transaction Status","Cancelled", false);

        Intent intent=new Intent(this, Banking.class);
        startActivity(intent);

    }

    class AsyncT extends AsyncTask<Void,Void,Void> {
        String userStatus="";

        public AsyncT(String showLoading) {
            super();
            userStatus=showLoading;
            // do stuff
        }

        @Override
        protected Void doInBackground(Void... params) {

            try {

               // URL url = new URL("https://google.com"); //Enter URL here
                System.out.println("http://"+transaction.getString("hostName")+"/rbs2fa/api/acks");
                System.out.println("see here...");
                URL url = new URL("http://"+transaction.getString("hostName")+"/rbs2fa/api/acks");
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setConnectTimeout(15000);
                httpURLConnection.setReadTimeout(15000);
                httpURLConnection.setRequestMethod("POST"); // here you are telling that it is a POST request, which can be changed into "PUT", "GET", "DELETE" etc.
                httpURLConnection.setRequestProperty("Content-Type", "application/json");
                // here you are setting the `Content-Type` for the data you are sending which is `application/json`
                httpURLConnection.connect();

                JSONObject jsonObject = new JSONObject();
                jsonObject.put("customerId",transaction.getString("customerId"));
                jsonObject.put("mobileId",transaction.getString("mobileId"));

                JSONObject interiorJSON=new JSONObject();
                interiorJSON.put("id",transact.getString("id"));
                interiorJSON.put("authorized",userStatus);
                jsonObject.putOpt("transaction",interiorJSON);
                System.out.println(jsonObject);

                OutputStream httpOutputStream = httpURLConnection.getOutputStream();
                BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(httpOutputStream, "UTF-8"));
                wr.write(jsonObject.toString());
                wr.flush();
                wr.close();
                httpOutputStream.close();


                System.out.println("respCode : " + httpURLConnection.getResponseCode());


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }catch (Throwable e){
                e.printStackTrace();
            }

            return null;
        }


    }

}



