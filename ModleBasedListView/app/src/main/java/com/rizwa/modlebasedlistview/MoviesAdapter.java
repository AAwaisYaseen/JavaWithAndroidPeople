package com.rizwa.modlebasedlistview;

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
 * Created by mac on 19/01/2018.
 */

public class MoviesAdapter extends ArrayAdapter<MoviesModel> {

    Context context;
    int designResourceFile;
    MoviesModel[] objects;
    LayoutInflater mLayoutInflater;

    public MoviesAdapter(@NonNull Context context, int designResourceFile, @NonNull MoviesModel[] objects) {
        super(context, designResourceFile, objects);
        this.context = context;
        this.designResourceFile = designResourceFile;
        this.objects = objects;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return objects.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView = mLayoutInflater.inflate(designResourceFile, parent, false);

        ImageView imgVuIcon = convertView.findViewById(R.id.img_vu_icon);
        ImageView imgVuClose = convertView.findViewById(R.id.img_vu_close);
        TextView txtVuTitle = convertView.findViewById(R.id.txt_vu_title);
        TextView txtVuSubTitle = convertView.findViewById(R.id.txt_vu_subtitle);

//        txtVuTitle.setText(objects[position].getMoviesTitle());
//        txtVuSubTitle.setText(objects[position].getMoviesSubTitle());
//        imgVuIcon.setImageDrawable(context.getResources().getDrawable(objects[position].getImageId()));
//                          OR

        MoviesModel mIncomingModel = objects[position];

        txtVuTitle.setText(mIncomingModel.getMoviesTitle());
        txtVuSubTitle.setText(mIncomingModel.getMoviesSubTitle());
        imgVuIcon.setImageDrawable(context.getResources().getDrawable(mIncomingModel.getImageId()));

        return convertView;
    }
}
