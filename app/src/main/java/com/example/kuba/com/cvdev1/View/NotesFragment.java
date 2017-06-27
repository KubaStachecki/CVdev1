package com.example.kuba.com.cvdev1.View;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kuba.com.cvdev1.R;


public class NotesFragment extends Fragment {

    TextView notes;
    private SharedPreferences sharedPreferences;

    public NotesFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static NotesFragment newInstance() {
        NotesFragment fragment = new NotesFragment();

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPreferences = getActivity().getSharedPreferences("notatki", getContext().MODE_PRIVATE);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_notes, container, false);

        notes = (TextView) view.findViewById(R.id.notes);



        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
        String notatka = notes.getText().toString();

        Log.d(NotesFragment.class.getSimpleName(), "PAUSE sie wlaczyl");

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("notes", notatka).apply();

    }

    @Override
    public void onResume() {
        super.onResume();
        notes.setText(sharedPreferences.getString("notes", "defalut"));

    }

    @Override
    public void onStop() {
        super.onStop();

        Log.d(NotesFragment.class.getSimpleName(), "STOP sie wlaczyl");
    }
}
