package com.example.apporgsalura.model

import java.math.BigDecimal

data class Produto(
    val nome: String,
    val descricao: String,
    val valor: BigDecimal,
    val imagem: String? = null
)
