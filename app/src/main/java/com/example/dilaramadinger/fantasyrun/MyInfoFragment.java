package com.example.dilaramadinger.fantasyrun;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyInfoFragment extends Fragment {
    public String userAge;
    public String userHeight;
    public String userWeight;
    EditText ageEdit;
    EditText heightEdit;
    EditText weightEdit;
    Button buttonSubmit;
    TextView saved;

    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;



    public MyInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_info, container, false);
    }

    @Override
    public void onStart(){
        super.onStart();
        final View view = getView();
        if (view != null){
            //Sets text for the title in the top of the app
            String myInfoTitle = getResources().getString(R.string.my_info_title);
            getActivity().setTitle(myInfoTitle);
            ageEdit = (EditText)view.findViewById(R.id.textViewAgeInput);
            heightEdit = (EditText)view.findViewById(R.id.textViewHeightInput);
            weightEdit = (EditText)view.findViewById(R.id.textViewWeightInput);
            sharedPref= getContext().getSharedPreferences("myPref", Context.MODE_PRIVATE);
            if(sharedPref.getString("age","") != null){
                userAge = sharedPref.getString("age","");
            }
            if(sharedPref.getString("height","") != null){
                userHeight = sharedPref.getString("height","");
            }
            if(sharedPref.getString("weight","") != null){
                userWeight = sharedPref.getString("weight","");
            }
            if(userAge != null){
                ageEdit.setText(userAge);
            }
            if(userHeight != null){
                heightEdit.setText(userHeight);
            }
            if(userWeight != null){
                weightEdit.setText(userWeight);
            }






            buttonSubmit = (Button)view.findViewById(R.id.bSubmit);
            buttonSubmit.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    userAge = ageEdit.getText().toString();
                    userHeight = heightEdit.getText().toString();
                    userWeight = weightEdit.getText().toString();

                    editor=sharedPref.edit();
                    editor.putString("age", userAge);
                    editor.putString("height", userHeight);
                    editor.putString("weight", userWeight);
                    editor.commit();

                    saved = view.findViewById(R.id.savedIndicator);
                    saved.setText("Info Saved");
                }
            });

//            buttonSubmit.setOnClickListener(new View.OnClickListener() {
//                public void onClick(View view) {
//                    ageEdit = (EditText)view.findViewById(R.id.textViewAgeInput);
//                    //userAge = ageEdit.getText().toString();
//                    Log.d("user", ageEdit.getText().toString());
//                }
//            });

        }
    }
}
