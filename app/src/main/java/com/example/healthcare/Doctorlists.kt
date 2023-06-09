package com.example.healthcare

import android.os.Parcel
import android.os.Parcelable

data class Doctorlists(val name:String, val ptdoctor:String):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(ptdoctor)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Doctorlists> {
        override fun createFromParcel(parcel: Parcel): Doctorlists {
            return Doctorlists(parcel)
        }

        override fun newArray(size: Int): Array<Doctorlists?> {
            return arrayOfNulls(size)
        }
    }
}
