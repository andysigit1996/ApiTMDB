package com.alimahrus.movietmdb.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alimahrus.movietmdb.R
import com.alimahrus.movietmdb.detail.DetailActivity
import com.alimahrus.movietmdb.model.Movie
import com.alimahrus.movietmdb.network.ApiRepository
import com.google.gson.Gson
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity(), Mainview {


    private lateinit var presenter: MainPresenter
    private lateinit var adapter: MainAdapter
    private var movies: MutableList<Movie> = mutableListOf()
    private lateinit var listMovie : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

     linearLayout {
         lparams(width = matchParent, height = wrapContent)
         orientation = LinearLayout.VERTICAL
         padding = dip(16)

         listMovie = recyclerView {
             lparams(width = matchParent, height = wrapContent)
             layoutManager = GridLayoutManager(ctx, 2)
         }
     }
        adapter = MainAdapter(movies){
        startActivity<DetailActivity>(
            "TITLE" to it.title,
            "POSTER" to it.poster,
            "OVERVIEW" to it.overview
        )
        }
        listMovie.adapter = adapter
        presenter = MainPresenter(this, ApiRepository(), Gson())
        presenter.getMovieList()
     }

    override fun showMovieList(data: List<Movie>) {
       movies.clear()
        movies.addAll(data)
        adapter.notifyDataSetChanged()
    }

    }



