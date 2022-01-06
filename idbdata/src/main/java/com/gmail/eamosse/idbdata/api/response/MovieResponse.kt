package com.gmail.eamosse.idbdata.api.response

import com.gmail.eamosse.idbdata.data.Movie
import com.google.gson.annotations.SerializedName

internal data class MovieResponse(
    @SerializedName("movies")
    val movies: List<Movie>
){
    data class MovieInformation(
        @SerializedName("Titre")
        val titre: String
    )
}

//internal fun MovieResponse.MovieInformation.toMovie() = Movie(
//    ///A changer pour que les variable match!!
//    page = page,
//    resultList = listeFilm,
//
//)