package com.example.dilaramadinger.fantasyrun;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.app.FragmentTransaction;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    private Location currentLocation = new Location("");
    private LocationManager locationManager;
    private LocationListener locationListener;
    private Stack<Fragment> stack;

    public Location getLocation(){
        return currentLocation;
    }

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

        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

//        getSupportActionBar().setLogo(R.drawable.run_launch);
//        getSupportActionBar().setIcon(R.drawable.run_launch);

        // Use this line for coloring the bottom menu
         navigation.setBackgroundColor(getColor(R.color.colorBottomMenu));

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
