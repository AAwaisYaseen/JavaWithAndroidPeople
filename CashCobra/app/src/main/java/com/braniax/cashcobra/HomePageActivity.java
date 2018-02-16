package com.braniax.cashcobra;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class HomePageActivity extends AppCompatActivity {

    SessionManager mSessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        mSessionManager = new SessionManager(HomePageActivity.this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.logout_menus,menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int menuID = item.getItemId();

        if(menuID == R.id.menu_logout){
            mSessionManager.ControlTheSession(false,"","");
            startActivity(new Intent(HomePageActivity.this,LoginActivity.class));
            finish();
        }
        return true;
    }
}
