package com.example.kuba.com.cvdev1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.kuba.com.cvdev1.Model.CvItem;
import com.example.kuba.com.cvdev1.Model.MailItem;
import com.example.kuba.com.cvdev1.Model.NoActionItem;
import com.example.kuba.com.cvdev1.Model.NotesItem;
import com.example.kuba.com.cvdev1.Model.PhoneItem;
import com.example.kuba.com.cvdev1.Model.WebItem;
import com.example.kuba.com.cvdev1.View.CvRow;


public class ContactFragment extends Fragment {

    LinearLayout contactLayout;



    public ContactFragment() {
        // Required empty public constructor
    }


    public static ContactFragment newInstance() {
        ContactFragment fragment = new ContactFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        contactLayout = (LinearLayout) view.findViewById(R.id.contactFragment);

//        addRow(R.drawable.phone, "666 666 666", contactLayout);
//        addRow(R.drawable.mail, "kuba@kuba.com", contactLayout);


       CvRow mail = new CvRow(getActivity(), new MailItem());
       CvRow phone = new CvRow(getActivity(), new PhoneItem());
       CvRow webadress = new CvRow(getActivity(), new NoActionItem());
       CvRow noaction = new CvRow(getActivity(), new WebItem());
       CvRow notes = new CvRow(getActivity(), new NotesItem());

        contactLayout.addView(mail);
        contactLayout.addView(phone);
        contactLayout.addView(webadress);
        contactLayout.addView(noaction);
        contactLayout.addView(notes);


//        phone.setOnClickListener(this);
//        mail.setOnClickListener(this);



        return view;
    }


}
