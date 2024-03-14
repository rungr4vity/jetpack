package com.example.jetpack.models

import com.google.gson.annotations.SerializedName

data class Items(

    @SerializedName("userId") var userid: String,
    var id: Int,
    @SerializedName("title") var titulo: String,
    var body:String

)