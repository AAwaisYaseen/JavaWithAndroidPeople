package com.infosys.gridpractice;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by mac on 21/02/2018.
 */

public class GridCustomAdapter  extends ArrayAdapter<GridDataModel>{
    Context context;
    int resource;
    GridDataModel[] objects;
    LayoutInflater mLayoutInflater;

    public GridCustomAdapter(@NonNull Context context, int resource, @NonNull GridDataModel[] objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
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
        convertView  =mLayoutInflater.inflate(resource,parent,false);

        ImageView imgVuIcon = convertView.findViewById(R.id.img_vu_icon);
        TextView TextVuLabel = convertView.findViewById(R.id.txt_vu_label);

          GridDataModel incomingDatModel = objects[position];

        TextVuLabel.setText(incomingDatModel.ImageTitle);
        imgVuIcon.setImageDrawable( context.getResources().getDrawable(R.drawable.test));

//
//        Glide.with(context)
//                .load(incomingDatModel.ImageUrl)
//                .into(imgVuIcon);

        return convertView;
    }
}
