package com.example.delivery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.delivery.database.order.Order
import com.example.delivery.databinding.FragmentOrderAddBinding


class OrderAddFragment : Fragment() {

    lateinit var order: Order

    private val viewModel: DeliveryViewModel by activityViewModels {
        DeliveryViewModelFactory(
            (activity?.application as DeliveryApplication).database.orderDao()
        )
    }

    private var _binding: FragmentOrderAddBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOrderAddBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun isEntryValid(): Boolean {
        return viewModel.isEntryValid(
            binding.name.text.toString(),
            binding.type.text.toString(),
            binding.sender.text.toString(),
            binding.receiver.text.toString(),
            binding.price.text.toString(),
            "false"
        )
    }

    private fun addNewOrder() {
        if (isEntryValid()) {
            viewModel.addNewOrder(
                binding.name.text.toString(),
                binding.type.text.toString(),
                binding.sender.text.toString(),
                binding.receiver.text.toString(),
                binding.price.text.toString(),
                "false"
            )
        }
        val action = OrderAddFragmentDirections.actionOrderAddFragmentToOrderManagerFragment()
        findNavController().navigate(action)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.saveAction.setOnClickListener {
            addNewOrder()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}