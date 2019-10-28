package com.alimahrus.movietmdb.main

import com.alimahrus.movietmdb.model.Movie

interface Mainview {
    fun showMovieList(data: List<Movie>)
}