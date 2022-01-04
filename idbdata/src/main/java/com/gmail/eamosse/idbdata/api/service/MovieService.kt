package com.gmail.eamosse.idbdata.api.service

import com.gmail.eamosse.idbdata.api.response.CategoryResponse
import com.gmail.eamosse.idbdata.api.response.TokenResponse
import retrofit2.Response
import retrofit2.http.GET

internal interface MovieService {
    @GET("authentication/token/new")
    suspend fun getToken(): Response<TokenResponse>

    @GET("genre/movie/list")
    suspend fun getCategories(): Response<CategoryResponse>

    //@GET("discover/movie?")
    // ? => filtre avec @Query (cf: theMovieDB doc)
    //suspend fun getMoviesByCategory(@Query("with_genres") genreId: String): Response<T>
}