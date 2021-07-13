package edu.adichandra.mapnesiaapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import edu.adichandra.mapnesiaapp.Fragment.Navigation.PahlawanFragment;
import edu.adichandra.mapnesiaapp.R;

public class PahlawanAdapter extends RecyclerView.Adapter<PahlawanAdapter.MyViewHolder> {

    ArrayList<String> namaPahlawan;
    ArrayList<String> img;
    ArrayList<String> asal;
    Context context;

    public PahlawanAdapter(PahlawanFragment pahlawanFragment, ArrayList<String> namaPahlawan, ArrayList<String> img, ArrayList<String> asal) {
        this.namaPahlawan = namaPahlawan;
        this.img = img;
        this.asal = asal;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_pahlawan, parent, false);
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        // set the data in items
        holder.nama_pahlawan.setText(namaPahlawan.get(position));
        Picasso.get().load(img.get(position)).into(holder.image);
        holder.asal.setText(asal.get(position));
        // implement setOnClickListener event on item view.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // display a toast with person name on item click
                Toast.makeText(context, namaPahlawan.get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public int getItemCount() {
        return namaPahlawan.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nama_pahlawan, asal;
        ImageView image;// init the item view's

        public MyViewHolder(View itemView) {
            super(itemView);

            // get the reference of item view's
            nama_pahlawan = (TextView) itemView.findViewById(R.id.txt_name);
            asal = (TextView) itemView.findViewById(R.id.txt_asal);
            image = (ImageView) itemView.findViewById(R.id.img_pahlawan);
        }
    }
}
