package com.dexter.slider.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.dexter.slider.R
import com.dexter.slider.model.remote.DataModel
import com.dexter.slider.model.repo.MyRepo
import com.dexter.slider.view.adapter.PosterAdapter
import com.dexter.slider.viewModel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var viewmodel : MainViewModel
    lateinit var posterAdapter: PosterAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewmodel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        CoroutineScope(Dispatchers.Main).launch {
            val list = viewmodel.getData()
            setAdapter(list)
        }



    }

    @SuppressLint("WrongConstant")
    fun setAdapter(posterList : List<DataModel>) {
        posterAdapter = PosterAdapter(posterList as MutableList<DataModel>)
        val linearLayoutManager = LinearLayoutManager(this,LinearLayout.HORIZONTAL,false)
        recycler.apply {
            layoutManager = linearLayoutManager
            this.adapter = posterAdapter
        }
    }

}
