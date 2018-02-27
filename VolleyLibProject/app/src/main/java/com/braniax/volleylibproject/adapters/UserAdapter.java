package com.braniax.volleylibproject.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.braniax.volleylibproject.R;
import com.braniax.volleylibproject.dataModels.UserClassModel;

import java.util.ArrayList;


/**
 * Created by mac on 27/02/2018.
 */

public class UserAdapter extends ArrayAdapter<UserClassModel> {

    public Context mContext;
    public  ArrayList<UserClassModel> objects;
    public  int resource;
    public LayoutInflater mLayoutInflater;

    public UserAdapter(@NonNull Context context, int resource, @NonNull ArrayList<UserClassModel> objects) {
        super(context, resource, objects);
        this.objects = objects;
        this.resource = resource;
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return  objects.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView = mLayoutInflater.inflate(resource,parent,false);

        ImageView imgVuUser = convertView.findViewById(R.id.img_vu_userPic);
        TextView txtVuName = convertView.findViewById(R.id.txt_vu_name);
        TextView txtVuDesignation = convertView.findViewById(R.id.txt_vu_designtion);

        UserClassModel mDataModel = objects.get(position);
        txtVuName.setText(mDataModel.userName);
        txtVuDesignation.setText(mDataModel.userDesignation);


        return convertView;
    }
}
