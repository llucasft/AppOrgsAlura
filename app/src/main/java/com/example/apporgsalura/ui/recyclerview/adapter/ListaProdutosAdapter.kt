package com.example.apporgsalura.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.apporgsalura.R
import com.example.apporgsalura.databinding.ActivityListaProdutosBinding
import com.example.apporgsalura.databinding.ItemListaBinding
import com.example.apporgsalura.model.Produto
import java.text.NumberFormat
import java.util.*

class ListaProdutosAdapter(
    private val context: Context,
    produtos: List<Produto>
) : RecyclerView.Adapter<ListaProdutosAdapter.ViewHolder>() {

    private val produtos = produtos.toMutableList()

    class ViewHolder(private val binding: ItemListaBinding) : RecyclerView.ViewHolder(binding.root) {

        private val nome = binding.tvNome
        private val descricao = binding.tvDescricao
        private val valor = binding.tvValor

        fun vincula(produto: Produto) {
            nome.text = produto.nome
            descricao.text = produto.descricao
            val formatador: NumberFormat =
                NumberFormat.getCurrencyInstance(Locale("pt", "br"))
            val valorEmMoeda = formatador.format(produto.valor)
            valor.text = valorEmMoeda
            binding.imageView.load(produto.imagem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListaBinding.inflate(
            LayoutInflater.from(context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = produtos[position]
        holder.vincula(produto)
    }

    override fun getItemCount(): Int = produtos.size
    fun atualiza(produtos: List<Produto>) {
        this.produtos.clear()
        this.produtos.addAll(produtos)
        notifyDataSetChanged()
    }

}
