package com.example.dilaramadinger.fantasyrun;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    ThemeChoiceFragment themeFragment = new ThemeChoiceFragment();
                    FragmentTransaction themeFragTrans = getFragmentManager().beginTransaction();
                    themeFragTrans.replace(R.id.myfrag, themeFragment);
                    themeFragTrans.addToBackStack(null);
                    themeFragTrans.commit();
                    return true;
                case R.id.navigation_dashboard:
                    WearableFragment wearFragment = new WearableFragment();
                    FragmentTransaction wearFragTrans = getFragmentManager().beginTransaction();
                    wearFragTrans.replace(R.id.myfrag, wearFragment);
                    wearFragTrans.commit();
                    return true;
                case R.id.navigation_notifications:
                    MyInfoFragment myInfoFragment = new MyInfoFragment();
                    FragmentTransaction myInfoFragTrans = getFragmentManager().beginTransaction();
                    myInfoFragTrans.replace(R.id.myfrag, myInfoFragment);
                    myInfoFragTrans.commit();
                    return true;
            }
            return false;
        }
    };

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // Use this line for coloring the bottom menu
        // navigation.setBackgroundColor(getColor(R.color.colorPrimary));

        ThemeChoiceFragment themeFragment = new ThemeChoiceFragment();
        FragmentTransaction themeFragTrans = getFragmentManager().beginTransaction();
        themeFragTrans.replace(R.id.myfrag, themeFragment);
        themeFragTrans.commit();
    }

    @Override
    public void onBackPressed() {
        if(getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else
            super.onBackPressed();
    }
}
