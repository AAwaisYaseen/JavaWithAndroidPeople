package com.infosys_sol.intenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondPageActivity extends AppCompatActivity {

    Button btnGoback;
    TextView txtVuIncomingTxt;
//    boolean tester = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);
        btnGoback = findViewById(R.id.btn_go_back);
        txtVuIncomingTxt = findViewById(R.id.txt_vu_incoming_txt);

        Intent incomingIntent = getIntent();
        String firstName = incomingIntent.getStringExtra("userName");


        txtVuIncomingTxt.setText(firstName);


        btnGoback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


//                Intent mintent = new Intent(SecondPageActivity.this,MainActivity.class);
//                startActivity(mintent);
//                finish();
            }
        });

    }

//    @Override
//    public void onBackPressed() {
//        if(tester){
//            super.onBackPressed();
//        }else{
//
//            Toast.makeText(this, "press again to go back", Toast.LENGTH_SHORT).show();
//        }
//
//    }
}
