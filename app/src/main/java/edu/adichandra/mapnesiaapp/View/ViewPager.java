package edu.adichandra.mapnesiaapp.View;

/*
 * NIM   : 10118015
 * NAMA  : Adi Chandra Nugraha
 * KELAS : IF1
 * TGL   : 09/07/2021
 * Deskripsi : Menampilkan tampilan Onboarding
 * */

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import org.jetbrains.annotations.NotNull;

import edu.adichandra.mapnesiaapp.Fragment.Onboarding.Onboarding_FragmentA;
import edu.adichandra.mapnesiaapp.Fragment.Onboarding.Onboarding_FragmentB;
import edu.adichandra.mapnesiaapp.Fragment.Onboarding.Onboarding_FragmentC;

public class ViewPager extends FragmentPagerAdapter {
    public ViewPager(@NonNull @NotNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @NotNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 : return new Onboarding_FragmentA();
            case 1 : return new Onboarding_FragmentB();
            case 2 : return new Onboarding_FragmentC();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
