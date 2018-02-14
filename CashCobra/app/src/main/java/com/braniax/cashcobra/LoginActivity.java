package com.braniax.cashcobra;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    EditText edtTxtEmailLogin, edtTxtPasswordLogin;
    String incomingEmailLogin, incomingPasswordLogin;
    Button btnLogin;
    TextView txtVuForgetPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtTxtEmailLogin = findViewById(R.id.edt_txt_email);
        edtTxtPasswordLogin = findViewById(R.id.edt_txt_password);
        btnLogin = findViewById(R.id.btn_login);
        txtVuForgetPass = findViewById(R.id.txt_vu_forget_pass);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                incomingEmailLogin = edtTxtEmailLogin.getText().toString();
                incomingPasswordLogin = edtTxtPasswordLogin.getText().toString();

                if (incomingEmailLogin.isEmpty() && incomingPasswordLogin.isEmpty()) {
                    edtTxtEmailLogin.setError("Fill this field");
                    edtTxtPasswordLogin.setError("Fill this field");
                } else if (incomingEmailLogin.isEmpty()) {
                    edtTxtEmailLogin.setError("Fill this field");
                } else if (incomingPasswordLogin.isEmpty()) {
                    edtTxtPasswordLogin.setError("Fill this field");
                } else if (isEmailValid(incomingEmailLogin) == false) {
                    edtTxtEmailLogin.setError("Email is not valid");
                } else {
                    // volley wala kam yha hoyga
                    PostServerLoginCheck(incomingEmailLogin, incomingPasswordLogin);
                }

            }
        });

        txtVuForgetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomForgetPassDilaog mDialog = new CustomForgetPassDilaog(LoginActivity.this);
                mDialog.show();
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

    public void getServerLoginCheck(String userEmail, String userPassword) {

        StringRequest mStringRequest = new StringRequest(0,
                "http://10.0.2.2:8080/cash_cobra/test_file.php?pEmail=" + userEmail + "&pPassword=" + userPassword,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(LoginActivity.this, response, Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(LoginActivity.this, "" + error, Toast.LENGTH_SHORT).show();

            }
        });


        RequestQueue mRequestQueue = Volley.newRequestQueue(LoginActivity.this);
        mRequestQueue.add(mStringRequest);
    }

    // sending a request to server using volley' power of POST
    public void PostServerLoginCheck(final String userEmail, final String userPassword) {

        StringRequest mStringRequest = new StringRequest(Request.Method.POST,
                "http://10.0.2.2/cash_cobra/get_all_users.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(LoginActivity.this, response, Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LoginActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> myParamsMap = new HashMap<>();
                myParamsMap.put("pEmail", userEmail);
                myParamsMap.put("pPassword", userPassword);

                return myParamsMap;
            }
        };

        RequestQueue mRequestQueue = Volley.newRequestQueue(LoginActivity.this);
        mRequestQueue.add(mStringRequest);


    }


    // custom class for froget pasword dialogbox


    private class CustomForgetPassDilaog extends Dialog {

        private Context mcontext;
        private Button btnEcho;
        private EditText edtTxtEcho;

        CustomForgetPassDilaog(Context mcontext) {
            super(mcontext);
            this.mcontext = mcontext;
            requestWindowFeature(Window.FEATURE_NO_TITLE);
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.forget_pass_custom_layout);
            edtTxtEcho = findViewById(R.id.edt_txt_echoed);
            btnEcho = findViewById(R.id.btn_echo);
            getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

            btnEcho.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String incomingMsg = edtTxtEcho.getText().toString();
                    showToast(incomingMsg,1);

                }
            });


        }


    }


    //---------------method for toast controll------------//

    public void showToast(String msg, int length) {

        if (length == 0) {
            Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT).show();
        } else if (length == 1) {

            Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_LONG).show();
        }
    }

}
