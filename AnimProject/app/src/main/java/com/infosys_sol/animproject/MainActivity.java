package com.infosys_sol.animproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    Button btnOne,btnTwo;
    ImageView imgVuloaderAnim;
    Animation  fadeAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOne = findViewById(R.id.btn_one);
        btnTwo = findViewById(R.id.btn_two);
        imgVuloaderAnim = findViewById(R.id.img_vu_anim);

        fadeAnim = AnimationUtils.loadAnimation(MainActivity.this,R.anim.fading_anim);


        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgVuloaderAnim.setVisibility(View.VISIBLE);
                btnTwo.startAnimation(fadeAnim);
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgVuloaderAnim.setVisibility(View.INVISIBLE);
                btnOne.startAnimation(fadeAnim);
            }
        });

    }
}
