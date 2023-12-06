package com.example.flixster_plus_

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flixster_plus_.ApiClient.movieApi
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {
    private val movieRepository = MovieRepository(movieApi)

    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> get() = _movies

    fun getNowPlayingMovies(apiKey: String) {
        viewModelScope.launch {
            val response = movieRepository.getNowPlayingMovies(apiKey)
            if (response.isSuccessful) {
                _movies.value = response.body()?.results
            } else {
                
            }
        }
    }
}
