package com.dexter.slider.model.remote

import retrofit2.http.GET

interface APIClient {

    //  https://git.io/fjaqJ
    @GET("anishbajpai014/d482191cb4fff429333c5ec64b38c197/raw/b11f56c3177a9ddc6649288c80a004e7df41e3b9/HiringTask.json")
    suspend fun getSlide() : String
}