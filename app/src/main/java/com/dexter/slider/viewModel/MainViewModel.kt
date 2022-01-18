package com.dexter.slider.viewModel

import androidx.lifecycle.ViewModel
import com.dexter.slider.model.repo.MyRepo

class MainViewModel() : ViewModel() {


    val repo = MyRepo()

    fun getData(): StringBuffer {
        return repo.getData()
    }

}