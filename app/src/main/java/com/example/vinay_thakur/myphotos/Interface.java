package com.example.vinay_thakur.myphotos;

/**
 * Created by vinay_thakur on 12/30/2017.
 */

import android.graphics.drawable.Drawable;
import android.media.Image;

import java.lang.*;
// Any number of import statements

public interface Interface {
    public Integer[] mThumbIds =new Integer[100];
    void setImage(Drawable img);
    public Integer getImage(int pos);
    // Any number of final, static fields
    // Any number of abstract method declarations\
}