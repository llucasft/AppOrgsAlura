package com.example.apporgsalura.dao

import com.example.apporgsalura.model.Produto
import java.math.BigDecimal

class ProdutoDao {

    fun adiciona(produto: Produto){
        produtos.add(produto)

    }

    fun buscaTodos() : List<Produto>{
        return produtos.toList()
    }

    companion object {
        private val produtos = mutableListOf<Produto>(
            Produto(
            nome = "Salada de frutas",
            descricao = "Laranja, banana e uva",
            valor = BigDecimal("21.12")
        )
        )
    }
}