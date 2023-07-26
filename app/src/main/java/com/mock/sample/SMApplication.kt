package com.mock.sample

import com.globalmed.corelib.base.BaseApplication
import com.globalmed.corelib.base.NetworkErrorListener
import com.google.firebase.FirebaseApp
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SMApplication: BaseApplication(), NetworkErrorListener {
    override fun onCreate() {
        super.onCreate()

        try {
            FirebaseApp.initializeApp(this)
        }
        catch (e:java.lang.Exception){
            System.out.println("shubham")
        }
    }

    override fun onApiNotFound() {

    }

    override fun onDomainCouldNotReach() {
    }

    override fun logout() {
    }
}