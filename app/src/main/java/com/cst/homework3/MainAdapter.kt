package com.cst.homework3

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MainAdapter(private val args: HelperSchemas.IRGETMovies) :
    RecyclerView.Adapter<CustomViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.movie_row, parent, false)
        return CustomViewHolder(cellForRow, args)

    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val movieTitleTextView: TextView =
            holder.view.findViewById(R.id.textMovieTitle)
        val movieImgView: ImageView = holder.view.findViewById(R.id.MovieImg)
        movieTitleTextView.text = args.movies[position].title
        Picasso.get().load(args.movies[position].imageUrl).fit().centerCrop()
            .into(movieImgView)
    }
    override fun getItemCount(): Int {
        return args.movies.size
    }
}

class CustomViewHolder(val view: View, private val args: HelperSchemas.IRGETMovies) : RecyclerView.ViewHolder(view) {

    init {
        view.setOnClickListener {
            val position: Int = adapterPosition
            val intent = Intent(view.context, DetailedMovieActivity()::class.java)
            intent.putExtra("args",args.movies[position])
            view.context.startActivity(intent)
        }
    }

}



