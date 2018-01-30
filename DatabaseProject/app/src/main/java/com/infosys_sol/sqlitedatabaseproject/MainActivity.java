package com.infosys_sol.sqlitedatabaseproject;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.infosys_sol.sqlitedatabaseproject.database.DBMS;

public class MainActivity extends AppCompatActivity {

    EditText edtTxtRNumber,edtTxtName,edtTxtFName,edtTxtPhone,edtTxtAddress;
    String incomingRNumber,incomingName,incomingFName,incomingPhone,incomingAddress;

    Button btnSignup,btnGetData;
    DBMS dbms;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // creaeted a dbms instance in this actvity
        dbms = new DBMS(MainActivity.this);

        edtTxtRNumber = findViewById(R.id.editTextRollNumber);
        edtTxtName = findViewById(R.id.editTextName);
        edtTxtFName = findViewById(R.id.editTextFName);
        edtTxtPhone = findViewById(R.id.editTextPhone);
        edtTxtAddress = findViewById(R.id.editTextAddress);
        btnSignup = findViewById(R.id.btnSignUp);
        btnGetData = findViewById(R.id.btnGetData);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incomingRNumber = edtTxtRNumber.getText().toString();
                incomingName = edtTxtName.getText().toString();
                incomingFName = edtTxtFName.getText().toString();
                incomingPhone = edtTxtPhone.getText().toString();
                incomingAddress = edtTxtAddress.getText().toString();

                db = dbms.getWritableDatabase();

                dbms.putUserDataInDb(incomingRNumber,
                        incomingName,
                        incomingFName,
                        incomingPhone,
                        incomingAddress,
                        db
                        );
                edtTxtRNumber.setText("");
                edtTxtName.setText("");
                edtTxtFName.setText("");
                edtTxtPhone.setText("");
                edtTxtAddress.setText("");

            }
        });


        btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                db = dbms.getReadableDatabase();
//
//            Cursor incomingCursor = dbms.readAllUsers(db);
//
//            if(incomingCursor.moveToFirst()){
//                do{
//                    String incomingUsername = incomingCursor.getString(1);
//                    Toast.makeText(MainActivity.this, incomingUsername, Toast.LENGTH_LONG).show();
//                }while(incomingCursor.moveToNext());
//            }

            }
        });
    }
}
