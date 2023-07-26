package com.mock.sample.mock

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mock.sample.base.AppNavigator
import com.mock.sample.base.BaseViewModel
import com.mock.sample.mock.data.MockListResponse
import com.mock.sample.mock.data.MockResponse
import com.mock.sample.mock.domain.MockUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class MockFragmentViewModel @Inject constructor(val app:Application, val useCase : MockUseCase): BaseViewModel(app) {
    val mockDetails = ObservableField<List<MockListResponse>>()
    private val uiState  = MutableLiveData<Response<MockResponse>>()
    val isVisibleState = ObservableField<Boolean>()
    val isVisibleStat = ObservableField<Boolean>()

    fun getSampleData() {

            viewModelScope.launch(Dispatchers.IO) {
                isVisibleStat.set(true)
                isVisibleState.set(false)
                kotlin.runCatching {
                    useCase.getMockData()
                }.onSuccess {
                    mockDetails.set(it.body()?.entries)
                    uiState.postValue(it)
                    isVisibleStat.set(false)
                    isVisibleState.set(true)
                }.onFailure {
                   System.out.println(it)
                    isVisibleStat.set(true)
                    isVisibleState.set(false)
                    withContext(Dispatchers.Main) {

                    }
                }


            }
    }

    fun getTestData():MutableLiveData<Response<MockResponse>>{
        return uiState
    }
}



