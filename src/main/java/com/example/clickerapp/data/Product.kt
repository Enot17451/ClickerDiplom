package com.example.clickerapp.data

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource

class Product{
    var id = 0
    var name = ""
    lateinit var image:ImageBitmap

    @Composable
    fun loadImage(drawable:Int){
        image = ImageBitmap.imageResource(id = drawable)
    }

}