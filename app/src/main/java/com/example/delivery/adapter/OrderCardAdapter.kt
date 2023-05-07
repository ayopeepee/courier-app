package com.example.delivery.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.delivery.R
import com.example.delivery.data.Datasource
import com.example.delivery.model.Order

class OrderCardAdapter(
    private val context: Context?
) : RecyclerView.Adapter<OrderCardAdapter.OrderCardViewHolder>() {

    private val orderList = Datasource.orders

    class OrderCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
        val companyTextView: TextView? = view!!.findViewById(R.id.company_item)
        val typeTextView: TextView? = view!!.findViewById(R.id.type_item)
        val senderTextView: TextView? = view!!.findViewById(R.id.sender_item)
        val recipientTextView: TextView? = view!!.findViewById(R.id.recipient_item)
        val priceTextView: TextView? = view!!.findViewById(R.id.price_item)
        val takeOrderTextView: TextView? = view!!.findViewById(R.id.order_taken_item)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderCardViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.vertical_list_item, parent, false)
        return OrderCardViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: OrderCardViewHolder, position: Int) {

        val orderData = orderList[position]
        val resources = context?.resources
        holder.companyTextView?.text = orderData.company.name
        holder.typeTextView?.text = resources?.getString(R.string.package_type, orderData._package.toString())
        holder.senderTextView?.text = resources?.getString(R.string.sender_address, orderData.from)
        holder.recipientTextView?.text = resources?.getString(R.string.recipient_address, orderData.to)
        holder.priceTextView?.text = resources?.getString(R.string.price, orderData.price.toString())
    }

    override fun getItemCount(): Int = orderList.size
}