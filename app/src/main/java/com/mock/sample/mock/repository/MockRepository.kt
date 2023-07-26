package com.mock.sample.mock.repository

import com.mock.sample.common.ApiEndPoints
import com.mock.sample.mock.data.MockResponse
import retrofit2.Response
import retrofit2.http.*

interface MockRepository {
    @GET(ApiEndPoints.MOCK_API_END_POINTS)
    suspend fun getMockData(): Response<MockResponse>

}