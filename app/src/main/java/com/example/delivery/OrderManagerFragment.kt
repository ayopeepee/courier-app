package com.example.delivery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.delivery.databinding.FragmentOrderManagerBinding


class OrderManagerFragment : Fragment() {

    private val viewModel: DeliveryViewModel by activityViewModels {
        DeliveryViewModelFactory((activity?.application as DeliveryApplication).database.orderDao())
    }

    private var _binding: FragmentOrderManagerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOrderManagerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = LinearLayoutManager(this.context)

        binding.floatingActionButton.setOnClickListener {
            val action = OrderManagerFragmentDirections.actionOrderManagerFragmentToOrderAddFragment()
            this.findNavController().navigate(action)
        }
    }
}