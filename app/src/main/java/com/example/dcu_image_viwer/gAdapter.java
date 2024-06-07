package com.example.dcu_image_viwer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class gAdapter extends RecyclerView.Adapter<gAdapter.viewHolder> {

    private ArrayList<String> data;

    public static class viewHolder extends RecyclerView.ViewHolder{
        public ImageView ryImg;
        public viewHolder(View v){
            super(v);
            ryImg = v.findViewById(R.id.ryImg);
        }
    }

    public gAdapter(ArrayList<String> imgData){
        data = imgData;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);

        viewHolder vh = new viewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Bitmap bmp = BitmapFactory.decodeFile(data.get(position));

        holder.ryImg.setImageBitmap(bmp);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


//    public View getView(int position, View convertView, ViewGroup parent) {
//        ImageView imageView;
//
//        if(convertView==null){
//            imageView = new ImageView(gContext);
//            imageView.setLayoutParams(new ViewGroup.LayoutParams(300,400));
//            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
//            imageView.setPadding(1,1,1,1);
//        }else{
//            imageView = (ImageView) convertView;
//        }
//        imageView.setImageResource(data[position]);
//
//        return imageView;
//    }
}
