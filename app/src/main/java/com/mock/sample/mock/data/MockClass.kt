package com.mock.sample.mock.data

import retrofit2.Response

data class MockClass(
    val count :Int,
    val entries : List<MockListResponse>
)

fun toResponseData(mockClass: MockClass): Response<MockResponse> {
    return Response.success(MockResponse(mockClass.count,mockClass.entries))
}
