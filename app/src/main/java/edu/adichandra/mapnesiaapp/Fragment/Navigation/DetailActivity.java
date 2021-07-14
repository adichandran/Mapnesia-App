package edu.adichandra.mapnesiaapp.Fragment.Navigation;

/*
 * NIM   : 10118015
 * NAMA  : Adi Chandra Nugraha
 * KELAS : IF1
 * TGL   : 14/07/2021
 * Deskripsi : Menampilkan halaman activity_detail dan menerima nilai dari Pahlawan Fragment
 * */

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.squareup.picasso.Picasso;

import edu.adichandra.mapnesiaapp.R;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String nama = getIntent().getExtras().getString("pahlawan-name");
        String image = getIntent().getExtras().getString("pahlawan-image");
        String asal = getIntent().getExtras().getString("asal");
        String lahir = getIntent().getExtras().getString("lahir");
        String meninggal = getIntent().getExtras().getString("meninggal");
        String riwayat = getIntent().getExtras().getString("riwayat");

        //int views

        TextView ph_nama = findViewById(R.id.name);
        TextView ph_asal = findViewById(R.id.asal);
        TextView ph_lahir = findViewById(R.id.lahir);
        TextView ph_meninggal = findViewById(R.id.meninggal);
        TextView ph_riwayat = findViewById(R.id.riwayat_singkat);
        ImageView img = findViewById(R.id.image);

        //set value
        ph_nama.setText(nama);
        ph_asal.setText(asal);
        ph_lahir.setText(lahir);
        ph_meninggal.setText(meninggal);
        ph_riwayat.setText(riwayat);

        //set image
        Picasso.get().load(image).into(img);

//        //set title collaps
//        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar_id);
//        collapsingToolbarLayout.setTitleEnabled(true);
//
//        collapsingToolbarLayout.setTitle(nama);

    }
}