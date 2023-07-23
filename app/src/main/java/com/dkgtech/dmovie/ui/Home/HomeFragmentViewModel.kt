package com.dkgtech.dmovie.ui.Home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dkgtech.dmovie.model.DataModel
import com.dkgtech.dmovie.model.TitleModel
import com.dkgtech.dmovie.model.WhatStreamIndiaModel
import com.dkgtech.dmovie.repo.MovieRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragmentViewModel(val movieRepository: MovieRepository) : ViewModel() {

    val listData = MutableLiveData<List<DataModel>>()
    val errMsg = MutableLiveData<String>()

    fun getWhatsStreamIndia(auth: String, auth1: String, country: String) {

        movieRepository.getWhatsStreamIndia(auth, auth1, country)
            .enqueue(object : Callback<WhatStreamIndiaModel> {
                override fun onResponse(
                    call: Call<WhatStreamIndiaModel>?,
                    response: Response<WhatStreamIndiaModel>?
                ) {
                    if (response?.code() == 200) {
                        Log.d("Data", "${response.body()}")
//                        listData.postValue(response.body().data)
                    } else {
                        Log.d("Error", "${response?.errorBody()}, ${response?.code()}")
                        errMsg.postValue(
                            "Error : ${
                                response?.errorBody()
                            },${
                                response?.code()
                            }"
                        )
                    }
                }

                override fun onFailure(call: Call<WhatStreamIndiaModel>?, t: Throwable?) {
                    Log.d("Network Error", "${t?.message}")
                    t?.printStackTrace()
                    errMsg.postValue("Network Error : ${t?.message}")
                }

            })
    }

}