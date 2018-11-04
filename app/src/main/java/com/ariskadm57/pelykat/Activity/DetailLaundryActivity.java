package com.ariskadm57.pelykat.Activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ariskadm57.pelykat.Model.Laundry;
import com.ariskadm57.pelykat.R;
import com.ariskadm57.pelykat.Util.GlideApp;
import com.bumptech.glide.request.RequestOptions;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class DetailLaundryActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "DetailLaundry";

    Button btnNavigasi, btnChat, btnOrder;
    TextView tvNamaLaundry, tvNamaPemilik, tvAlamat;
    ImageView imgLaundry;
    String latlong, telepon;
    String pesan = "Hallo kak, bisa pesan laundry nya?";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_laundry);

        tvNamaLaundry   = findViewById(R.id.tv_nama_laundry);
        tvNamaPemilik   = findViewById(R.id.tv_nama_pemilik);
        tvAlamat        = findViewById(R.id.tv_alamat);
        imgLaundry      = findViewById(R.id.img_laundry);

        btnNavigasi     = findViewById(R.id.btnNavigasi);
        btnChat         = findViewById(R.id.btnChat);
        btnOrder        = findViewById(R.id.btnOrder);

        btnNavigasi.setOnClickListener(this);
        btnChat.setOnClickListener(this);
        btnOrder.setOnClickListener(this);


        Laundry detailLaundry = getIntent().getParcelableExtra("LAUNDRY");
        tvNamaLaundry.setText(detailLaundry.getuNamaLaundry());
        tvNamaPemilik.setText(detailLaundry.getuNamaPemilik());
        tvAlamat.setText(detailLaundry.getuAlamat());

        latlong = detailLaundry.getuLatitude() + "," + detailLaundry.getuLongitude();
        telepon = detailLaundry.getuTelepon();


        StorageReference fotoRef = FirebaseStorage.getInstance().getReference("FotoLaundry").child(detailLaundry.getuLaundryID());
        GlideApp.with(this)
                .load(fotoRef)
                .apply(RequestOptions.circleCropTransform())
                .into(imgLaundry);

    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        Uri uri = null;

        switch (view.getId()){
            case R.id.btnNavigasi:
                uri = Uri.parse("google.navigation:q=" + latlong);
                intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setPackage("com.google.android.apps.maps");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "Pleas install Google Maps.",
                            Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btnChat:
                try {
                    uri = Uri.parse("https://api.whatsapp.com/send?phone=%s" + telepon + "&text=" + URLEncoder.encode(pesan, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setPackage("com.whatsapp");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "Please install whatsApp", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnOrder:
                Toast.makeText(this, "Order gan", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
