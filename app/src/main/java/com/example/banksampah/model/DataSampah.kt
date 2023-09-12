package com.example.banksampah.model

import android.os.Parcel
import android.os.Parcelable

data class DataSampah(
    var kategori: String?,
    var subkategori: String?,
    var jumlah: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),

    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(kategori)
        parcel.writeString(subkategori)
        parcel.writeString(jumlah)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DataSampah> {
        override fun createFromParcel(parcel: Parcel): DataSampah {
            return DataSampah(parcel)
        }

        override fun newArray(size: Int): Array<DataSampah?> {
            return arrayOfNulls(size)
        }
    }
}