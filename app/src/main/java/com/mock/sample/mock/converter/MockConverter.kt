package com.mock.sample.mock.converter

import androidx.room.TypeConverter
import com.mock.sample.mock.data.MockListResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MockConverter {

    private val gson by lazy { Gson() }


    @TypeConverter
    fun toQAListData(str :String) : List<MockListResponse>?{
        val type = object :TypeToken<List<MockListResponse>>(){}.type
        return gson.fromJson(str,type)
    }

    @TypeConverter
    fun fromQAListData(choiceList: List<MockListResponse>?):String?{
        val type = object :TypeToken<List<MockListResponse>>(){}.type
        return gson.toJson(choiceList,type)
    }
}