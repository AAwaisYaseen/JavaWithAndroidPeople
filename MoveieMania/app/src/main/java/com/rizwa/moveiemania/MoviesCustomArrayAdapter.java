package com.rizwa.moveiemania;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by mac on 17/01/2018.
 */

public class MoviesCustomArrayAdapter extends ArrayAdapter {


    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private int designRes;
    private String[] mMoviesData;
    private String[] mMoviesSubtitleData;
    private int[] mMoviesImagesData;

    MoviesCustomArrayAdapter(Context mContext, int designRes, String[] mMoveisData,
                             String[] mMoviesSubtitleData,
                             int[] mMoviesImagesData) {
        super(mContext, designRes, mMoveisData);
        this.mContext = mContext;
        this.designRes = designRes;
        this.mMoviesData = mMoveisData;
        this.mMoviesSubtitleData = mMoviesSubtitleData;
        this.mMoviesImagesData = mMoviesImagesData;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mMoviesData.length;
    }

    //the heart method to get the xml desing template converted everytime getCount calls it
    //and it will set the data coming from the constructor mMOviesDataArray


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView = mLayoutInflater.inflate(designRes, parent, false);

        ImageView imgVuMovIcon = convertView.findViewById(R.id.img_vu_mov_icon);
        TextView txtVuMovTitle = convertView.findViewById(R.id.txt_vu_mov_title);
        TextView txtVuMovSubTitle = convertView.findViewById(R.id.txt_vu_mov_subtitle);

        imgVuMovIcon.setImageDrawable(mContext.getResources().getDrawable(mMoviesImagesData[position]));
        txtVuMovTitle.setText(mMoviesData[position]);
        txtVuMovSubTitle.setText(mMoviesSubtitleData[position]);

        return convertView;
    }
}
