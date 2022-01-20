package com.dexter.slider.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dexter.slider.model.remote.Data
import com.dexter.slider.model.remote.DataModel
import com.dexter.slider.model.repo.MyRepo

class MainViewModel() : ViewModel() {

    val repo = MyRepo()

    suspend fun getData(): MutableList<DataModel> {
        return repo.getData()
    }

}