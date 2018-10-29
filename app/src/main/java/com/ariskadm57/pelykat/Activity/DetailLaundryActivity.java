package com.ariskadm57.pelykat.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.ariskadm57.pelykat.Model.Laundry;
import com.ariskadm57.pelykat.R;

public class DetailLaundryActivity extends AppCompatActivity {
    private static final String TAG = "DetailLaundry";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_laundry);

        Laundry detailLaundry = getIntent().getParcelableExtra("LAUNDRY");
        Log.e(TAG, "onCreate: " + detailLaundry.getuNamaLaundry() );
        Log.e(TAG, "onCreate: " + detailLaundry.getuNamaPemilik() );
        Log.e(TAG, "onCreate: " + detailLaundry.getuAlamat() );
        Log.e(TAG, "onCreate: " + detailLaundry.getuTelepon() );
    }
}
