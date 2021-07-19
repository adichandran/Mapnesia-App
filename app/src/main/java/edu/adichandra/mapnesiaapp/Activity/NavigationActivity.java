package edu.adichandra.mapnesiaapp.Activity;

/*
 * NIM   : 10118015
 * NAMA  : Adi Chandra Nugraha
 * KELAS : IF1
 * TGL   : 09/07/2021
 * Deskripsi : Menampilkan halaman Navigation
 * */

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.shrikanthravi.customnavigationdrawer2.data.MenuItem;
import com.shrikanthravi.customnavigationdrawer2.widget.SNavigationDrawer;

import java.util.ArrayList;
import java.util.List;

import edu.adichandra.mapnesiaapp.Fragment.Navigation.AboutFragment;
import edu.adichandra.mapnesiaapp.Fragment.Navigation.HomeFragment;
import edu.adichandra.mapnesiaapp.Fragment.Navigation.PahlawanFragment;
import edu.adichandra.mapnesiaapp.R;

public class NavigationActivity extends AppCompatActivity {

    SNavigationDrawer navigationDrawer;
    Class fragmentClass;
    public static Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        navigationDrawer = findViewById(R.id.navigationDrawer);

        //menu add

        List<MenuItem> menuItems = new ArrayList<>();

        menuItems.add(new MenuItem("Home",R.drawable.home));
        menuItems.add(new MenuItem("List Pahlawan",R.drawable.pahlawan));
        menuItems.add(new MenuItem("About",R.drawable.about));

        navigationDrawer.setMenuItemList(menuItems);
        fragmentClass = HomeFragment.class;

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        if (fragment!=null){

            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in,
                    android.R.animator.fade_out).replace(R.id.framelayout,fragment).commit();
        }

        navigationDrawer.setOnMenuItemClickListener(new SNavigationDrawer.OnMenuItemClickListener() {
            @Override
            public void onMenuItemClicked(int position) {
                System.out.println("Position " + position);

                switch (position) {
                    case 0: {
                        fragmentClass = HomeFragment.class;
                        break;
                    }
                    case 1: {
                        fragmentClass = PahlawanFragment.class;
                        break;
                    }
                    case 2: {
                        fragmentClass = AboutFragment.class;
                        break;
                    }
                }
            }
        });

        navigationDrawer.setDrawerListener(new SNavigationDrawer.DrawerListener() {

            @Override
            public void onDrawerOpening() {

            }

            @Override
            public void onDrawerClosing() {
                System.out.println("Drawer closed");

                try {
                    fragment = (Fragment) fragmentClass.newInstance();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }

                if (fragment!=null){

                    FragmentManager fragmentManager = getSupportFragmentManager();

                    fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in,
                            android.R.animator.fade_out).replace(R.id.framelayout,fragment).commit();
                }
            }

            @Override
            public void onDrawerOpened() {

            }

            @Override
            public void onDrawerClosed() {

            }

            @Override
            public void onDrawerStateChanged(int newState) {
                System.out.println("State "+newState);
            }

        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}