package com.infosys_sol.intenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondPageActivity extends AppCompatActivity {

    Button btnGoback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);
        btnGoback = findViewById(R.id.btn_go_back);

        btnGoback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mintent = new Intent(SecondPageActivity.this,MainActivity.class);
                startActivity(mintent);
                finish();

            }
        });
    }
}
