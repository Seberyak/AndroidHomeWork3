package com.cst.homework3


class HelperSchemas {
    data class IMovie(
        val cast: List<ICast>,
        val date: String,
        val id: Int,
        val imageUrl: String,
        val language: String,
        val seasons: Int,
        val title: String
    )

    data class ICast(
        val fullName: String,
        val id: Int,
        val imageUrl: String,
        val role: String
    )

    data class IRGETMovies(
        val movies: List<IMovie>
    )
}