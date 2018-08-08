package com.example.dilaramadinger.fantasyrun;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class ThemeChoiceFragment extends Fragment {
    String wearableState;

    public ThemeChoiceFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_theme_choice, container, false);
    }

    @Override
    public void onStart(){
        super.onStart();
        View view = getView();
        if (view != null){
            String themeTitle = getResources().getString(R.string.theme_title);
            getActivity().setTitle(themeTitle);

            final ImageButton button = getView().findViewById(R.id.imageButton3);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    ScenarioFragment scenarioFragment = new ScenarioFragment();
                    FragmentTransaction scenFragTrans = getFragmentManager().beginTransaction();
                    scenFragTrans.replace(R.id.myfrag, scenarioFragment);
                    scenFragTrans.commit();
                }
            });


            Bundle bundle = getArguments();
            if(bundle != null){
                wearableState = bundle.getString("wearable");
                if(Objects.equals(wearableState, "on")){

                }
            }
        }
    }
}
