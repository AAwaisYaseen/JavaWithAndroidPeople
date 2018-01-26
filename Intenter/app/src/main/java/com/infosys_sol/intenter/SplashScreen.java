package com.infosys_sol.intenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        myIoStroperMethod();
    }




    public void myIoStroperMethod(){

       Thread mThread = new Thread(){

           @Override
           public void run() {
               super.run();

               try {
                   sleep(5000);

                   Intent mIntent = new Intent(SplashScreen.this,MainActivity.class);
                   startActivity(mIntent);
                   finish();

               } catch (InterruptedException e) {
                   e.printStackTrace();
               }

           }
       };

        mThread.start();

    }




}
