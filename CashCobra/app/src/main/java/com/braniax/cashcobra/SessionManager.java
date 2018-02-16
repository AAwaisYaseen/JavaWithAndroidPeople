package com.braniax.cashcobra;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by mac on 16/02/2018.
 */

public class SessionManager {

    private String  USER_EMAIL = "user_email";
    private String  USER_PASSWORD = "user_password";
    private Context context ;
    private SharedPreferences.Editor mEditor;
    private  String USER_LOGIN_KEY = "user_login_status";
    SharedPreferences mPref;

    public  SessionManager(Context context){
        this.context = context;
        mPref =  context.getSharedPreferences("loginController",0);
        mEditor  = mPref.edit();
    }

    public void ControlTheSession(Boolean userIsLoggedIn,String Email,String Password){
        mEditor.putString(USER_EMAIL,Email);
        mEditor.putString(USER_PASSWORD,Password);
        mEditor.putBoolean(USER_LOGIN_KEY,userIsLoggedIn);
        mEditor.commit();

    }


    public boolean userIsloggedORNot(){
        return  mPref.getBoolean(USER_LOGIN_KEY,false);
    }



}
