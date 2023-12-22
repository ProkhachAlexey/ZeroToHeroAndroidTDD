package ru.easycode.zerotoheroandroidtdd

import java.net.UnknownHostException

interface Repository {

    suspend fun load(): LoadResult

    data class Base(
        private val service: SimpleService,
        private val url: String
    ) : Repository {

        override suspend fun load(): LoadResult {
            return try {
                LoadResult.Success(service.fetch(url))
            } catch (e: Exception) {
                LoadResult.Error(e is UnknownHostException)
            }
        }
    }
}