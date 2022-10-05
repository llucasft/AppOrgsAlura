package com.example.apporgsalura.ui.dialog

import android.content.Context
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import com.example.apporgsalura.databinding.FormularioImagemBinding
import com.example.apporgsalura.extensions.tentaCarregarImagem

class FormularioImagemDialog(private val context: Context) {

    fun mostraDialog(quandoImagemCarregada : (imagem: String) -> Unit) {
        val binding = FormularioImagemBinding.inflate(LayoutInflater.from(context))
        binding.formularioDialogBotaoCarregar.setOnClickListener {
            val url = binding.formularioDialogImagemEtURL.text.toString()
            binding.formularioDialogImagem.tentaCarregarImagem(url)
        }

        AlertDialog.Builder(context)
            .setMessage("mensagem teste")
            .setTitle("titulo teste")
            .setView(binding.root)
            .setPositiveButton("Confirmar") { _, _ ->
                val url = binding.formularioDialogImagemEtURL.text.toString()
                quandoImagemCarregada(url)
            }
            .setNegativeButton("Cancelar") { _, _ -> }
            .show()
    }
}
