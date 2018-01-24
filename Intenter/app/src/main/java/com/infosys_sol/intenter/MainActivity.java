package com.infosys_sol.intenter;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fabTester;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fabTester = findViewById(R.id.fab_tester);

        fabTester.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent mintent = new Intent(MainActivity.this,SecondPageActivity.class);
                startActivity(mintent);
                finish();

            }
        });


    }
}
