package com.example.kuba.com.cvdev1;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.kuba.com.cvdev1.View.CvRow;
import com.example.kuba.com.cvdev1.View.NotesFragment;
import com.example.kuba.com.cvdev1.View.SkillFragment;

public class MainActivity extends AppCompatActivity {

//    @BindView(R.id.telefon)
//    Layout telefon;
//
//    @BindView(R.id.mail)
//    Layout mail;

//    @BindView(R.id.container)
//    LinearLayout container;

    private FrameLayout lin;
    CvRow phoneTab;
    private DrawerLayout drawerLayout;
    private NavigationView navMenu;
    private Fragment contactsFragment;
    private Fragment skillFragment;
    private Fragment notesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//     ButterKnife.bind(this);


        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        setupToolbar(toolbar);

        lin = (FrameLayout) findViewById(R.id.container);
        navMenu = (NavigationView) findViewById(R.id.navMenu);

        contactsFragment = ContactFragment.newInstance();
        skillFragment = SkillFragment.newInstance();
        notesFragment = NotesFragment.newInstance();


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


    //------------------------------------------koniec maina----------------------//

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


}
