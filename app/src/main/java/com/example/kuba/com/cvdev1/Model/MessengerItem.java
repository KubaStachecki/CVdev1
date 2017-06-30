package com.example.kuba.com.cvdev1.Model;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.kuba.com.cvdev1.MainActivity;
import com.example.kuba.com.cvdev1.R;

/**
 * Created by RENT on 2017-06-26.
 */

public class MessengerItem extends CvItem {

    static final String facebookAdress = "moj messenger login";

    public MessengerItem() {
        super(R.drawable.facebook_icon, facebookAdress);

    }

    public void mail(Context context){

        Toast.makeText(context, facebookAdress, Toast.LENGTH_SHORT).show();




    }

    @Override
    public void makeAction(Context context) {
        mail(context);
    }
}
