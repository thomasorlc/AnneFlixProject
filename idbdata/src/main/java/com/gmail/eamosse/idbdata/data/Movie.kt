package com.gmail.eamosse.idbdata.data

data class Movie(
    val page: Int,
    val resultList: List<Any>,
    val totalResult: Int,
    val totalPage: Int,
)