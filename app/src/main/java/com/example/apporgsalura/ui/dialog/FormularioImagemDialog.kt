package com.example.apporgsalura.ui.dialog

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.example.apporgsalura.databinding.FormularioImagemBinding
import com.example.apporgsalura.extensions.tentaCarregarImagem

class FormularioImagemDialog(private val context: Context) {

    fun mostraDialog(
        urlPadrao: String? = null,
        quandoImagemCarregada: (imagem: String) -> Unit
    ) {
        FormularioImagemBinding
            .inflate(LayoutInflater.from(context)).apply {
                urlPadrao?.let {
                    formularioDialogImagem.tentaCarregarImagem(it)
                    formularioDialogImagemEtURL.setText(it)
                }
                formularioDialogBotaoCarregar.setOnClickListener {
                    val url = formularioDialogImagemEtURL.text.toString()
                    formularioDialogImagem.tentaCarregarImagem(url)
                }

                AlertDialog.Builder(context)
                    .setMessage("mensagem teste")
                    .setTitle("titulo teste")
                    .setView(root)
                    .setPositiveButton("Confirmar") { _, _ ->
                        val url = formularioDialogImagemEtURL.text.toString()
                        quandoImagemCarregada(url)
                    }
                    .setNegativeButton("Cancelar") { _, _ -> }
                    .show()
            }
    }
}
