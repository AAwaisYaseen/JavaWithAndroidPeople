package com.infosys_sol.sqlitedatabaseproject;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.infosys_sol.sqlitedatabaseproject.database.DBMS;
import com.infosys_sol.sqlitedatabaseproject.database.DbModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtTxtRNumber, edtTxtName, edtTxtFName, edtTxtPhone, edtTxtAddress;
    String incomingRNumber, incomingName, incomingFName, incomingPhone, incomingAddress;

    Button btnSignup, btnGetData;
    DBMS dbms;
    SQLiteDatabase db;
    TextView txtVuResults;

//    DbModel[] DataArrayFromDb;

    ArrayList<DbModel> DataArrayFromDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // creaeted a dbms instance in this actvity
        dbms = new DBMS(MainActivity.this);

        DataArrayFromDb = new ArrayList<>();

        edtTxtRNumber = findViewById(R.id.editTextRollNumber);
        edtTxtName = findViewById(R.id.editTextName);
        edtTxtFName = findViewById(R.id.editTextFName);
        edtTxtPhone = findViewById(R.id.editTextPhone);
        edtTxtAddress = findViewById(R.id.editTextAddress);
        btnSignup = findViewById(R.id.btnSignUp);
        btnGetData = findViewById(R.id.btnGetData);
        txtVuResults = findViewById(R.id.txtVuResults);

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
                db = dbms.getReadableDatabase();
                Cursor incomingCursor;
                incomingCursor = dbms.getDataFromDatabase(db);

                // String totalData = String.valueOf(incomingCursor.getCount());

                //how to read a cursor
                // step one bring it to the top or start of the table row
                if (incomingCursor.moveToFirst() == true) {
                    String userRollNumber;
                    String userName;
                    String userFName;
                    String userPhone;
                    String userAddress;
                    String Result;
                    String Alldata = "\n";
                    do {
                        userRollNumber = incomingCursor.getString(0);
                        userName = incomingCursor.getString(1);
                        userFName = incomingCursor.getString(2);
                        userPhone = incomingCursor.getString(3);
                        userAddress = incomingCursor.getString(4);

//                        DbModel mdbModel = new DbModel(userRollNumber, userName, userFName, userPhone, userAddress);
//                        DataArrayFromDb.add(mdbModel);

//                        Result = userRollNumber+" "+userName+" " +userFName+" " +userPhone+" " +userAddress+" ";
//                        Alldata = Result+Alldata;
                    } while (incomingCursor.moveToNext());

//                    txtVuResults.setText(Alldata);
                }

            }
        });
    }
}
