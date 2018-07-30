package com.example.dilaramadinger.fantasyrun;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Location currentLocation = new Location("");
    private LocationManager locationManager;
    private LocationListener locationListener;

    //public method to get location from other fragments
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
                    themeFragTrans.commit();
                    return true;
                case R.id.navigation_dashboard:
                    WearableFragment wearFragment = new WearableFragment();
                    FragmentTransaction wearFragTrans = getFragmentManager().beginTransaction();
                    wearFragTrans.replace(R.id.myfrag, wearFragment);
                    wearFragTrans.commit();
                    return true;

                case R.id.navigation_notifications:
//                    MyInfoFragment myInfoFragment = new MyInfoFragment();
//                    FragmentTransaction myInfoFragTrans = getFragmentManager().beginTransaction();
//                    myInfoFragTrans.replace(R.id.myfrag, myInfoFragment);
//                    myInfoFragTrans.commit();
//                    return true;
                    SampleFragment myInfoFragment = new SampleFragment();
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
         navigation.setBackgroundColor(getColor(R.color.colorPrimary));

        ThemeChoiceFragment themeFragment = new ThemeChoiceFragment();
        FragmentTransaction themeFragTrans = getFragmentManager().beginTransaction();
        themeFragTrans.replace(R.id.myfrag, themeFragment);
        themeFragTrans.commit();

        //audio
        final MediaPlayer music = MediaPlayer.create(this, R.raw.autumnleavesjustpiano);
        Button musicB = (Button) this.findViewById(R.id.playMusic);

        class MusicStatus{
            public String status;
            public MusicStatus(){this.status = "paused";}
        }

        final MusicStatus musicStatus = new MusicStatus();

        musicB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(musicStatus.status == "paused"){
                    music.start();
                    musicStatus.status = "playing";
                }
                else{
                    music.pause();
                    musicStatus.status = "paused";
                }

            }
        });
        //end audio



        //start gps
        locationManager = (LocationManager) this.getSystemService(LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                //This method is called when there is an update to location
                Log.d("Location",location.toString());
                currentLocation = location;
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {
                Log.d("Location","statusChanged");
            }

            @Override
            public void onProviderEnabled(String s) {
                Log.d("Location","onProviderEnabled");
            }

            @Override
            public void onProviderDisabled(String s) {
                Log.d("Location","onProviderDisabled");

            }
        };

        //permission checks
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            //if permission is not given yet ask for them
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }else{
            //if permission is already granted start the listener
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
        }
    }

    //if you asked for permission and it was granted start the listener
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,  @NonNull int[] grantResults){
        super.onRequestPermissionsResult(requestCode,permissions,grantResults);

        if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){

                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
            }
        }

    }


}
