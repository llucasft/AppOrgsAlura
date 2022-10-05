package com.example.apporgsalura.extensions

import android.widget.ImageView
import coil.load
import com.example.apporgsalura.R

fun ImageView.tentaCarregarImagem(url: String? = null){
    load(url){
        fallback(R.drawable.erro)
        error(R.drawable.erro)
        placeholder(R.drawable.placeholder)
    }
}