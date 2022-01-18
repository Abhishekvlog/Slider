package com.dexter.slider.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.dexter.slider.R
import com.dexter.slider.model.repo.MyRepo
import com.dexter.slider.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var viewmodel : MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewmodel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewmodel.getData()
    }
}