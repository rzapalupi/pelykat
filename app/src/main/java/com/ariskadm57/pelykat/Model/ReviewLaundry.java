package com.ariskadm57.pelykat.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class ReviewLaundry implements Parcelable {

    private String uLaundryID;
    private String uOrderID;
    private String uCustomerID;
    private String uComment;
    private String uDate;
    private int uRate;

    public ReviewLaundry() {
    }

    public ReviewLaundry(String uLaundryID, String uOrderID, String uCustomerID, String uComment, String uDate, int uRate) {
        this.uLaundryID = uLaundryID;
        this.uOrderID = uOrderID;
        this.uCustomerID = uCustomerID;
        this.uComment = uComment;
        this.uDate = uDate;
        this.uRate = uRate;
    }

    public String getuLaundryID() {
        return uLaundryID;
    }

    public void setuLaundryID(String uLaundryID) {
        this.uLaundryID = uLaundryID;
    }

    public String getuOrderID() {
        return uOrderID;
    }

    public void setuOrderID(String uOrderID) {
        this.uOrderID = uOrderID;
    }

    public String getuCustomerID() {
        return uCustomerID;
    }

    public void setuCustomerID(String uCustomerID) {
        this.uCustomerID = uCustomerID;
    }

    public String getuComment() {
        return uComment;
    }

    public void setuComment(String uComment) {
        this.uComment = uComment;
    }

    public String getuDate() {
        return uDate;
    }

    public void setuDate(String uDate) {
        this.uDate = uDate;
    }

    public int getuRate() {
        return uRate;
    }

    public void setuRate(int uRate) {
        this.uRate = uRate;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.uLaundryID);
        dest.writeString(this.uOrderID);
        dest.writeString(this.uCustomerID);
        dest.writeString(this.uComment);
        dest.writeString(this.uDate);
        dest.writeInt(this.uRate);
    }

    protected ReviewLaundry(Parcel in) {
        this.uLaundryID = in.readString();
        this.uOrderID = in.readString();
        this.uCustomerID = in.readString();
        this.uComment = in.readString();
        this.uDate = in.readString();
        this.uRate = in.readInt();
    }

    public static final Parcelable.Creator<ReviewLaundry> CREATOR = new Parcelable.Creator<ReviewLaundry>() {
        @Override
        public ReviewLaundry createFromParcel(Parcel source) {
            return new ReviewLaundry(source);
        }

        @Override
        public ReviewLaundry[] newArray(int size) {
            return new ReviewLaundry[size];
        }
    };
}
