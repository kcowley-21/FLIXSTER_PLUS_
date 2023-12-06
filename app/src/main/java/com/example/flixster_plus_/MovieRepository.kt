package com.example.flixster_plus_

import retrofit2.Response

class MovieRepository(private val movieApi: MovieApi) {
    suspend fun getNowPlayingMovies(apiKey: String): Response<MovieResponse> {
        return movieApi.getNowPlayingMovies(apiKey)

    }


}