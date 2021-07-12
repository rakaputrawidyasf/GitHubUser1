package com.dicoding.fundamental.githubuser1

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var username : String = "username",
    var name : String = "Name",
    var avatar : Int = 0,
    var location : String = "N/A",
    var repository : String = "N/A",
    var company : String = "N/A",
    var followers : String = "N/A",
    var following : String = "N/A"
) : Parcelable
