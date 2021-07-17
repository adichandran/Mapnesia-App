package edu.adichandra.mapnesiaapp.Adapter;

/*
 * NIM   : 10118015
 * NAMA  : Adi Chandra Nugraha
 * KELAS : IF1
 * TGL   : 14/07/2021
 * Deskripsi : Adapter dari data pahlawan
 * */

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import edu.adichandra.mapnesiaapp.Fragment.Navigation.DetailActivity;
import edu.adichandra.mapnesiaapp.Model.PahlawanModel;
import edu.adichandra.mapnesiaapp.R;

public class RekPahlawanAdapter extends RecyclerView.Adapter<RekPahlawanAdapter.MyViewHolder> {

    private Context mContext;
    private List<PahlawanModel> mData;

    public RekPahlawanAdapter(Context mContext, List<PahlawanModel> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_rek_pahlawan, parent, false);
        final MyViewHolder viewHolder = new MyViewHolder(view);
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, DetailActivity.class);
                i.putExtra("pahlawan-name",mData.get(viewHolder.getAdapterPosition()).getNama());
                i.putExtra("pahlawan-image",mData.get(viewHolder.getAdapterPosition()).getImage());
                i.putExtra("asal",mData.get(viewHolder.getAdapterPosition()).getAsal());
                i.putExtra("lahir",mData.get(viewHolder.getAdapterPosition()).getLahir());
                i.putExtra("meninggal",mData.get(viewHolder.getAdapterPosition()).getMeninggal());
                i.putExtra("makam",mData.get(viewHolder.getAdapterPosition()).getMakam());
                i.putExtra("riwayat",mData.get(viewHolder.getAdapterPosition()).getSerjarah_singkat());
                mContext.startActivity(i);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        // set the data in items
        Picasso.get().load(mData.get(position).getImage()).into(holder.image);
    }


    @Override
    public int getItemCount() {
        return 10;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        LinearLayout view_container;

        public MyViewHolder(View itemView) {
            super(itemView);

            // get the reference of item view's
            view_container= itemView.findViewById(R.id.container);
            image = (ImageView) itemView.findViewById(R.id.img_pahlawan);
        }
    }

    public void filterList(ArrayList<PahlawanModel> filteredList) {
        mData = filteredList;
        notifyDataSetChanged();
    }
}
