package com.example.campoapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.campoapp.R
import com.example.campoapp.data.Client
import com.example.campoapp.databinding.ItemClientBinding
import com.example.campoapp.presentation.listener.OnClientListener

class ClientAdapter(private val clients: List<Client>, private val onClientListener: OnClientListener? = null) :
    RecyclerView.Adapter<ClientAdapter.ClientViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ClientViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_client, parent, false),
        onClientListener
    )

    override fun onBindViewHolder(holder: ClientViewHolder, position: Int) {
        holder.bind(clients[position])
    }
    override fun getItemCount() = clients.size
    class ClientViewHolder(itemView: View, private val onClientListener: OnClientListener?) : RecyclerView.ViewHolder(itemView){
        private val binding = ItemClientBinding.bind(itemView)
        fun bind(item: Client){
            binding.apply {
                clientName.text = item.name
                hectaresValue.text = item.getHectares().toString()
            }
            binding.itemClient.setOnClickListener{
                onClientListener?.onClientClick(item.name)
            }
            binding.itemClient.setOnLongClickListener {
                onClientListener?.onClientLongClick(item.name)
                true
            }
        }
    }
}
