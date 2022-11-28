package com.example.api_intergration_example2.models


import com.google.gson.annotations.SerializedName

data class Post1(
    @SerializedName("id")
    val id: Int,
    @SerializedName("language")
    val language: String,
    @SerializedName("path")
    var img_path: String,
    @SerializedName("tags")
    val tags: String,
    @SerializedName("type")
    val type: String
)