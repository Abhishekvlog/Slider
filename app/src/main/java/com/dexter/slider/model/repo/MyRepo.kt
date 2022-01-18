package com.dexter.slider.model.repo

import android.util.Log
import com.dexter.slider.model.remote.Network
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.InputStreamReader

class MyRepo {


    fun getData(): StringBuffer {
        val stringBuffer = StringBuffer()

        CoroutineScope(Dispatchers.IO).launch {
            val data : String = Network.apidata.getSlide()

            //set data in the StringBuffer
            while (data != null ) {
                val responsedata = data
                stringBuffer.append(responsedata)
                Log.d("abhi", stringBuffer.toString())
            }




            // delete the first char '/' 
            stringBuffer.deleteCharAt(0)
            Log.d("before", stringBuffer.toString())


        }
        Log.d("after", stringBuffer.toString())

        return stringBuffer

    }
}