package com.infosys_sol.intenter;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.MediaController;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fabTester;
    EditText edtTxtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fabTester = findViewById(R.id.fab_tester);
        edtTxtName = findViewById(R.id.edit_txt_name);



        fabTester.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userEnteredText = edtTxtName.getText().toString();

              Intent mintent = new Intent(MainActivity.this,SecondPageActivity.class);
              mintent.putExtra("userName",userEnteredText);
              startActivity(mintent);
//              finish();
            }
        });



    }
}
