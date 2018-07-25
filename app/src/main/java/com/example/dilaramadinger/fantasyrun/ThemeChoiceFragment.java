package com.example.dilaramadinger.fantasyrun;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ThemeChoiceFragment extends Fragment {


    public ThemeChoiceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_theme_choice, container, false);
    }

    @Override
    public void onStart(){
        super.onStart();
        View view = getView();
        if (view != null){
            //Sets text for the title in the top of the app
            String themeTitle = getResources().getString(R.string.theme_title);
            getActivity().setTitle(themeTitle);
        }
    }

}
