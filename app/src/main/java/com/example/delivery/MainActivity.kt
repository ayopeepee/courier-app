package com.example.delivery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.example.delivery.adapter.OrderCardAdapter
import com.example.delivery.data.Datasource
import com.example.delivery.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = OrderCardAdapter(applicationContext, binding.total)

        binding.verticalRecyclerView.adapter = adapter

        binding.btnClear.setOnClickListener {
            adapter.uncheckAll()
        }

    }



}