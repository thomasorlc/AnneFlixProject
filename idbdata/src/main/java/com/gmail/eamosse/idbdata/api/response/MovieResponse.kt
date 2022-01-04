package com.gmail.eamosse.idbdata.api.response

import com.gmail.eamosse.idbdata.data.Movie
import com.google.gson.annotations.SerializedName

internal data class MovieResponse(
    @SerializedName("movies")
    val movies: List<Movie>
){
    data class Movie(
        @SerializedName("id")
        val id: Int,
    )
}