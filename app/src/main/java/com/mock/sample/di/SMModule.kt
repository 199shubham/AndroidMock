package com.mock.sample.di


import com.mock.sample.mock.domain.MockUseCase
import com.mock.sample.mock.domain.MockUseCaseImpl
import com.mock.sample.mock.repository.MockRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit


@Module
@InstallIn(SingletonComponent::class)
object SMModule {
    @Provides
    fun provideSampleRepository(retrofit: Retrofit) = retrofit.create(MockRepository::class.java)

    @Provides
    fun provideMockUseCase(repository: MockRepository): MockUseCase
            = MockUseCaseImpl(repository)

}