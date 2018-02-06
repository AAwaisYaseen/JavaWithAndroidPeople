package com.rizwa.moveiemania;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView lstVuMovies;
    MoviesCustomArrayAdapter moviesAdapter;
    String[] MovieTitles = {

            "TITANIC",
            "JUMANJI",
            "FAST AND FURIOUS",
            "THOR",
            "Pirates of Carabian",
            "14 blades",
            "Avatar",
            "BayWatch",
            "Channo kamli yaar de",
            "TITANIC",
            "JUMANJI",
            "FAST AND FURIOUS",
            "THOR",
            "Pirates of Carabian",
            "14 blades",
            "Avatar",
            "BayWatch",
            "Channo kamli yaar de"

    };
    String[] MovieSubTitles = {

            "TITANIC",
            "JUMANJI",
            "FAST AND FURIOUS",
            "THOR",
            "Pirates of Carabian",
            "14 blades",
            "Avatar",
            "BayWatch",
            "Channo kamli yaar de",
            "TITANIC",
            "JUMANJI",
            "FAST AND FURIOUS",
            "THOR",
            "Pirates of Carabian",
            "14 blades",
            "Avatar",
            "BayWatch",
            "Channo kamli yaar de"

    };
    int[] MovieImages = {

            R.drawable.img_one,
            R.drawable.img_two,
            R.drawable.img_three,
            R.drawable.img_four,
            R.drawable.img_one,
            R.drawable.img_two,
            R.drawable.img_three,
            R.drawable.img_four,
            R.drawable.img_one,
            R.drawable.img_two,
            R.drawable.img_three,
            R.drawable.img_four,
            R.drawable.img_one,
            R.drawable.img_two,
            R.drawable.img_three,
            R.drawable.img_four,
            R.drawable.img_one,
            R.drawable.img_two
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstVuMovies = findViewById(R.id.lst_vu_movies);

        moviesAdapter = new MoviesCustomArrayAdapter(MainActivity.this,
                R.layout.custom_list_vu_design,
                MovieTitles,
                MovieSubTitles,
                MovieImages);



        lstVuMovies.setAdapter(moviesAdapter);

        lstVuMovies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View ConvertedView, int position, long l) {

                TextView TxtVuIncomingMovieTitle = ConvertedView.findViewById(R.id.txt_vu_mov_title);
                String incomingTitle = TxtVuIncomingMovieTitle.getText().toString();
                Toast.makeText(MainActivity.this, incomingTitle, Toast.LENGTH_SHORT).show();

            }


        });
    }


    @Override
    public void onBackPressed() {

        super.onBackPressed();
    }
}
