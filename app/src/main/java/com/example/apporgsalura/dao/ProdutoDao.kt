package com.example.apporgsalura.dao

import com.example.apporgsalura.model.Produto

class ProdutoDao {

    fun adiciona(produto: Produto){
        produtos.add(produto)

    }

    fun buscaTodos() : List<Produto>{
        return produtos.toList()
    }

    companion object {
        private val produtos = mutableListOf<Produto>()
    }
}