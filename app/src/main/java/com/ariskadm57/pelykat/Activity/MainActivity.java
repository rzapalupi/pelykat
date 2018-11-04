package com.ariskadm57.pelykat.Activity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.ariskadm57.pelykat.Fragment.HomeFragment;
import com.ariskadm57.pelykat.Fragment.LaundryFragment;
import com.ariskadm57.pelykat.Fragment.MapsFragment;
import com.ariskadm57.pelykat.Model.Laundry;
import com.ariskadm57.pelykat.Model.Order;
import com.ariskadm57.pelykat.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements
        LaundryFragment.OnFragmentInteractionListener
{

    private static final String TAG = "MainActivity";
    static boolean is_database_called = false; // flag for firebase Status

    BottomNavigationView bottomNavigationView;

    DatabaseReference db_laundry_reference, db_order_reference;
    ArrayList<Laundry> list_laundry = new ArrayList<>();
    ArrayList<Order> list_order = new ArrayList<>();
    Order current_order = new Order();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.navigationView);

        if(!is_database_called){
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
            is_database_called = true;
        }

        db_laundry_reference = FirebaseDatabase.getInstance().getReference("Laundry");
        db_laundry_reference.keepSynced(true);
        db_order_reference = FirebaseDatabase.getInstance().getReference("Order");
        db_order_reference.keepSynced(true);


        if(isNetworkAvailable(getApplicationContext())) {
            getListLaundry();
        }else {
            list_laundry.clear();
            getCache();
        }


        HomeFragment homeFragment = new HomeFragment();
        FragmentTransaction ftHome = getSupportFragmentManager().beginTransaction();
        ftHome.replace(R.id.container, homeFragment);
        ftHome.commit();


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment = null;
                switch (menuItem.getItemId()){

                    case R.id.navigation_home:
                        HomeFragment homeFragment = new HomeFragment();
                        FragmentTransaction ftHome = getSupportFragmentManager().beginTransaction();
                        ftHome.replace(R.id.container, homeFragment);
                        ftHome.commit();
                        break;

                    case R.id.navigation_list:
                        fragment = LaundryFragment.newInstance();
                        break;

                    case R.id.navigation_maps:
                        MapsFragment mapsFragment = new MapsFragment();
                        FragmentTransaction ftMaps = getSupportFragmentManager().beginTransaction();
                        ftMaps.replace(R.id.container, mapsFragment);
                        ftMaps.commit();
                        break;
                }

                if (fragment != null){
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.container, fragment);
                    fragmentTransaction.commit();
                }

                return true;
            }
        });

    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    public ArrayList<Laundry> getDataLaundryList() {
        return list_laundry;
    }

    public void getListLaundry() {
        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list_laundry.clear();
                for (DataSnapshot laundrySnapshot: dataSnapshot.getChildren()) {
                    Laundry laundry = laundrySnapshot.getValue(Laundry.class);
                    String laundryID = laundrySnapshot.getKey();
                    laundry.setuLaundryID(laundryID);
                    list_laundry.add(laundry);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e(TAG, "loadNote:onCancelled", databaseError.toException());

            }
        };
        db_laundry_reference.addValueEventListener(valueEventListener);
    }

    public void getCache(){
        db_laundry_reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Laundry laundry = dataSnapshot.getValue(Laundry.class);
                String laundryID = dataSnapshot.getKey();
                laundry.setuLaundryID(laundryID);
                list_laundry.add(laundry);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
