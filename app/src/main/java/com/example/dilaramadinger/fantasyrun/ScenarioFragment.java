package com.example.dilaramadinger.fantasyrun;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;


public class ScenarioFragment extends Fragment {


    public ScenarioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_scenario, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {
            String scenarioTitle = getResources().getString(R.string.scenario_title);
            getActivity().setTitle(scenarioTitle);

            final Button startRunButton = getView().findViewById(R.id.button_start);
            startRunButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    RunFragment runFragment = new RunFragment();
                    FragmentTransaction runFragTrans = getFragmentManager().beginTransaction();
                    runFragTrans.replace(R.id.myfrag, runFragment, "frag");
                    runFragTrans.commit();
                }
            });

            final ImageButton backButton = getView().findViewById(R.id.imageBackButton);
            backButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    ThemeChoiceFragment themeFragment = new ThemeChoiceFragment();
                    FragmentTransaction themeFragTrans = getFragmentManager().beginTransaction();
                    themeFragTrans.replace(R.id.myfrag, themeFragment, "frag");
                    themeFragTrans.commit();
                }
            });
        }
    }
}
