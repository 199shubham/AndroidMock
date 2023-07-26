package com.mock.sample.mock.domain



import com.mock.sample.mock.data.*
import retrofit2.Response


interface MockUseCase {
    suspend fun getMockData(): Response<MockResponse>
}