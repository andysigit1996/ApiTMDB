package com.alimahrus.movietmdb.main

import com.alimahrus.movietmdb.model.MovieResponse
import com.alimahrus.movietmdb.network.ApiRepository
import com.alimahrus.movietmdb.network.TMDBApi
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class  MainPresenter(private val view: Mainview, private  val apiRepository: ApiRepository, private  val gson: Gson){
    fun getMovieList(){
        doAsync {
            val data  = gson.fromJson(apiRepository.doRequest(TMDBApi.getMovie()),
                MovieResponse::class.java)
            uiThread {
                view.showMovieList(data.results)
            }
        }
    }

}