package com.example.kuba.com.cvdev1.Model;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import com.example.kuba.com.cvdev1.R;


public class PhoneItem extends CvItem {

    static final String phoneNumber = "666 666 666";

    public PhoneItem() {

        super(R.drawable.phone, phoneNumber);
    }

    public void call(Context context){

        Toast.makeText(context, "telefon dryn dryn", Toast.LENGTH_SHORT).show();
        Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
        phoneIntent.setData(Uri.parse("tel:" + phoneNumber));
        context.startActivity(phoneIntent);

    }

    @Override
    public void makeAction(Context context) {
        call(context);
    }
}
