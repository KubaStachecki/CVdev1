package com.example.kuba.com.cvdev1.Model;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kuba.com.cvdev1.R;


public class PasswordFragment extends DialogFragment implements View.OnClickListener {

    TextView login_field;
    TextView password_field;
    Button enter;
    Animation shake;


    private static final String password = "123";
    private static final String login = "dupa";


    public PasswordFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static PasswordFragment newInstance() {
        PasswordFragment fragment = new PasswordFragment();

        return fragment;
    }

    @Override
    public void show(FragmentManager manager, String tag) {
        super.show(manager, tag);
        this.setCancelable(false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_password, container, false);

        login_field = (TextView) view.findViewById(R.id.login_name);
        password_field = (TextView) view.findViewById(R.id.login_pass);
        enter = (Button) view.findViewById(R.id.login_button);

        enter.setOnClickListener(this);


        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        shake = AnimationUtils.loadAnimation(getActivity(), R.anim.shake);
    }

    @Override
    public void onClick(View v) {

        Toast.makeText(getActivity(), "klikles", Toast.LENGTH_SHORT).show();
        String loginIn = login_field.getText().toString();
        String passIn = password_field.getText().toString();


        if (passIn.equals(password)) {
            this.dismiss();
        } else {
            password_field.startAnimation(shake);
            login_field.startAnimation(shake);

            Vibrator vibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(500);

        }


    }

}
