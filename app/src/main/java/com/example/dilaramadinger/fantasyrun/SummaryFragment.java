package com.example.dilaramadinger.fantasyrun;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class SummaryFragment extends Fragment {


    public SummaryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_summary, container, false);
    }


    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {
            String scenarioTitle = getResources().getString(R.string.summary_title);
            getActivity().setTitle(scenarioTitle);

            final ImageButton backButton = getView().findViewById(R.id.imageBackButtonSummary);
            backButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    ThemeChoiceFragment themeFragment = new ThemeChoiceFragment();
                    FragmentTransaction themeFragTrans = getFragmentManager().beginTransaction();
                    themeFragTrans.replace(R.id.myfrag, themeFragment);
                    themeFragTrans.commit();
                }
            });
        }
    }
}
