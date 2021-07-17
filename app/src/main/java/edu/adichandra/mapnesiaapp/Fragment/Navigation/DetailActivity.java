package edu.adichandra.mapnesiaapp.Fragment.Navigation;

/*
 * NIM   : 10118015
 * NAMA  : Adi Chandra Nugraha
 * KELAS : IF1
 * TGL   : 14/07/2021
 * Deskripsi : Menampilkan halaman activity_detail dan menerima nilai dari Pahlawan Fragment
 * */

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import edu.adichandra.mapnesiaapp.R;

public class DetailActivity extends AppCompatActivity {

    private AppBarLayout detailAppBarLayout;
    private Toolbar toolbar;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String nama = getIntent().getExtras().getString("pahlawan-name");
        String image = getIntent().getExtras().getString("pahlawan-image");
        String asal = getIntent().getExtras().getString("asal");
        String lahir = getIntent().getExtras().getString("lahir");
        String meninggal = getIntent().getExtras().getString("meninggal");
        String makam = getIntent().getExtras().getString("makam");
        String riwayat = getIntent().getExtras().getString("riwayat");

        //int views
        TextView ph_nama = findViewById(R.id.name);
        TextView ph_asal = findViewById(R.id.asal);
        TextView ph_lahir = findViewById(R.id.lahir);
        TextView ph_meninggal = findViewById(R.id.meninggal);
        TextView ph_makam = findViewById(R.id.makam);
        TextView ph_riwayat = findViewById(R.id.riwayat_singkat);
        ImageView img = findViewById(R.id.image);
        detailAppBarLayout = findViewById(R.id.appbarlayout_id);
        toolbar = findViewById(R.id.toolbar_id);
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.detailCollapsingToolbarLayout);


        //set value
        ph_nama.setText(nama);
        ph_asal.setText(asal);
        ph_lahir.setText(lahir);
        ph_meninggal.setText(meninggal);
        ph_makam.setText(makam);
        ph_riwayat.setText(riwayat);

        //set image
        Picasso.get().load(image).into(img);

        //set title collaps
        collapsingToolbarLayout.setTitleEnabled(false);

        toolbarTextShowSettings(nama);
    }

    /* AppBarLayout Fungsi menyediakan penyesuaian tampilan judul */
    private void toolbarTextShowSettings(final String nama) {
        detailAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {

            boolean isVisible = true;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    toolbar.setTitle(nama);
                    isVisible = true;
                } else if (isVisible) {
                    toolbar.setTitle("");
                    isVisible = false;
                }
            }
        });
    }

    /* BackPressed metode yang berhubungan dengan situasi. */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.layout.fragment_pahlawan) {
            //finish();
            onBackPressed();

        }
        return super.onOptionsItemSelected(item);
    }
}