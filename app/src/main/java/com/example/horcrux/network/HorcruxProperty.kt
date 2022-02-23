package com.example.horcrux.network

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.parcelize.Parcelize

@Parcelize
data class HorcruxProperty (
    val name: String,
    val image: String ) : Parcelable {
    }

