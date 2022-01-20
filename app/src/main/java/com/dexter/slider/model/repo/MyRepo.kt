package com.dexter.slider.model.repo

import android.util.Log
import com.dexter.slider.model.remote.Network
import com.google.gson.JsonObject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.InputStreamReader
import org.json.JSONObject
import android.R.id
import androidx.lifecycle.LiveData
import com.dexter.slider.model.remote.Data
import com.dexter.slider.model.remote.DataModel
import java.lang.Exception


class MyRepo {

    val list = mutableListOf<DataModel>()

    fun getData(): MutableList<DataModel> {
        val stringBuffer = StringBuffer()

        CoroutineScope(Dispatchers.IO).launch {
            val data: String = Network.apidata.getSlide()

            //set data in the StringBuffer

            for (i in 0..data.length) {
                val response = data
                stringBuffer.append(response)
            }

            ResponseModel(stringBuffer)
            Log.d("abhi", stringBuffer.toString())

        }

        Log.d("size", list.size.toString())

        return list

    }

    private fun ResponseModel(stringBuffer: StringBuffer) {

        stringBuffer.deleteCharAt(0)

        try {
            // Build a JSON object from the received string

            val jsonObject = JSONObject(stringBuffer.toString())
            val array = jsonObject.getJSONArray("data")
            for (i in 0 until array.length()) {

                val jsonObject1 = JSONObject(array[i].toString())
                val id = jsonObject1.get("id")
                val text = jsonObject1.get("text")

                Log.d("check1", id.toString())
                Log.d("check2", text.toString())

                var model = (DataModel(id.toString(), text.toString()))

                list.add(model)

                Log.d("list", list.size.toString())

            }


        } catch (execption: Exception) {
            execption.printStackTrace()
        }

    }
}