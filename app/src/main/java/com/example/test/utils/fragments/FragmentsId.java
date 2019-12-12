package com.example.test.utils.fragments;

import android.os.Parcel;
import android.os.Parcelable;

public enum FragmentsId implements Parcelable {

    LIST_MARKETS,
    DETAILS_MARKET,
    LIST_STOCKS,
    DETAILS_STOCK,
    LIST_PRODUCTS;

    public static final Creator<FragmentsId> CREATOR = new Creator<FragmentsId>() {
        @Override
        public FragmentsId createFromParcel(final Parcel source) {
            return FragmentsId.values()[source.readInt()];
        }

        @Override
        public FragmentsId[] newArray(final int size) {
            return new FragmentsId[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeInt(ordinal());
    }
}
