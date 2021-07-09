package edu.adichandra.mapnesiaapp;

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
import android.view.WindowManager;

import com.cuberto.liquid_swipe.LiquidPager;

public class WalkthroughActivity extends AppCompatActivity {

    //Kunci string boolean pengguna baru/bukan
    private static final String FIRST_USER = "firstTime";

    LiquidPager pager;
    ViewPager viewPager;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walkthrough);

        pager = findViewById(R.id.pager);
        viewPager = new ViewPager(getSupportFragmentManager(),1);
        pager.setAdapter(viewPager);

        preferences = getSharedPreferences("myPref",MODE_PRIVATE);

        getPrefData();
        savePrefData();
    }

    public void getPrefData() {
        if (preferences.getBoolean(FIRST_USER,false)){
            Intent intent = new Intent(WalkthroughActivity.this,NavigationActivity.class);
            startActivity(intent);
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