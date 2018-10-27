package com.ariskadm57.pelykat.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Order implements Parcelable {
    private String uCustomerID;
    private String uOrderID;
    private String uLaundryID;
    private String uStatus;
    private String uNote;
    private int uJumlahPakaian;
    private double uBerat;
    private double uHarga;

    public Order() {
    }

    public Order(String uCustomerID, String uOrderID, String uLaundryID, String uStatus, String uNote, int uJumlahPakaian, double uBerat, double uHarga) {
        this.uCustomerID = uCustomerID;
        this.uOrderID = uOrderID;
        this.uLaundryID = uLaundryID;
        this.uStatus = uStatus;
        this.uNote = uNote;
        this.uJumlahPakaian = uJumlahPakaian;
        this.uBerat = uBerat;
        this.uHarga = uHarga;
    }

    public String getuCustomerID() {
        return uCustomerID;
    }

    public void setuCustomerID(String uCustomerID) {
        this.uCustomerID = uCustomerID;
    }

    public String getuOrderID() {
        return uOrderID;
    }

    public void setuOrderID(String uOrderID) {
        this.uOrderID = uOrderID;
    }

    public String getuLaundryID() {
        return uLaundryID;
    }

    public void setuLaundryID(String uLaundryID) {
        this.uLaundryID = uLaundryID;
    }

    public String getuStatus() {
        return uStatus;
    }

    public void setuStatus(String uStatus) {
        this.uStatus = uStatus;
    }

    public String getuNote() {
        return uNote;
    }

    public void setuNote(String uNote) {
        this.uNote = uNote;
    }

    public int getuJumlahPakaian() {
        return uJumlahPakaian;
    }

    public void setuJumlahPakaian(int uJumlahPakaian) {
        this.uJumlahPakaian = uJumlahPakaian;
    }

    public double getuBerat() {
        return uBerat;
    }

    public void setuBerat(double uBerat) {
        this.uBerat = uBerat;
    }

    public double getuHarga() {
        return uHarga;
    }

    public void setuHarga(double uHarga) {
        this.uHarga = uHarga;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.uCustomerID);
        dest.writeString(this.uOrderID);
        dest.writeString(this.uLaundryID);
        dest.writeString(this.uStatus);
        dest.writeString(this.uNote);
        dest.writeInt(this.uJumlahPakaian);
        dest.writeDouble(this.uBerat);
        dest.writeDouble(this.uHarga);
    }

    protected Order(Parcel in) {
        this.uCustomerID = in.readString();
        this.uOrderID = in.readString();
        this.uLaundryID = in.readString();
        this.uStatus = in.readString();
        this.uNote = in.readString();
        this.uJumlahPakaian = in.readInt();
        this.uBerat = in.readDouble();
        this.uHarga = in.readDouble();
    }

    public static final Creator<Order> CREATOR = new Creator<Order>() {
        @Override
        public Order createFromParcel(Parcel source) {
            return new Order(source);
        }

        @Override
        public Order[] newArray(int size) {
            return new Order[size];
        }
    };
}
