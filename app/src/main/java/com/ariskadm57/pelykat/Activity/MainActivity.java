package com.ariskadm57.pelykat.Activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.ariskadm57.pelykat.Fragment.HomeFragment;
import com.ariskadm57.pelykat.Fragment.LaundryFragment;
import com.ariskadm57.pelykat.Fragment.MapsFragment;
import com.ariskadm57.pelykat.R;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.navigationView);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){

                    case R.id.navigation_home:
                        HomeFragment homeFragment = new HomeFragment();
                        FragmentTransaction ftHome = getSupportFragmentManager().beginTransaction();
                        ftHome.replace(R.id.container, homeFragment);
                        ftHome.addToBackStack(null);
                        ftHome.commit();

                        break;

                    case R.id.navigation_list:
                        LaundryFragment laundryFragment = new LaundryFragment();
                        FragmentTransaction ftLaundry = getSupportFragmentManager().beginTransaction();
                        ftLaundry.replace(R.id.container, laundryFragment);
                        ftLaundry.addToBackStack(null);
                        ftLaundry.commit();
                        break;

                    case R.id.navigation_maps:
                        MapsFragment mapsFragment = new MapsFragment();
                        FragmentTransaction ftMaps = getSupportFragmentManager().beginTransaction();
                        ftMaps.replace(R.id.container, mapsFragment);
                        ftMaps.addToBackStack(null);
                        ftMaps.commit();
                        break;
                }
                return true;
            }
        });

    }
}
