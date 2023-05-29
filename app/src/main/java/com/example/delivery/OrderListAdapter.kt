package com.example.delivery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.delivery.database.order.Order
import com.example.delivery.databinding.OrderListItemBinding
import androidx.recyclerview.widget.ListAdapter
import androidx.fragment.app.activityViewModels

class OrderListAdapter(private val onOrderClicked: (Order) -> Unit) :
    ListAdapter<Order, OrderListAdapter.OrderViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        return OrderViewHolder(
            OrderListItemBinding
                .inflate(
                    LayoutInflater
                        .from(parent.context)))
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val current = getItem(position)
        holder.itemView.setOnClickListener {
            onOrderClicked(current)
        }
        holder.bind(current)

    }


    class OrderViewHolder(private var binding: OrderListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(order: Order) {
            binding.companyItem.text = order.companyName
            binding.typeItem.text = order.packageType
            binding.senderItem.text = order.senderAddress
            binding.recipientItem.text = order.receiverAddress
            binding.priceItem.text = order.orderPrice.toString()
            binding.checkboxOrder.isChecked = order.orderPlaced
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Order>() {
            override fun areItemsTheSame(oldItem: Order, newItem: Order): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Order, newItem: Order): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}

