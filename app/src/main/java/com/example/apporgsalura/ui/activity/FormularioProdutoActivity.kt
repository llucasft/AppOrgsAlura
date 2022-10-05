package com.example.apporgsalura.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import coil.load
import com.example.apporgsalura.R
import com.example.apporgsalura.dao.ProdutoDao
import com.example.apporgsalura.databinding.ActivityFormularioProdutoBinding
import com.example.apporgsalura.databinding.FormularioImagemBinding
import com.example.apporgsalura.model.Produto
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity() {

    private val binding by lazy { ActivityFormularioProdutoBinding.inflate(layoutInflater) }
    private var url: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        configuraBotaoSalvar()

        binding.imagemFormulario.setOnClickListener{
            val bindingFormularioImagem = FormularioImagemBinding.inflate(layoutInflater)
            bindingFormularioImagem.formularioDialogBotaoCarregar.setOnClickListener {
                val url = bindingFormularioImagem.formularioDialogImagemEtURL.text.toString()
                bindingFormularioImagem.formularioDialogImagem.load(url)
            }

            AlertDialog.Builder(this)
                .setMessage("mensagem teste")
                .setTitle("titulo teste")
                .setView(bindingFormularioImagem.root)
                .setPositiveButton("Confirmar"){ _, _ ->
                    url = bindingFormularioImagem.formularioDialogImagemEtURL.text.toString()
                    bindingFormularioImagem.formularioDialogImagem.load(url)
                }
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
            valor = valor,
            imagem = url
        )
    }
}