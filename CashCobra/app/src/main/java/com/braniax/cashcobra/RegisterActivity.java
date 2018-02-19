package com.braniax.cashcobra;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    EditText edtTxtRegEmail,
            edtTxtRegName,
            edtTxtRegPassword,
            edtTxtRegPhone,
            edtTxtRegAddress;


    String IncomingRegEmail,
            IncomingRegName,
            IncomingRegPassword,
            IncomingRegPhone,
            IncomingRegAddress;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtTxtRegEmail = findViewById(R.id.edt_txt_RegEmail);
        edtTxtRegName = findViewById(R.id.edt_txt_RegName);
        edtTxtRegPassword = findViewById(R.id.edt_txt_RegPassword);
        edtTxtRegPhone = findViewById(R.id.edt_txt_RegPhone);
        edtTxtRegAddress = findViewById(R.id.edt_txt_RegAddress);

        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IncomingRegEmail = edtTxtRegEmail.getText().toString();
                IncomingRegName = edtTxtRegName.getText().toString();
                IncomingRegPassword = edtTxtRegPassword.getText().toString();
                IncomingRegPhone = edtTxtRegPhone.getText().toString();
                IncomingRegAddress = edtTxtRegAddress.getText().toString();

                RegisterUserMethod(IncomingRegEmail, IncomingRegName, IncomingRegPassword, IncomingRegPhone, IncomingRegAddress);
            }
        });
    }

    private void RegisterUserMethod(final String incomingRegEmail,
                                    final String incomingRegName,
                                    final String incomingRegPassword,
                                    final String incomingRegPhone,
                                    final String incomingRegAddress) {


        StringRequest mStringRequest = new StringRequest(1,
                "http://10.0.2.2/cash_cobra/reg_new_user.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(RegisterActivity.this, response, Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(RegisterActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("incomingRegEmail",incomingRegEmail);
                params.put("incomingRegName",incomingRegName);
                params.put("incomingRegPassword",incomingRegPassword);
                params.put("incomingRegPhone",incomingRegPhone);
                params.put("incomingRegAddress",incomingRegAddress);
                return params;
            }
        };

        RequestQueue mRequestQueue = Volley.newRequestQueue(RegisterActivity.this);
        mRequestQueue.add(mStringRequest);
    }
}
