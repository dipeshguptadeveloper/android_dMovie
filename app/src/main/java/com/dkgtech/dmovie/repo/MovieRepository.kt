package com.dkgtech.dmovie.repo

import com.dkgtech.dmovie.api.ApiHelper
import com.dkgtech.dmovie.model.WhatStreamIndiaModel
import retrofit2.Call

class MovieRepository(val apiHelper: ApiHelper) {

    fun getWhatsStreamIndia(
        auth: String,
        auth1: String,
        country: String
    ): Call<WhatStreamIndiaModel> {
        return apiHelper.getWhatsStreamIndia(auth, auth1, country)
    }
}