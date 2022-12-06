package com.example.youtube.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.viewbinding.BuildConfig
import com.example.youtube.remote.RetrofitClient
import com.example.youtube.model.Playlists
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlaylistViewModel: ViewModel() {

    private val apiService = RetrofitClient.create()

    fun playlist(): LiveData<Playlists> {
        return createCall()
    }

    private fun createCall(): LiveData<Playlists >{
        val data = MutableLiveData<Playlists>()


        apiService.getPlaylist(
            "snippet,contentDetails", "UCIEcbsyy2qO7uYFnlgeGomQ", BuildConfig.API_KEY
    ).enqueue(object: Callback<Playlists>{

            override fun onFailure(call: Call<Playlists>, t: Throwable) {
                print(t.stackTrace)
            }

            override fun onResponse(call: Call<Playlists>, response: Response<Playlists>) {
                if (response.isSuccessful) {
                    data.value = response.body()
                }

            }
        }
        )
        return data
    }
}