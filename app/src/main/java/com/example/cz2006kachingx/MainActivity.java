package com.example.cz2006kachingx;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int TIME_WLC_SHOW = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent PageCall = new Intent(MainActivity.this, Page_1.class);
                startActivity(PageCall);
                finish();
            }
        },TIME_WLC_SHOW);

        DBHandler dbHandler = new DBHandler(this,null, null, 1);
        dbHandler.addcolumn(1,"FOREX1","NTU","1.00,1.5,1.7,1.1,1.5,1.05", "No contact");
        dbHandler.addcolumn(2,"FOREX2","NTU","1.00,1.5,1.7,1.1,1.5,1.05", "No contact");
        dbHandler.addcolumn(3,"FOREX3","NTU","1.00,1.5,1.7,1.1,1.5,1.05", "No contact");
    }

}
