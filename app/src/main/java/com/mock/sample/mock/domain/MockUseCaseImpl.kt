package com.mock.sample.mock.domain



import com.mock.sample.mock.data.*
import com.mock.sample.mock.repository.MockRepository
import retrofit2.Response


class MockUseCaseImpl(private val repository: MockRepository,
): MockUseCase {
    override suspend fun getMockData(): Response<MockResponse> {
        return repository.getMockData()
    }

}