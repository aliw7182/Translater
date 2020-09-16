package com.example.kaspi_3.model

class Favorites(inputText:String,outText:String) {
    private var outText: String
    private var inputText: String

    init {
        this.inputText = inputText
        this.outText = outText
    }
    public fun getInputText():String = inputText
    public fun getOutText():String = outText


}