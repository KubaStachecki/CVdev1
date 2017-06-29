package com.example.kuba.com.cvdev1.Model;


import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import com.example.kuba.com.cvdev1.R;


public class DialogItem extends CvItem {

    private String text;


    public DialogItem(int imageId, String name, String text) {
        super(imageId, name);
        this.text = text;


    }

    public void dialog(Context context) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setTitle(name)
                .setIcon(imageId)
                .setMessage(text);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    public void makeAction(Context context) {
        dialog(context);
    }
}
