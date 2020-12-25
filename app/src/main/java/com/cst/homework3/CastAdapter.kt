package com.cst.homework3

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class CastAdapter(private val args: HelperSchemas.IMovie) : RecyclerView.Adapter<CastViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.cast_row, parent, false)
        return CastViewHolder(cellForRow, args)
    }

    override fun onBindViewHolder(holder: CastViewHolder, position: Int) {
        val castRealName: TextView = holder.view.findViewById(R.id.CastRealName)
        val castMovieName: TextView = holder.view.findViewById(R.id.CastMovieName)
        val castImageView: ImageView = holder.view.findViewById(R.id.castImageView)

        castMovieName.text = args.cast[position].role
        castRealName.text = args.cast[position].fullName
        Picasso.get().load(args.cast[position].imageUrl).fit().centerCrop().into(castImageView)

    }

    override fun getItemCount(): Int {
        return args.cast.size
    }
}


class CastViewHolder(val view: View, private val args: HelperSchemas.IMovie) :
    RecyclerView.ViewHolder(view) {

}