package com.example.api_intergration_example2.models


import androidx.lifecycle.LiveData
import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("posts")
    val post1s: List<Post1>
)