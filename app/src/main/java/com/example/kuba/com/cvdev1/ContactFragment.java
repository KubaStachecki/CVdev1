package com.example.kuba.com.cvdev1;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.kuba.com.cvdev1.Model.CvItem;
import com.example.kuba.com.cvdev1.Model.DialogItem;
import com.example.kuba.com.cvdev1.Model.MailItem;
import com.example.kuba.com.cvdev1.Model.MessengerItem;
import com.example.kuba.com.cvdev1.Model.NoActionItem;
import com.example.kuba.com.cvdev1.Model.NotesItem;
import com.example.kuba.com.cvdev1.Model.PhoneItem;
import com.example.kuba.com.cvdev1.Model.SnackbarShower;
import com.example.kuba.com.cvdev1.Model.WebItem;
import com.example.kuba.com.cvdev1.View.CvRow;


public class ContactFragment extends Fragment implements SnackbarShower {

    LinearLayout contactLayout;
    private SnackbarShower snackbarShower;
//    MainActivity mainActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof SnackbarShower)
            snackbarShower = (SnackbarShower) context;

    }

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
        CvRow messenger = new CvRow(getActivity(), new MessengerItem());
        CvRow dialog = new CvRow(getActivity(), new DialogItem(R.drawable.kartka, "Napisalem cos", "bo umiem pisac i dlatego mi sie udalo"));

        contactLayout.addView(mail);
        contactLayout.addView(phone);
        contactLayout.addView(webadress);
        contactLayout.addView(noaction);
        contactLayout.addView(notes);
        contactLayout.addView(dialog);
        contactLayout.addView(messenger);

        messenger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (/*mamy messeng*/ false) {
                    //costam
                } else {

                    //.showSnackbar("zainstaluj messenger");
                }
            }
        });


//        phone.setOnClickListener(this);
//        mail.setOnClickListener(this);


        return view;
    }


    @Override
    public void onDetach() {
        super.onDetach();
        snackbarShower = null;
    }

    @Override
    public void showSnackbar(String text) {

    }
}
