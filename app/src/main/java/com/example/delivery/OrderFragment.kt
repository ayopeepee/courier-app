package com.example.delivery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.delivery.databinding.FragmentOrderBinding
import com.example.delivery.databinding.OrderListItemBinding


class OrderFragment : Fragment() {

    private val viewModel: DeliveryViewModel by activityViewModels {
        DeliveryViewModelFactory((activity?.application as DeliveryApplication).database.orderDao())
    }

    private var _binding: FragmentOrderBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOrderBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = LinearLayoutManager(this.context)
        val adapter = OrderListAdapter {}
        binding.recyclerView.adapter = adapter
        viewModel.allOrders.observe(this.viewLifecycleOwner) { orders ->
            orders.let { adapter.submitList(it) }
        }


    }
}