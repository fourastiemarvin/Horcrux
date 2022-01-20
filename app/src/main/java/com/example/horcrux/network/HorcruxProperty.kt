package com.example.horcrux.network

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HorcruxProperty (
    val name: String,
    val image: String ) : Parcelable {
    }

