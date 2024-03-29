package com.alimahrus.movietmdb.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.alimahrus.movietmdb.BuildConfig.IMAGE_URL
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {

    private var titleMovie: String = ""
    private  var posterMovie: String = ""
    private  var overviewMovie: String = ""

private lateinit var poster: ImageView
    private lateinit var title: TextView
    private lateinit var overview: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        linearLayout {
            lparams(width = matchParent, height = wrapContent)
            orientation = LinearLayout.VERTICAL
            padding = dip(16)

            poster = imageView{

            }.lparams{
                width = dip(250)
                gravity = Gravity.CENTER
                height = dip(250)
            }

            title = textView()
            overview = textView()

        }
        val i = intent
        titleMovie = i.getStringExtra("TITLE")
        overviewMovie = i.getStringExtra("OVERVIEW")
        posterMovie = i.getStringExtra("POSTER")

        title.text = titleMovie
        overview.text = overviewMovie
        Picasso.get().load(IMAGE_URL + posterMovie).into(poster)
    }
}
