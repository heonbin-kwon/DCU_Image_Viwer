package com.example.dcu_image_viwer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.Image;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class gAdapter extends BaseAdapter {

    private Context gContext;
    private int[] data;

    public gAdapter(Context gContext, int[] data){
        this.gContext = gContext;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if(convertView==null){
            imageView = new ImageView(gContext);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(300,400));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(1,1,1,1);
        }else{
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(data[position]);

        return imageView;
    }
}
