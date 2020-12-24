package com.cst.homework3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso


class InfoFragment(args: HelperSchemas.IMovie) : Fragment() {
    private val args = args
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_info, container, false);
        val imageView = root.findViewById<ImageView>(R.id.imageFragmentInfo)
        val originalTitleForSet = root.findViewById<TextView>(R.id.OriginalTitleForSet)
        val releaseDateForSet = root.findViewById<TextView>(R.id.ReleaseDateForSet)
        val languageForSet = root.findViewById<TextView>(R.id.LanguageForSet)
        val seasonsForSet = root.findViewById<TextView>(R.id.SeasonsForSet)
        Picasso.get().load(args.imageUrl).fit().centerCrop().into(imageView)
        originalTitleForSet.text = args.title
        releaseDateForSet.text = args.date
        languageForSet.text = args.language
        seasonsForSet.text = args.seasons.toString()
        return root

    }

}