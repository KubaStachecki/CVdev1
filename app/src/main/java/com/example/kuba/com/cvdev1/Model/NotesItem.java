package com.example.kuba.com.cvdev1.Model;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import com.example.kuba.com.cvdev1.R;


public class NotesItem extends CvItem {


    public NotesItem() {
        super(R.drawable.kartka, "Miejsce na notatki");
    }

    public void notes(Context context){
    //to ma byc puste
    }

    @Override
    public void makeAction(Context context) {

        Toast.makeText(context, "kliknales w notatki", Toast.LENGTH_SHORT).show();

    }
}
