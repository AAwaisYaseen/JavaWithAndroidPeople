package com.infosys_sol.intenter;

import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    FloatingActionButton fabTester;
    EditText edtTxtName;

    Button btnCamera, btnContacts, btnSms, btnVideoCamera, btnBrowser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fabTester = findViewById(R.id.fab_tester);
        edtTxtName = findViewById(R.id.edit_txt_name);
        btnCamera = findViewById(R.id.btn_camera);
        btnContacts = findViewById(R.id.btn_contacts);
        btnSms = findViewById(R.id.btn_sms);
        btnVideoCamera = findViewById(R.id.btn_vid_camera);
        btnBrowser = findViewById(R.id.btn_browser);

        btnCamera.setOnClickListener(MainActivity.this);
        btnContacts.setOnClickListener(MainActivity.this);
        btnSms.setOnClickListener(MainActivity.this);
        btnVideoCamera.setOnClickListener(MainActivity.this);
        btnBrowser.setOnClickListener(MainActivity.this);


        fabTester.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userEnteredText = edtTxtName.getText().toString();

                Intent mintent = new Intent(MainActivity.this, SecondPageActivity.class);
                mintent.putExtra("userName", userEnteredText);
                startActivity(mintent);
//              finish();
            }
        });


    }

    // all clicks are handeled here
    @Override
    public void onClick(View view) {

        int incomingId = view.getId();
        switch (incomingId) {

            case R.id.btn_camera:
                Intent Cameraintent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(Cameraintent);
                break;
            case R.id.btn_contacts:

                Intent contactPickerIntent = new Intent(Intent.ACTION_PICK,
                        ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
                startActivity(contactPickerIntent);
                break;
            case R.id.btn_sms:
                String number = "03445676545675";  // The number on which you want to send SMS
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", number, null)));
                break;
            case R.id.btn_vid_camera:
                Intent VideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivity(VideoIntent);
                break;
            case R.id.btn_browser:
                Toast.makeText(this, "hello5", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
