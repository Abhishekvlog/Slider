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
    var list = mutableListOf<DataModel>()


    fun getData() : MutableList<DataModel> {
        val stringBuffer = StringBuffer()

        CoroutineScope(Dispatchers.IO).launch {
            val data : String = Network.apidata.getSlide()

            //set data in the StringBuffer

            for (i in 0..data.length){
                val response = data
                stringBuffer.append(response)
            }

            stringBuffer.deleteCharAt(0)

            ResponseModel(stringBuffer)
            Log.d("abhi",stringBuffer.toString())



//            while (data != null ) {
//                val responsedata = data
//                stringBuffer.append(responsedata)
//
//                // delete the first char '/'
//
//                stringBuffer.deleteCharAt(0)
//                Log.d("abhi", stringBuffer.toString())
//
//            }


        }

        return list


    }

    private fun ResponseModel(stringBuffer: StringBuffer) {
        try {

            // Build a JSON object from the received string

            val jsonObject = JSONObject(stringBuffer.toString())

            val title = jsonObject.getString("text")
            val id = jsonObject.getString("id")

            val ModelData = DataModel( id, title)
            list.add(ModelData)

        }
        catch (execption : Exception){
            execption.stackTrace
        }
    }
}