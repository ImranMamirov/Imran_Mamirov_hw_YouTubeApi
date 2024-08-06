package com.example.imran_mamirov_hw_youtubeapi.data.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.imran_mamirov_hw_youtubeapi.Utils.Resource
import kotlinx.coroutines.Dispatchers
import retrofit2.HttpException
import java.io.IOException

abstract class BaseRepository {

    protected fun <T> doRequest(request: suspend () -> T): LiveData<Resource<T>> = liveData(
        Dispatchers.IO
    ) {
        emit(Resource.Loading())
        try {
            val response = request()
            if (response != null) {
                emit(Resource.Success(response))
            }
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: "Unknown error"))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Unknown error"))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Unknown error"))
        }
    }
}