package com.example.banksampah.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.banksampah.R
import com.google.android.material.textfield.TextInputLayout
import java.text.SimpleDateFormat
import java.util.*

class MainMenuActivity : AppCompatActivity() {

    private lateinit var dateInputLayout: TextInputLayout
    private lateinit var dateSpinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

////        dateInputLayout = findViewById(R.id.dateInputLayout)
//////        dateSpinner = findViewById(R.id.dateSpinner)
//
//        val dateOptions = getAllDates()
//
//        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, dateOptions)
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//        dateSpinner.adapter = adapter
//
//        // Set an item selected listener for the Spinner
//        dateSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(
//                parent: AdapterView<*>?,
//                view: View?,
//                position: Int,
//                id: Long
//            ) {
//                val selectedDate = dateOptions[position]
//                dateInputLayout.editText?.setText(selectedDate)
//            }
//
//            override fun onNothingSelected(parent: AdapterView<*>?) {
//                // Handle nothing selected if needed
//            }
//        }
//
//
//
////        val autoComplete: AutoCompleteTextView = findViewById(R.id.autoCompleteTextView)
////        val autoComplete2: AutoCompleteTextView = findViewById(R.id.autoCompleteTextView2)
////        val autoComplete3: AutoCompleteTextView = findViewById(R.id.autoCompleteTextView3)
//        val nama_bank = resources.getStringArray(R.array.nama_bank)
//        val nama_petugas = resources.getStringArray(R.array.nama_petugas)
//        val nama_nasabah = resources.getStringArray(R.array.nama_nasabah)
//
//        val arrayAdapter = ArrayAdapter(this, R.layout.dropdown_item, nama_bank)
//        autoComplete.setAdapter(arrayAdapter)
//        val arrayAdapter1 = ArrayAdapter(this, R.layout.dropdown_item, nama_petugas)
//        autoComplete2.setAdapter(arrayAdapter1)
//        val arrayAdapter2 = ArrayAdapter(this, R.layout.dropdown_item, nama_nasabah)
//        autoComplete3.setAdapter(arrayAdapter2)
//
//        autoComplete.setOnItemClickListener { parent, view, position, id ->
//            val selectedLanguage = parent.getItemAtPosition(position).toString()
//            // Handle the selected item (e.g., show a Toast)
//            Toast.makeText(this, "Selected language: $selectedLanguage", Toast.LENGTH_SHORT).show()
//        }
//        autoComplete2.setOnItemClickListener { parent, view, position, id ->
//            val selectedPetugas = parent.getItemAtPosition(position).toString()
//            // Handle the selected item (e.g., show a Toast)
//            Toast.makeText(this, "Selected petugas: $selectedPetugas", Toast.LENGTH_SHORT).show()
//        }
//
//
//
//
//    }
//
//    private fun getAllDates(): List<String> {
//        val dateOptions = mutableListOf<String>()
//        val calendar = Calendar.getInstance()
//        val currentDate = Calendar.getInstance()
//        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.US)
//
//        while (calendar <= currentDate) {
//            val formattedDate = dateFormat.format(calendar.time)
//            dateOptions.add(formattedDate)
//            calendar.add(Calendar.DAY_OF_MONTH, 1)
//        }
//
//        return dateOptions
    }
}