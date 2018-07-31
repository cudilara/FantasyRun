package com.example.dilaramadinger.fantasyrun;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class WearableFragment extends Fragment {


    public WearableFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_wearable, container, false);
    }

    @Override
    public void onStart(){
        super.onStart();
        View view = getView();
        if (view != null){
            //Sets text for the title in the top of the app
            String wearableTitle = getResources().getString(R.string.wearable_title);
            getActivity().setTitle(wearableTitle);

            final Button button = getView().findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    SampleFragment sampleFragment = new SampleFragment();
                    FragmentTransaction sampleFragTrans = getFragmentManager().beginTransaction();
                    sampleFragTrans.replace(R.id.myfrag, sampleFragment);
                    sampleFragTrans.commit();
                }
            });
            final Button button2 = getView().findViewById(R.id.button2);
            button2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    SampleFragment sampleFragment = new SampleFragment();
                    FragmentTransaction sampleFragTrans = getFragmentManager().beginTransaction();
                    sampleFragTrans.replace(R.id.myfrag, sampleFragment);
                    sampleFragTrans.commit();
                }
            });
        }
    }
}
