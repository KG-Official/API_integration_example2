package com.example.api_intergration_example2.models


import com.google.gson.annotations.SerializedName

data class ApiData(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("message")
    val message: String,
    @SerializedName("success")
    val success: Boolean
)