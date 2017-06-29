package com.example.kuba.com.cvdev1.Model;

import android.content.Context;


public abstract class CvItem {


    final int imageId;
    final String name;

    public CvItem(int imageId, String name) {
        this.imageId = imageId;
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }

    public abstract void makeAction(Context context);


}
