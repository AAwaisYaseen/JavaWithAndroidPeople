package com.rizwa.modlebasedlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    ListView lstVuMovies;

    MoviesModel[] moviesData;

    MoviesAdapter mMoviesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstVuMovies = findViewById(R.id.lst_vu_movies);

        moviesData = new MoviesModel[10];

        for (int i = 0; i < moviesData.length; i++) {

            MoviesModel model = new MoviesModel(R.drawable.pic_three, "TITLE" + i, "SUBTITLE" + i);
            moviesData[i] = model;
        }

        mMoviesAdapter = new MoviesAdapter(MainActivity.this, R.layout.custom_list_vu_style, moviesData);
        lstVuMovies.setAdapter(mMoviesAdapter);


        lstVuMovies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View incomingView, int i, long l) {
//
//                ImageView imgVuIcon = incomingView.findViewById(R.id.img_vu_icon);
                TextView txtVuTitle = incomingView.findViewById(R.id.txt_vu_title);
//                TextView txtVuSubTitle = incomingView.findViewById(R.id.txt_vu_subtitle);
                ImageView imgVuClose = incomingView.findViewById(R.id.img_vu_close);

                PopupMenu mPopupMenu = new PopupMenu(MainActivity.this,imgVuClose);

                mPopupMenu.inflate(R.menu.main_menu);
                mPopupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(MainActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });
                mPopupMenu.show();


            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        switch (itemId) {

            case R.id.menu_item_one:
                Toast.makeText(this, "one", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_item_two:
                Toast.makeText(this, "two", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_item_three:
                Toast.makeText(this, "three", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_item_four:
                Toast.makeText(this, "four", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }


}
