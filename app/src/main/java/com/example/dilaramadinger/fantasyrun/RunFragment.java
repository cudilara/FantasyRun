package com.example.dilaramadinger.fantasyrun;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import pl.droidsonroids.gif.GifTextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class RunFragment extends Fragment {

    public RunFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_run, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {
            String scenarioTitle = getResources().getString(R.string.run_title);
            getActivity().setTitle(scenarioTitle);

            final GifTextView myGif = getView().findViewById(R.id.my_gif);

            final ImageButton backButton = getView().findViewById(R.id.imageBackButtonRun);
            backButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    ScenarioFragment scenarioFragment = new ScenarioFragment();
                    FragmentTransaction scenFragTrans = getFragmentManager().beginTransaction();
                    scenFragTrans.replace(R.id.myfrag, scenarioFragment);
                    scenFragTrans.commit();
                }
            });

            final Button endRunButton = getView().findViewById(R.id.button_end_run);
            endRunButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    SummaryFragment summaryFragment = new SummaryFragment();
                    FragmentTransaction summaryFragTrans = getFragmentManager().beginTransaction();
                    summaryFragTrans.replace(R.id.myfrag, summaryFragment);
                    summaryFragTrans.commit();
                }
            });

            final Button pauseButton = getView().findViewById(R.id.button_pause);
            pauseButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    TextView pausedTxt = getView().findViewById(R.id.paused_textview);
                    if(pauseButton.getText().equals("Resume")){
                        pauseButton.setText("Pause");
                        endRunButton.setEnabled(true);
                        backButton.setEnabled(true);
                        pausedTxt.setText("");
                        myGif.setVisibility(View.VISIBLE);
                    } else {
                        pauseButton.setText("Resume");
                        endRunButton.setEnabled(false);
                        backButton.setEnabled(false);
                        pausedTxt.setText(getResources().getString(R.string.paused));
                        myGif.setVisibility(View.INVISIBLE);
                    }
                }
            });
        }
    }

}
