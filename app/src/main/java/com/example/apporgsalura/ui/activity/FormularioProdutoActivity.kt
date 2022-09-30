package com.example.apporgsalura.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.apporgsalura.R
import com.example.apporgsalura.dao.ProdutoDao
import com.example.apporgsalura.model.Produto
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario_produto)

        val botaoSalvar = findViewById<Button>(R.id.button)
        botaoSalvar.setOnClickListener {
            val campoNome = findViewById<EditText>(R.id.etNome)
            val nome = campoNome.text.toString()
            val campoDescricao = findViewById<EditText>(R.id.etDescricao)
            val descricao = campoDescricao.text.toString()
            val campoValor = findViewById<EditText>(R.id.etValor)
            val valorEmTexto = campoValor.text.toString()
            val valor = if(valorEmTexto.isBlank()){
                BigDecimal.ZERO
            } else {
                BigDecimal(valorEmTexto)
            }

            val produtoNovo = Produto (
                nome = nome,
                descricao = descricao,
                valor = valor
                    )

            Log.i("FormularioProduto", "onCreate: $produtoNovo")
            val dao = ProdutoDao()
            dao.adiciona(produtoNovo)
            Log.i("FormularioProduto", "onCreate: ${dao.buscaTodos()}")
            finish()
        }
    }
}