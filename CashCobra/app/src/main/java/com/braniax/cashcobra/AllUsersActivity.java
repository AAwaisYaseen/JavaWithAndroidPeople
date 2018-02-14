package com.braniax.cashcobra;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AllUsersActivity extends AppCompatActivity {

    TextView txtVuUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_users);
        txtVuUsers = findViewById(R.id.txt_vu_users);
        getUsersData();

    }

    public void getUsersData() {

        StringRequest mStringRequest = new StringRequest(1,

                "http://10.0.2.2/cash_cobra/get_all_users.php",

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        //  this method will handle the JSON
                        ReadOutTheJSON(response);


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                txtVuUsers.setText(error.toString());

            }
        });

        RequestQueue mREqRequestQueue = Volley.newRequestQueue(this);
        mREqRequestQueue.add(mStringRequest);

    }


    public void ReadOutTheJSON(String response){

        try {
            JSONArray mJsonArray = new JSONArray(response);
            int ArraySize = mJsonArray.length();

            for (int i= 0;i<ArraySize;i++){
                JSONObject mJSOnObject = mJsonArray.getJSONObject(i);
                String incomingName = mJSOnObject.getString("user_name");
                String incomingEmail = mJSOnObject.getString("user_email");

                txtVuUsers.setText(incomingName+" "+incomingEmail);
            }



        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
