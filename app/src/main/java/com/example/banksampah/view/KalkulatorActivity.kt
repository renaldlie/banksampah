package com.example.banksampah.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.banksampah.InputSampahAdapter
import com.example.banksampah.R
import com.example.banksampah.model.DataSampah

private lateinit var sampahRecyclerView: RecyclerView
private var itemList: MutableList<DataSampah>? = null
private lateinit var adapter: InputSampahAdapter
private lateinit var button_kirim: Button

class KalkulatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_profile)

        val sampahRecyclerView = findViewById<RecyclerView>(R.id.rv_datasampah)
        sampahRecyclerView.layoutManager = LinearLayoutManager(this)
        sampahRecyclerView.setHasFixedSize(true)

        // Create and set the adapter for the RecyclerView
        adapter = InputSampahAdapter(
            itemList ?: mutableListOf())
        sampahRecyclerView.adapter = adapter

        button_kirim = findViewById(R.id.btn_data_kirim)
        button_kirim.setOnClickListener {
            val intent = Intent(this, NotaActivity::class.java)

            // Optionally, you can pass data to the SecondActivity using extras
            intent.putExtra("key", "value")

            // Start the SecondActivity
            startActivity(intent)
        }



//        val bundle = arguments
//        if (bundle != null) {
//            itemList = bundle.getParcelableArrayList<DataSampah>("itemList")
//            if (itemList != null) {
//                // Update the adapter with itemList
//
//            }
//        }

    }
}