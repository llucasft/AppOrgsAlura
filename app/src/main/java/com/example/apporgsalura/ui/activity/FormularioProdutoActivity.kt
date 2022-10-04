package com.example.apporgsalura.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.example.apporgsalura.R
import com.example.apporgsalura.dao.ProdutoDao
import com.example.apporgsalura.databinding.ActivityFormularioProdutoBinding
import com.example.apporgsalura.model.Produto
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity() {

    private val binding by lazy { ActivityFormularioProdutoBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        configuraBotaoSalvar()

        binding.imagemFormulario.setOnClickListener{
            AlertDialog.Builder(this)
                .setMessage("mensagem teste")
                .setTitle("titulo teste")
                .setView(R.layout.formulario_imagem)
                .setPositiveButton("Confirmar"){ _, _ ->}
                .setNegativeButton("Cancelar"){ _, _ ->}
                .show()
        }
    }

    private fun configuraBotaoSalvar() {
        val botaoSalvar = binding.button
        val dao = ProdutoDao()
        botaoSalvar.setOnClickListener {
            val produtoNovo = criaProduto()
            dao.adiciona(produtoNovo)
            finish()
        }
    }

    private fun criaProduto(): Produto {
        val campoNome = binding.etNome
        val nome = campoNome.text.toString()
        val campoDescricao = binding.etDescricao
        val descricao = campoDescricao.text.toString()
        val campoValor = binding.etValor
        val valorEmTexto = campoValor.text.toString()
        val valor = if (valorEmTexto.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(valorEmTexto)
        }

        return Produto(
            nome = nome,
            descricao = descricao,
            valor = valor
        )
    }
}