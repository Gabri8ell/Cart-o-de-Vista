package app.mypc.cartodevisitas.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import app.mypc.cartodevisitas.data.CartaoVisita
import app.mypc.cartodevisitas.databinding.ItemCartaoVisitaBinding

class CartaoVisitaAdapter: ListAdapter<CartaoVisita, CartaoVisitaAdapter.ViewHolder>(DiffCallback()) {

    var listenerShare: (View) -> Unit = {}

    inner class ViewHolder(private val binding: ItemCartaoVisitaBinding): RecyclerView.ViewHolder(binding.root){
        fun bin(item: CartaoVisita){
            binding.tvNome.text = item.nome
            binding.tvEmail.text = item.email
            binding.tvTelefone.text = item.telefone
            binding.tvEmpresa.text = item.empresa
            binding.mcvContent.setCardBackgroundColor(Color.parseColor(item.fundoPersonalizado))
            binding.mcvContent.setOnClickListener {
                listenerShare(it)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCartaoVisitaBinding.inflate(inflater, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bin(getItem(position))
    }
}

class DiffCallback:  DiffUtil.ItemCallback<CartaoVisita>(){
    override fun areItemsTheSame(oldItem: CartaoVisita, newItem: CartaoVisita) = oldItem == newItem

    override fun areContentsTheSame(oldItem: CartaoVisita, newItem: CartaoVisita) = oldItem.id == newItem.id

}