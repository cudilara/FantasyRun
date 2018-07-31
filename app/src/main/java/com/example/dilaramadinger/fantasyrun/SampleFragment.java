package com.example.dilaramadinger.fantasyrun;


import android.Manifest;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SampleFragment extends Fragment {

    private Button bGPS;
    private TextView textView;
    private LocationManager locationManager;
    private LocationListener locationListener;
    public SampleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sample, container, false);

    }

    @Override
    public void onStart() {

        super.onStart();
        View view = getView();
        if (view != null) {
            final Button button = view.findViewById(R.id.buttonGPS);
            final TextView textView = view.findViewById(R.id.textGPS);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    textView.setText(((MainActivity)getActivity()).getLocation().toString());
                }
            });
            }

        }


    }












