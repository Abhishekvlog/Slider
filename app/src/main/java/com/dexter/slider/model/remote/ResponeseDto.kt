package com.dexter.slider.model.remote


import com.google.gson.annotations.SerializedName

data class ResponeseDto(
    @SerializedName("data")
    val `data`: List<Data>
)