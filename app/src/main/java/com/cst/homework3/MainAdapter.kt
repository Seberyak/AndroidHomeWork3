package com.cst.homework3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(val movies:HelperSchemas.IRGETMovies) : RecyclerView.Adapter<CustomViewHolder>() {
    private val movieTitles =
        listOf<String>("Breaking Bad", "Batman", "Avengers", "Game of Thrones")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.movie_row, parent, false)
        return CustomViewHolder(cellForRow)

    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val movieTitleTextView: TextView =
            holder.view.findViewById<TextView>(R.id.textMovieTitle)
        val movieImgView : ImageView = holder.view.findViewById(R.id.MovieImg)
        movieTitleTextView.text = movies.movies[position].title

    }

    override fun getItemCount(): Int {
        return movieTitles.size
    }


}


class CustomViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
}