package com.example.marketDB.utils.fragments;

import android.os.Parcel;
import android.os.Parcelable;

public enum FragmentsAnimationId implements Parcelable {

    LEFT_TO_RIGHT,
    RIGHT_TO_LEFT,
    ALPHA;

    public static final Creator<FragmentsAnimationId> CREATOR = new Creator<FragmentsAnimationId>() {
        @Override
        public FragmentsAnimationId createFromParcel(final Parcel source) {
            return FragmentsAnimationId.values()[source.readInt()];
        }

        @Override
        public FragmentsAnimationId[] newArray(final int size) {
            return new FragmentsAnimationId[size];
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
