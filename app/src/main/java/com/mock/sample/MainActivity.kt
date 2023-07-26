package com.mock.sample


import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import com.mock.sample.base.*
import com.mock.sample.databinding.ActivityMainBinding

import com.globalmed.corelib.repository.SharedPreferenceRepositoryImplementation

import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class MainActivity :  AppCompatActivity(){
    private val header = MutableLiveData<Header>()
    private lateinit var activityMainBinding: ActivityMainBinding
    val viewModel: BaseViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        activityMainBinding.appBar.outlineProvider = null
        activityMainBinding.frmProgress.setOnClickListener {  }
        viewModel.repository = SharedPreferenceRepositoryImplementation(application)
        setContentView(activityMainBinding.root)
        

     }

    fun showProgress(_shouldShowProgress: Boolean, _progressText: String?) {
        header.value?.updatedProgressOnly(_shouldShowProgress, _progressText)?.let {
            header.postValue(it)
        }
    }
}
