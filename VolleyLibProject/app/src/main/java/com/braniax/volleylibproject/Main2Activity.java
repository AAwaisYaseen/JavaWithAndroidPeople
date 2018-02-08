package com.braniax.volleylibproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class Main2Activity extends AppCompatActivity {

    Button btnTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btnTest = findViewById(R.id.button_tester);
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSomeSerVerData();
            }
        });
    }

    public void getSomeSerVerData() {

        StringRequest mStringRequest;
        mStringRequest = new StringRequest(1, "http://192.168.64.2/volley_prctic/test_file.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Main2Activity.this, response, Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Main2Activity.this, ""+error, Toast.LENGTH_SHORT).show();
                    }
                }
        );

        RequestQueue mRequestQueue = Volley.newRequestQueue(Main2Activity.this);

        mRequestQueue.add(mStringRequest);

    }
}
