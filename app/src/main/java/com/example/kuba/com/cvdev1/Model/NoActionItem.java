package com.example.kuba.com.cvdev1.Model;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import com.example.kuba.com.cvdev1.R;


public class NoActionItem extends CvItem {


    public NoActionItem() {
        super(R.drawable.ic_insert_emoticon_black_24dp, "pole ktore nic nie robi - yaaaay :)");
    }


    @Override
    public void makeAction(Context context) {

        Toast.makeText(context, "Nie dotykaj", Toast.LENGTH_SHORT).show();


    }
}
