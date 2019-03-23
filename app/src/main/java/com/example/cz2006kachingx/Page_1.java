package com.example.cz2006kachingx;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class Page_1 extends AppCompatActivity {

    Fragment fragment = null;
    FragmentManager manager;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navbottom_indexpage:
                    fragment = new fragmentfirst();
                    showFragment(fragment);
                    return true;
                case R.id.navbottom_showmap:
                    fragment = new fragmentmap();
                    showFragment(fragment);
                    return true;
                case R.id.navbottom_displayratechart:
                    fragment = new fragmentrate();
                    showFragment(fragment);
                    return true;
                case R.id.navbottom_exchange:
                    fragment = new fragmentxchange();
                    showFragment(fragment);
                    return true;
                case R.id.navbottom_showprof:
                    fragment = new fragmentprof();
                    showFragment(fragment);
                    return true;
            }
            return false;
        }
    };

    public void showFragment (Fragment fragment) {
        manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.content, fragment).commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_1);
        fragment = new fragmentfirst();
        showFragment(fragment);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        
    }

}
