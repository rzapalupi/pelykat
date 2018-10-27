package com.ariskadm57.pelykat.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class FotoLaundry implements Parcelable {
    private String id;
    private byte[] foto;

    public FotoLaundry() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeByteArray(this.foto);
    }

    protected FotoLaundry(Parcel in) {
        this.id = in.readString();
        this.foto = in.createByteArray();
    }

    public static final Parcelable.Creator<FotoLaundry> CREATOR = new Parcelable.Creator<FotoLaundry>() {
        @Override
        public FotoLaundry createFromParcel(Parcel source) {
            return new FotoLaundry(source);
        }

        @Override
        public FotoLaundry[] newArray(int size) {
            return new FotoLaundry[size];
        }
    };
}

