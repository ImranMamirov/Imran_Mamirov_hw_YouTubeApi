package com.example.imran_mamirov_hw_youtubeapi.Utils

sealed class Resource<T> {
    class Loading<T>: Resource<T>()
    class Success<T>(val data: T): Resource<T>()
    class Error<T>(val message: String): Resource<T>()
}