package com.braniax.cashcobra;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    EditText edtTxtEmailLogin,edtTxtPasswordLogin;
    String incomingEmailLogin,incomingPasswordLogin;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtTxtEmailLogin = findViewById(R.id.edt_txt_email);
        edtTxtPasswordLogin = findViewById(R.id.edt_txt_password);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                incomingEmailLogin = edtTxtEmailLogin.getText().toString();
                incomingPasswordLogin = edtTxtPasswordLogin.getText().toString();

                if(incomingEmailLogin.isEmpty() && incomingPasswordLogin.isEmpty() ){
                    edtTxtEmailLogin.setError("Fill this field");
                    edtTxtPasswordLogin.setError("Fill this field");
                }else if(incomingEmailLogin.isEmpty()){
                    edtTxtEmailLogin.setError("Fill this field");
                }else if(incomingPasswordLogin.isEmpty()){
                    edtTxtPasswordLogin.setError("Fill this field");
                }else if( isEmailValid(incomingEmailLogin) ==false){
                    edtTxtEmailLogin.setError("Email is not valid");
                }else{
                    // volley wala kam yha hoyga
                    getServerLoginCheck(incomingEmailLogin,incomingPasswordLogin);
                }

            }
        });

    }


    //  REGULER EXPRESSION MATCHING  in java its done by the usage of Pattern Class

    public boolean isEmailValid(String email) {
        String regExpn =
                "^([a-zA-Z0-9_\\-.]+)@([a-zA-Z0-9_\\-.]+)\\.([a-zA-Z]{2,5})$";

        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(regExpn, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);

        if (matcher.matches())
            return true;
        else
            return false;
    }



    // check user login from server

    public void getServerLoginCheck(String userEmail,String userPassword){

        StringRequest mStringRequest = new StringRequest(1,
                "http://10.0.2.2:8080/cash_cobra/test_file.php?pEmail="+userEmail+"&pPassword="+userPassword,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(LoginActivity.this, response, Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(LoginActivity.this, ""+error, Toast.LENGTH_SHORT).show();

            }
        });


        RequestQueue mRequestQueue = Volley.newRequestQueue(LoginActivity.this);
        mRequestQueue.add(mStringRequest);
    }


}
