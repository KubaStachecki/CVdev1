package com.example.kuba.com.cvdev1.Model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.kuba.com.cvdev1.R;

/**
 * Created by RENT on 2017-06-26.
 */

public class MailItem extends CvItem {

    static final String mailAdress = "kuba@kuba.kuba";

    public MailItem() {
        super(R.drawable.mail, mailAdress);

    }

    public void mail(Context context){

        Intent i = new Intent(Intent.ACTION_SEND);

        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , mailAdress);
        i.putExtra(Intent.EXTRA_SUBJECT, "I want to hire you now!");
        i.putExtra(Intent.EXTRA_TEXT   , "Please start tomorrow");
        try {
            context.startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(context, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void makeAction(Context context) {
        mail(context);
    }
}
