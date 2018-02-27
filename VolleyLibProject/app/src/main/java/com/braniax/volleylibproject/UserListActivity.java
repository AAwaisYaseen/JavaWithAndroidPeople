package com.braniax.volleylibproject;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.braniax.volleylibproject.adapters.UserAdapter;
import com.braniax.volleylibproject.dataModels.UserClassModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class UserListActivity extends AppCompatActivity {


    ListView lstVuUsers;
    UserAdapter mUserAdapter;

    ArrayList<UserClassModel> dataArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        lstVuUsers = findViewById(R.id.lst_vu_users);
        dataArrayList = new ArrayList<>();


        getUsersDataFromServer();

    }


    private void getUsersDataFromServer() {

        StringRequest getUsersRequest = new StringRequest(1, "http://10.0.2.2/cash_cobra/get_all_users.php", new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                readOutTheUsers(response);
//
//                Toast.makeText(UserListActivity.this, response, Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(UserListActivity.this, error.toString(), Toast.LENGTH_SHORT).show();

            }
        });


        RequestQueue mRequestQueue = Volley.newRequestQueue(UserListActivity.this);
        mRequestQueue.add(getUsersRequest);

    }


    private void readOutTheUsers(String response) {

        try {

            JSONObject mUserResponse = new JSONObject(response);

            JSONArray Result = mUserResponse.getJSONArray("result");
            int length = Result.length();

            for (int i = 0; i < length; i++) {

                JSONObject QueryObject = Result.getJSONObject(i);

                String Name = QueryObject.getString("user_name");
                String Designation = QueryObject.getString("user_address");

                UserClassModel mDataModel = new UserClassModel("abc", Name, Designation);
                dataArrayList.add(mDataModel);
            }

            mUserAdapter = new UserAdapter(this, R.layout.user_list_custom_item_design, dataArrayList);
            lstVuUsers.setAdapter(mUserAdapter);


        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

}
