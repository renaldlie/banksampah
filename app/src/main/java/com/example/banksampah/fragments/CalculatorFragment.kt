package com.example.banksampah.fragments

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.banksampah.InputSampahAdapter
import com.example.banksampah.R
import com.example.banksampah.model.DataSampah
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputLayout
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

private lateinit var dateInputLayout: TextInputLayout
private lateinit var dateSpinner: Spinner
private lateinit var dateEditText : EditText
private lateinit var addButton : FloatingActionButton
private lateinit var minButton : FloatingActionButton

private lateinit var recyclerView: RecyclerView
private lateinit var adapter: InputSampahAdapter
private val itemList = mutableListOf<DataSampah>()


/**
 * A simple [Fragment] subclass.
 * Use the [CalculatorFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CalculatorFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_calculator, container, false)
        dateInputLayout = view.findViewById(R.id.dateInputLayout)
        dateEditText = view.findViewById(R.id.dateEditText)
        recyclerView = view.findViewById(R.id.rv_inputdatasampah)

        dateEditText.setOnClickListener {
            dateEditText.setHint("");
            showDatePicker()
        }

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)
        adapter = InputSampahAdapter(itemList)
        recyclerView.adapter = adapter

        addButton = view.findViewById(R.id.btn_add)
        minButton = view.findViewById(R.id.btn_min)





//        val dateOptions = getAllDates()
//
//        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, dateOptions)
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



        val autoComplete: AutoCompleteTextView = view.findViewById(R.id.input_namanasabah)
        val autoComplete2: AutoCompleteTextView = view.findViewById(R.id.input_banksampah)
        val autoComplete3: AutoCompleteTextView = view.findViewById(R.id.input_petugas)
        val nama_kategori = resources.getStringArray(R.array.nama_kategori)
        val nama_subkategori = resources.getStringArray(R.array.nama_subkategori)



//        val arrayAdapter2 = ArrayAdapter(requireContext(), R.layout.dropdown_item, nama_nasabah)
//        autoComplete3.setAdapter(arrayAdapter2)

        autoComplete.setOnItemClickListener { parent, view, position, id ->
            val selectedLanguage = parent.getItemAtPosition(position).toString()
            // Handle the selected item (e.g., show a Toast)
            Toast.makeText(requireContext(), "Selected language: $selectedLanguage", Toast.LENGTH_SHORT).show()
        }
        autoComplete2.setOnItemClickListener { parent, view, position, id ->
            val selectedPetugas = parent.getItemAtPosition(position).toString()
            // Handle the selected item (e.g., show a Toast)
            Toast.makeText(requireContext(), "Selected petugas: $selectedPetugas", Toast.LENGTH_SHORT).show()
        }
        addButton.setOnClickListener {
            // Add a new item to the list



            // Notify the adapter that the data has changed
            adapter.notifyDataSetChanged()
        }
        minButton.setOnClickListener{
            itemList.clear()
            adapter.notifyDataSetChanged()
        }


        val targetFragment = ProfileFragment()
        val bundle = Bundle()
        bundle.putParcelableArrayList("itemList", ArrayList(itemList))
        targetFragment.arguments = bundle


        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_profile, targetFragment)
            .addToBackStack(null) // Optional: Adds the transaction to the back stack
            .commit()

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CalculatorFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic fun newInstance(param1: String, param2: String) =
                CalculatorFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }


    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            requireContext(),
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