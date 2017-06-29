package com.example.kuba.com.cvdev1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.kuba.com.cvdev1.Model.PasswordFragment;
import com.example.kuba.com.cvdev1.View.CvRow;
import com.example.kuba.com.cvdev1.View.NotesFragment;
import com.example.kuba.com.cvdev1.View.SkillFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private FrameLayout lin;
    CvRow phoneTab;
    private DrawerLayout drawerLayout;
    private CoordinatorLayout snackbarLayout;
    private NavigationView navMenu;
    private Fragment contactsFragment;
    private Fragment skillFragment;
    private Fragment notesFragment;
    private FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        snackbarLayout = (CoordinatorLayout) findViewById(R.id.snackbar_attach);

        contactsFragment = ContactFragment.newInstance();
        skillFragment = SkillFragment.newInstance();
        notesFragment = NotesFragment.newInstance();

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);

        lin = (FrameLayout) findViewById(R.id.container);
        navMenu = (NavigationView) findViewById(R.id.navMenu);

        setupToolbar(toolbar);

        PasswordFragment.newInstance().show(getSupportFragmentManager(), "");

        navMenu.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                toolbar.setTitle(item.getTitle());
                switch (item.getItemId()) {

                    case R.id.menu_experience:
                        break;
                    case R.id.menu_kontakt:
                        changeMenuItem(contactsFragment);
                        break;
                    case R.id.menu_skills:
                        changeMenuItem(skillFragment);
                        break;

                    case R.id.notes:
                        changeMenuItem(notesFragment);
                        break;
                }


                return false;
            }
        });


    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        navMenu.getMenu().performIdentifierAction(R.id.menu_kontakt, 0);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.options_menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.options_info:
//                Toast.makeText(this, "kliknales", Toast.LENGTH_SHORT).show();

                AlertDialog.Builder builder = new AlertDialog.Builder(this)
                        .setTitle("Termy i kondycje")
                        .setIcon(R.drawable.ic_error_outline_black_24dp)
                        .setMessage(getString(R.string.termy))
                        .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });


                AlertDialog alertDialog = builder.create();
                alertDialog.show();


                break;


        }

        return super.onOptionsItemSelected(item);
    }

    private void changeMenuItem(Fragment fragment) {

        drawerLayout.closeDrawer(Gravity.LEFT);


        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();

    }

    private void setupToolbar(Toolbar toolbar) {
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle hamburger = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(hamburger);
        hamburger.syncState();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab:
//                Toast.makeText(this, "o jezu fab ", Toast.LENGTH_SHORT).show();
                //Snackbar.make(snackbarLayout, "o jezu snackbar", Snackbar.LENGTH_SHORT).show();

                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setType(ContactsContract.Contacts.CONTENT_TYPE)
                        .putExtra(ContactsContract.Intents.Insert.NAME, "Imie i nazwisko")
                        .putExtra(ContactsContract.Intents.Insert.PHONE, "666 666 888")
                        .putExtra(ContactsContract.Intents.Insert.EMAIL, "pfff@sdsdf.pl");

                startActivity(intent);


        }
    }
}
