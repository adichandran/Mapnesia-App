package edu.adichandra.mapnesiaapp.Activity;

/*
 * NIM   : 10118015
 * NAMA  : Adi Chandra Nugraha
 * KELAS : IF1
 * TGL   : 09/07/2021
 * Deskripsi : menset tampilan Onboarding dan memasang sharedpreferences
 * */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.cuberto.liquid_swipe.LiquidPager;

import edu.adichandra.mapnesiaapp.R;
import edu.adichandra.mapnesiaapp.View.ViewPager;

public class WalkthroughActivity extends AppCompatActivity {

    //Kunci string boolean pengguna baru/bukan
    private static final String FIRST_USER = "firstTime";

    LiquidPager pager;
    ViewPager viewPager;
    private static int SPLASH_TIME_OUT = 3000;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walkthrough);

        pager = findViewById(R.id.pager);
        viewPager = new ViewPager(getSupportFragmentManager(),1);
        pager.setAdapter(viewPager);

        preferences = getSharedPreferences("myPref",MODE_PRIVATE);
        boolean isFirst = preferences.getBoolean(FIRST_USER,false);

        if (isFirst){
            Intent intent = new Intent(WalkthroughActivity.this,NavigationActivity.class);
            startActivity(intent);
        } else {
            savePrefData();
        }
    }

    private void savePrefData() {
        preferences.edit().putBoolean(FIRST_USER, true).apply();
    }

    public void btnGo(View view) {
        savePrefData();
        Intent intent = new Intent(WalkthroughActivity.this,NavigationActivity.class);
        startActivity(intent);
        finish();
    }

    public void btnSkip(View view) {
        savePrefData();
        Intent intent = new Intent(WalkthroughActivity.this,NavigationActivity.class);
        startActivity(intent);
        finish();
    }
}