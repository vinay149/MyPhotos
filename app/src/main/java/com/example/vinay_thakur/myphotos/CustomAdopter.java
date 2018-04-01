package com.example.vinay_thakur.myphotos;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
/**
 * Created by vinay_thakur on 12/30/2017.
 */
public class CustomAdopter extends BaseAdapter implements Interface {
    Context mContext;
    public CustomAdopter(Context c) {
        mContext = c;
    }
    @Override
    public int getCount() {
        return mThumbIds.length;
    }
    @Override
    public Object getItem(int position) {
        return null;
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }
    ImageView imageView = null;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null)
        {
            imageView=new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(380, 380));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(mThumbIds[position]);
        return imageView;
        }
    public Integer[] mThumbIds = {
            R.drawable.abhi,  R.drawable.abhi11,
            R.drawable.abhi1, R.drawable.abhi12,
            R.drawable.abhi19, R.drawable.abhi20,
            R.drawable.abhi3, R.drawable.abhi16,
            R.drawable.abhi4, R.drawable.abhi15,
            R.drawable.abhi3,R.drawable.abhi4
    };
    public Integer[] mThumbIds1 ={
            R.drawable.abhi,  R.drawable.abhi4,
            R.drawable.abhi5, R.drawable.abhi6,
            R.drawable.abhi18, R.drawable.abhi7,
            R.drawable.abhi10, R.drawable.abhi11,
            R.drawable.abhi4, R.drawable.abhi15,
            R.drawable.abhi3,R.drawable.abhi4
    };
    @Override
    public void setImage(Drawable img) {
        mThumbIds[0]=R.drawable.abhi3;
    }

    @Override
    public Integer getImage(int pos) {
        return mThumbIds[pos];
    }

}
