package com.infosys.fragpractive;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.infosys.fragpractive.fragsPkg.FirstFragment;
import com.infosys.fragpractive.fragsPkg.SecondFragment;

public class MainActivity extends AppCompatActivity {


    LinearLayout mLinLayFragContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // mLinLayFragContainer = findViewById(R.id.myFragContainer);


        //  call a fragManager  , ask it to start a transaction, tell transaction where and what to load and
        // are we bound to maintain backStack Cache!

        FirstFragment mFirstFragment  = new FirstFragment();
        loadFragmentOne(mFirstFragment);

//
//        SecondFragment mSecondFragment  = new SecondFragment();
//        loadFragmentTwo(mSecondFragment);

    }



    private void loadFragmentOne( Fragment fragmentObj){

        FragmentManager mFragmentManager = getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.mainContainer,fragmentObj);
        mFragmentTransaction.commit();

    }

    private void loadFragmentTwo( Fragment fragmentObj){

        FragmentManager mFragmentManager = getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.LinLayFragTwoContainer,fragmentObj);
        mFragmentTransaction.commit();

    }
}
