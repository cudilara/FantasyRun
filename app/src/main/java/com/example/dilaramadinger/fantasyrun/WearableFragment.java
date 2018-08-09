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

            final Button blueToothConnectedButton = getView().findViewById(R.id.buttonConnected);
            blueToothConnectedButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    ThemeChoiceFragment themeFragment = new ThemeChoiceFragment();
                    Bundle args = new Bundle();
                    args.putString("wearable", "on");
                    themeFragment.setArguments(args);
                    FragmentTransaction themeFragTrans = getFragmentManager().beginTransaction();
                    themeFragTrans.replace(R.id.myfrag, themeFragment, "frag");
                    themeFragTrans.commit();
                }
            });
        }
    }
}
