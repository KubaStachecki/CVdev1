package com.example.kuba.com.cvdev1.View;


import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.kuba.com.cvdev1.Model.CvItem;

public class CvRow extends LinearLayout implements View.OnClickListener {

    private final String text;
    private final CvItem cvItem;
    private final int imageId;
    private final Context context;
    private final Resources resources;
    private final DisplayMetrics metrics;


    public CvRow(final Context context, final CvItem cvItem) {


        super(context);


        this.cvItem = cvItem;
        this.text = cvItem.getName();
        this.imageId = cvItem.getImageId();
        this.context = context;
        resources = context.getResources();
        metrics = resources.getDisplayMetrics();


        setupMainLayout(context);
        ImageView imageView = setupImageView();
        TextView textView = setupTextView();
        addViews(imageView, textView);



        setOnClickListener(this);
    }

    private void addViews(ImageView imageView, TextView textView) {

        this.addView(imageView);
        this.addView(textView);
    }

    private TextView setupTextView() {
        TextView textView = new TextView(context);
        textView.setText(text);
        LayoutParams textParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        textParams.gravity = Gravity.CENTER_VERTICAL;
        textView.setPadding(dpToPx(context, 32), 0, 0, 0);

        textView.setTextSize(16);

        textView.setLayoutParams(textParams);

        return textView;
    }

    private ImageView setupImageView() {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(imageId);
        LayoutParams imageParams = new LayoutParams(dpToPx(context, 24), dpToPx(context, 24));
        imageParams.gravity = Gravity.CENTER_VERTICAL;
        imageView.setLayoutParams(imageParams);

        return imageView;

    }

    private void setupMainLayout(Context context) {
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dpToPx(context, 48));
        this.setLayoutParams(params);
        this.setOrientation(LinearLayout.HORIZONTAL);
        this.setPadding(dpToPx(context, 16), 0, dpToPx(context, 16), 0);
    }


    private int dpToPx(Context context, int dp) {

        return (int) (dp * ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT));
        //return (int) px;
    }


    public String getText() {
        return text;
    }


    @Override
    public void onClick(View v) {

   cvItem.makeAction(context);


    }
}
