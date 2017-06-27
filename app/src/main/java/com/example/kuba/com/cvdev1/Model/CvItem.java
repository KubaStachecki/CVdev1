package com.example.kuba.com.cvdev1.Model;

import android.content.Context;

/**
 * Created by RENT on 2017-06-26.
 */

public abstract class  CvItem {


    private final int imageId;
    private final String text;

    public CvItem(int imageId, String text) {
        this.imageId = imageId;
        this.text = text;
    }

    public int getImageId() {
        return imageId;
    }
    public String getText() {
        return text;
    }

    public abstract void makeAction(Context context);



}
