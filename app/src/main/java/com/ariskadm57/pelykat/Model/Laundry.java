package com.ariskadm57.pelykat.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Laundry implements Parcelable {

    private String uLaundryID;
    private String uNamaLaundry;
    private String uNamaPemilik;
    private String uAlamat;
    private String uTelepon;
    private boolean uStatus;
    private double uLatitude;
    private double uLongitude;
    private double uJarak;
    private double uRate;

    public Laundry() {
    }

    public Laundry(String uLaundryID, String uNamaLaundry, String uNamaPemilik, String uAlamat, String uTelepon, Boolean uStatus, double uLatitude, double uLongitude, double uJarak, double uRate) {
        this.uLaundryID = uLaundryID;
        this.uNamaLaundry = uNamaLaundry;
        this.uNamaPemilik = uNamaPemilik;
        this.uAlamat = uAlamat;
        this.uTelepon = uTelepon;
        this.uStatus = uStatus;
        this.uLatitude = uLatitude;
        this.uLongitude = uLongitude;
        this.uJarak = uJarak;
        this.uRate = uRate;
    }

    public String getuLaundryID() {
        return uLaundryID;
    }

    public void setuLaundryID(String uLaundryID) {
        this.uLaundryID = uLaundryID;
    }

    public String getuNamaLaundry() {
        return uNamaLaundry;
    }

    public void setuNamaLaundry(String uNamaLaundry) {
        this.uNamaLaundry = uNamaLaundry;
    }

    public String getuNamaPemilik() {
        return uNamaPemilik;
    }

    public void setuNamaPemilik(String uNamaPemilik) {
        this.uNamaPemilik = uNamaPemilik;
    }

    public String getuAlamat() {
        return uAlamat;
    }

    public void setuAlamat(String uAlamat) {
        this.uAlamat = uAlamat;
    }

    public String getuTelepon() {
        return uTelepon;
    }

    public void setuTelepon(String uTelepon) {
        this.uTelepon = uTelepon;
    }

    public Boolean getuStatus() {
        return uStatus;
    }

    public void setuStatus(Boolean uStatus) {
        this.uStatus = uStatus;
    }

    public double getuLatitude() {
        return uLatitude;
    }

    public void setuLatitude(double uLatitude) {
        this.uLatitude = uLatitude;
    }

    public double getuLongitude() {
        return uLongitude;
    }

    public void setuLongitude(double uLongitude) {
        this.uLongitude = uLongitude;
    }

    public double getuJarak() {
        return uJarak;
    }

    public void setuJarak(double uJarak) {
        this.uJarak = uJarak;
    }

    public double getuRate() {
        return uRate;
    }

    public void setuRate(double uRate) {
        this.uRate = uRate;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.uLaundryID);
        dest.writeString(this.uNamaLaundry);
        dest.writeString(this.uNamaPemilik);
        dest.writeString(this.uAlamat);
        dest.writeString(this.uTelepon);
        dest.writeValue(this.uStatus);
        dest.writeDouble(this.uLatitude);
        dest.writeDouble(this.uLongitude);
        dest.writeDouble(this.uJarak);
        dest.writeDouble(this.uRate);
    }

    protected Laundry(Parcel in) {
        this.uLaundryID = in.readString();
        this.uNamaLaundry = in.readString();
        this.uNamaPemilik = in.readString();
        this.uAlamat = in.readString();
        this.uTelepon = in.readString();
        this.uStatus = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.uLatitude = in.readDouble();
        this.uLongitude = in.readDouble();
        this.uJarak = in.readDouble();
        this.uRate = in.readDouble();
    }

    public static final Creator<Laundry> CREATOR = new Creator<Laundry>() {
        @Override
        public Laundry createFromParcel(Parcel source) {
            return new Laundry(source);
        }

        @Override
        public Laundry[] newArray(int size) {
            return new Laundry[size];
        }
    };
}
