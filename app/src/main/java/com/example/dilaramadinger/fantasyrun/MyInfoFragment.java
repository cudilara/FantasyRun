package com.example.dilaramadinger.fantasyrun;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


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

    @RequiresApi(api = Build.VERSION_CODES.M)
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
            userAge = sharedPref.getString("age","");
            userHeight = sharedPref.getString("height","");
            userWeight = sharedPref.getString("weight","");
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
                    editor.apply();

                    saved = view.findViewById(R.id.savedIndicator);
                    saved.setText(R.string.saved_myinfo_text);
                }
            });
        }
    }
}
