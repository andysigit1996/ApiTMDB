package com.alimahrus.movietmdb.network

import com.alimahrus.movietmdb.BuildConfig.API_KEY
import com.alimahrus.movietmdb.BuildConfig.BASE_URL

object TMDBApi {
    fun getMovie(): String {
        return BASE_URL + API_KEY
    }
}