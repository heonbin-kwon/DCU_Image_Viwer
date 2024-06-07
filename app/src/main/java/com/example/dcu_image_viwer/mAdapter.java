package com.example.dcu_image_viwer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class mAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<String> data;

    public mAdapter(Context mContext,ArrayList<String> data){
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
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
        Bitmap bmp = BitmapFactory.decodeFile(data.get(position));

        if(convertView==null){
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(400,400));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(5,5,5,5);
        }else{
            imageView = (ImageView) convertView;
        }
        imageView.setImageBitmap(bmp);

        return imageView;
    }
}
