package com.infosys.gridpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    GridView mGridVuLocal;
    GridCustomAdapter mGridAdapter;
    String baseUrl = "http://markitbox.com/mobileApp/images/categories/";
    GridDataModel[] Data = {

            new GridDataModel(baseUrl + "shoes.png", "shoes"),
            new GridDataModel(baseUrl + "dresses.png", "Dresses"),
            new GridDataModel(baseUrl + "technology.png", "technology"),
            new GridDataModel(baseUrl + "studical.png", "studical"),
            new GridDataModel(baseUrl + "shoes.png", "shoes"),
            new GridDataModel(baseUrl + "shoes.png", "shoes"),
            new GridDataModel(baseUrl + "dresses.png", "Dresses"),
            new GridDataModel(baseUrl + "technology.png", "technology"),
            new GridDataModel(baseUrl + "studical.png", "studical"),
            new GridDataModel(baseUrl + "shoes.png", "shoes"),

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGridVuLocal = findViewById(R.id.grid_vu_local);
        mGridAdapter = new GridCustomAdapter(MainActivity.this, R.layout.custom_grid_design, Data);
        mGridVuLocal.setAdapter(mGridAdapter);
    }
}
