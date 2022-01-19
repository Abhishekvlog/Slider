package com.dexter.slider.model.remote

import java.io.Serializable;

class DataModel : Serializable {
    private lateinit var id: String
    private lateinit var title: String

    constructor(id: String, title: String) {
        this.id = id
        this.title = title
    }

    fun getId(): String {
        return id
    }

    fun getTitle(): String {
        return title
    }

    override fun toString(): String {
        return "DataModel[" +
                ",id : ${this.id}," +
                "text : ${this.title} ]"
    }


}