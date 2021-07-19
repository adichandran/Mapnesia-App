package edu.adichandra.mapnesiaapp.Fragment.Navigation;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import edu.adichandra.mapnesiaapp.Activity.SplashActivity;
import edu.adichandra.mapnesiaapp.Adapter.PahlawanAdapter;
import edu.adichandra.mapnesiaapp.Adapter.RekPahlawanAdapter;
import edu.adichandra.mapnesiaapp.Model.PahlawanModel;
import edu.adichandra.mapnesiaapp.NotificationReceiver;
import edu.adichandra.mapnesiaapp.R;

import static android.widget.LinearLayout.HORIZONTAL;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {


    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    private List<PahlawanModel> listPahlawan;
    private RekPahlawanAdapter pahlawanAdapter;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_home, container, false);

        final FragmentActivity fragment = getActivity();

        listPahlawan = new ArrayList<>();
        getData(listPahlawan);

        RecyclerView recyclerView = view.findViewById(R.id.listRek);
        pahlawanAdapter = new RekPahlawanAdapter(view.getContext(),listPahlawan);
        recyclerView.setLayoutManager(new LinearLayoutManager(fragment, LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(pahlawanAdapter);

        return view;
    }

    public void getData(List<PahlawanModel> listPahlawan){
        try {
            // get JSONObject from JSON file
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            // fetch JSONArray named users
            JSONArray userArray = obj.getJSONArray("data");
            // implement for loop for getting users list data
            for (int i = 0; i < userArray.length(); i++) {
                // create a JSONObject for fetching single user data
                JSONObject userDetail = userArray.getJSONObject(i);

                PahlawanModel pahlawan = new PahlawanModel();
                // fetch email and name and store it in arraylist

                pahlawan.setNama(userDetail.getString("pahlawan_name"));
                pahlawan.setImage(userDetail.getString("pahlawan_image"));
                pahlawan.setAsal(userDetail.getString("asal"));
                pahlawan.setLahir(userDetail.getString("lahir"));
                pahlawan.setMeninggal(userDetail.getString("meninggal"));
                pahlawan.setMakam(userDetail.getString("makam"));
                pahlawan.setSerjarah_singkat(userDetail.getString("riwayat"));
                this.listPahlawan.add(pahlawan);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getResources().getAssets().open("pahlawan-data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}