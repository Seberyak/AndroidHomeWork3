package com.cst.homework3

import java.io.Serializable


class HelperSchemas:Serializable {

    data class IMovie(
        val cast: List<ICast> ,
        val date: String,
        val id: Int,
        val imageUrl: String,
        val language: String,
        val seasons: Int,
        val title: String
    ):Serializable


    data class ICast(
        val fullName: String,
        val id: Int,
        val imageUrl: String,
        val role: String
    ):Serializable

    data class IRGETMovies(
        val movies: List<IMovie>
    ):Serializable
}