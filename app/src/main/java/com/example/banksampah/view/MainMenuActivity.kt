package com.example.banksampah.view

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.banksampah.InputSampahAdapter
import com.example.banksampah.R
import com.example.banksampah.fragments.ProfileFragment
import com.example.banksampah.model.DataSampah
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputLayout
import java.util.*

class MainMenuActivity : AppCompatActivity() {

    private lateinit var dateInputLayout: TextInputLayout
    private lateinit var dateSpinner: Spinner
    private lateinit var dateEditText : EditText
    private lateinit var addButton : FloatingActionButton
    private lateinit var minButton : FloatingActionButton
    private lateinit var buttonsend : Button


    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: InputSampahAdapter
    private val itemList = mutableListOf<DataSampah>()
    private val dataSampah = DataSampah("", "", "0")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_calculator)
        val anotherLayoutRootView = layoutInflater.inflate(R.layout.cv_inputdatasampah, null)



        dateInputLayout = findViewById(R.id.dateInputLayout)
        dateEditText = findViewById(R.id.dateEditText)
       recyclerView = findViewById(R.id.rv_inputdatasampah)

        dateEditText.setOnClickListener {
            dateEditText.setHint("");
            showDatePicker()
        }




        addButton = findViewById(R.id.btn_add)
        minButton = findViewById(R.id.btn_min)
        itemList.add(dataSampah)

        val autoComplete: AutoCompleteTextView = anotherLayoutRootView.findViewById(R.id.data_kategori)
        val autoComplete2: AutoCompleteTextView = anotherLayoutRootView.findViewById(R.id.data_subkategori)
        val autoComplete3: AutoCompleteTextView = findViewById(R.id.input_banksampah)
        val nama_kategori = resources.getStringArray(R.array.nama_kategori)
        val nama_subkategori = resources.getStringArray(R.array.nama_subkategori)
        buttonsend = findViewById(R.id.btn_kirim)
        val nama_bank = resources.getStringArray(R.array.nama_bank)
        val nama_petugas = resources.getStringArray(R.array.nama_petugas)
        val nama_nasabah = resources.getStringArray(R.array.nama_nasabah)

        recyclerView.layoutManager = LinearLayoutManager(this)
        val data = listOf("Option 1", "Option 2", "Option 3")
        recyclerView.setHasFixedSize(true)
        adapter = InputSampahAdapter(itemList)
        recyclerView.adapter = adapter

        val kategoriAdapter = ArrayAdapter(this, R.layout.dropdown_item, nama_bank)
        autoComplete.setAdapter(kategoriAdapter)
        val subkategoriAdapter = ArrayAdapter(this, R.layout.dropdown_item, nama_bank)
        autoComplete2.setAdapter(subkategoriAdapter)
        val bankAdapter = ArrayAdapter(this, R.layout.dropdown_item, nama_bank)
        autoComplete3.setAdapter(bankAdapter)

        autoComplete.setOnItemClickListener { parent, view, position, id ->
            val selectedLanguage = parent.getItemAtPosition(position).toString()
            // Handle the selected item (e.g., show a Toast)
            Toast.makeText(this, "Selected Kategori: $selectedLanguage", Toast.LENGTH_SHORT).show()
        }
        autoComplete2.setOnItemClickListener { parent, view, position, id ->
            val selectedPetugas = parent.getItemAtPosition(position).toString()
            // Handle the selected item (e.g., show a Toast)
            Toast.makeText(this, "Selected petugas: $selectedPetugas", Toast.LENGTH_SHORT).show()
        }
        addButton.setOnClickListener {
            // Add a new item to the list
            val newDataSampah = DataSampah("", "","0")
            itemList.add(newDataSampah)

            // Notify the adapter that the data has changed
            adapter.notifyDataSetChanged()
        }
        minButton.setOnClickListener{
            itemList.clear()
            adapter.notifyDataSetChanged()
        }
        buttonsend.setOnClickListener {
            val intent = Intent(this, KalkulatorActivity::class.java)

            // Optionally, you can pass data to the SecondActivity using extras
            intent.putExtra("key", "value")

            // Start the SecondActivity
            startActivity(intent)
        }



        val targetFragment = ProfileFragment()
        val bundle = Bundle()
        bundle.putParcelableArrayList("itemList", ArrayList(itemList))
        targetFragment.arguments = bundle


    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { _, selectedYear, selectedMonth, selectedDayOfMonth ->
                // Handle the selected date
                val selectedDate = "$selectedDayOfMonth ${getMonthName(selectedMonth)} $selectedYear"
                dateEditText.setText(selectedDate)
            },
            year,
            month,
            dayOfMonth
        )

        datePickerDialog.show()
    }
    private fun getMonthName(month: Int): String {
        val monthNames = arrayOf(
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        )
        return monthNames[month]
    }
}