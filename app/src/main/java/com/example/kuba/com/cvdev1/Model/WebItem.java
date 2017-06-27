package com.example.kuba.com.cvdev1.Model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import com.example.kuba.com.cvdev1.R;


public class WebItem extends CvItem {

    static final String webAdress = "http://www.ownstar.pl";

    public WebItem() {
        super(R.drawable.ic_explore_black_24dp, webAdress);

    }

    public void mail(Context context){

        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(webAdress));
        context.startActivity(browserIntent);


    }

    @Override
    public void makeAction(Context context) {
        mail(context);
    }
}
