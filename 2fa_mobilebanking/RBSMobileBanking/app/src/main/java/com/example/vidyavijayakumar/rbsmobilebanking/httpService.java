package com.example.vidyavijayakumar.rbsmobilebanking;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

import static com.example.vidyavijayakumar.rbsmobilebanking.Notification.CHANNEL_1_ID;


public class httpService extends Service implements ComponentCallbacks{

    public String hostURL;


         public String transactionStatus;

         @Override
         public void onCreate() {
             super.onCreate();


         }

         @Override
         public int onStartCommand(Intent intent, int flags, int startId) {
             Toast.makeText(this, "service is started...", Toast.LENGTH_LONG).show();

            hostURL= intent.getStringExtra("hostName");
             System.out.println("hostname in service"+hostURL);

             TimerTask task = new TimerTask(){
                 @Override
                 public void run(){

                      new MyPollTask().execute();
                 }

             } ;new Timer().scheduleAtFixedRate(task,10000,30000);




             return START_STICKY;
         }

         class MyPollTask extends AsyncTask<Void, Void, Integer> {



             protected void onPreExecute() {

                System.out.println("in the pre execute");
             }



             protected Integer doInBackground(Void... params) {

                 Integer response = 0;
                 HttpURLConnection con=null;
                 System.out.println("hosturl is"+hostURL);
                 try {
                   //  URL url = new URL("https://api.myjson.com/bins/9so8s");
                     URL url = new URL("http://"+hostURL+"/rbs2fa/api/auths/4331");
                     con = (HttpURLConnection) url.openConnection();

                         InputStream in = new BufferedInputStream(con.getInputStream());
                         BufferedReader br = new BufferedReader(new InputStreamReader(in));
                         StringBuilder sb = new StringBuilder();
                         String output;

                         while ((output = br.readLine()) != null) {
                             sb.append(output);
                         }


                     JSONObject reader = new JSONObject(sb.toString());


                    try {


                        //JSONObject sys = reader.getString("transaction");
                       String sys1 = reader.getString("transaction");
//                        sys.put("userid", reader.getString(
//                                "userId"
//                        ));
//                        sys.put("mobileId", reader.getString(
//                                "mobileId"
//                        ));

                        System.out.println("Transaction is triggered");
                        reader.put("hostName",hostURL);

                        onPostExecute(1);
                        onPostExecute(reader);
                        transactionStatus=sb.toString();


                    }catch (JSONException e){
                        e.printStackTrace();
                        System.out.println("Transaction is not triggered");
                    }

//                     if(sys.getString("id").isEmpty()){
//                         System.out.println("Transaction is not triggered");
//
//                     }else {
//                         System.out.println("Transaction is triggered");
//
//                         onPostExecute(1);
//                         onPostExecute(sys);
//
//                     }



                 }
                  catch (MalformedURLException e) {
                     e.printStackTrace();

                 } catch (IOException e) {
                     e.printStackTrace();

                 } catch (Exception e) {
                     e.printStackTrace();
                 }finally {
                       con.disconnect();
                    }
                 return
             response;

             }


             protected void onPostExecute(JSONObject result) {

                //try for pending intent notification
                 try {
                     Intent intent = new Intent(getApplicationContext(), sign_in.class);
                     intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0 /* Request code */, intent,
                            PendingIntent.FLAG_ONE_SHOT);


                     Intent secondActivityIntent = new Intent(getApplicationContext(), TransactionActivity.class);
                     System.out.println("string inside post Execute"+result.toString());
                     secondActivityIntent.putExtra("jsonString",result.toString());
                     PendingIntent secondActivityPendingIntent = PendingIntent.getActivity(getApplicationContext(), 0 , secondActivityIntent, PendingIntent.FLAG_ONE_SHOT);


                     Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                     NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(getApplicationContext(),CHANNEL_1_ID)
                             .setSmallIcon(R.drawable.ic_notify)
                             .setContentTitle("Transaction Initiated from your Account!")
                             .setContentText("Is that you??")
                             .addAction(R.drawable.ic_notify,"click to view",secondActivityPendingIntent)
                             //.addAction(R.drawable.ic_lock_pink_700_24dp,"Register",thirdActivityPendingIntent)
                             .setAutoCancel(true)
                             .setSound(defaultSoundUri)
                             .setContentIntent(pendingIntent);

                     NotificationManager notificationManager =
                             (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                     notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
                 } catch (Exception e) {
                     e.printStackTrace();
                 }

                 //till here test and merge

             }



         }


         @Override
         public void onDestroy() {
             Toast.makeText(this, "service is stopped...", Toast.LENGTH_LONG).show();

         }

         @Nullable
         @Override
         public IBinder onBind(Intent intent) {
             return null;
         }


     }
