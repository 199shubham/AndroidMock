package com.example.mock

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.mock.sample.mock.MockFragmentViewModel
import com.mock.sample.mock.data.MockClass
import com.mock.sample.mock.data.MockListResponse
import com.mock.sample.mock.data.toResponseData
import com.mock.sample.mock.domain.MockUseCase
import com.nhaarman.mockitokotlin2.mock
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class ExampleInstrumentedTest {

    private val application: Application = mock()

    @get:Rule
    val testInstantTaskExecutoreRule : TestRule = InstantTaskExecutorRule()


    @get:Rule
    val testCoroutineRule   = TestCoroutineRule()

    @Mock
    private lateinit var apiHelper :MockUseCase

    @Mock

    private lateinit var myRepository : MockUseCase

    private lateinit var myViewModel : MockFragmentViewModel


    @ExperimentalCoroutinesApi
    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)

        myViewModel = MockFragmentViewModel(application,myRepository)
    }

    @Test
    fun testGetData(){


        testCoroutineRule.runBlockingTest {
            val mockClass  = MockClass(1, listOf(MockListResponse("","","","","","")))
            val responseData = toResponseData(mockClass)
            Mockito.`when`(myRepository.getMockData()).thenReturn(responseData)
            myViewModel.getSampleData()
            val result = myViewModel.getTestData().value
            assertEquals(responseData,result)
        }
    }
}