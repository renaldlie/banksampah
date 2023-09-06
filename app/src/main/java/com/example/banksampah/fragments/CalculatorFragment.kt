package com.example.banksampah.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.banksampah.R
import com.google.android.material.textfield.TextInputLayout
import java.text.SimpleDateFormat
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

private lateinit var dateInputLayout: TextInputLayout
private lateinit var dateSpinner: Spinner

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
        dateSpinner = view.findViewById(R.id.dateSpinner)

        val dateOptions = getAllDates()

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, dateOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        dateSpinner.adapter = adapter

        // Set an item selected listener for the Spinner
        dateSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedDate = dateOptions[position]
                dateInputLayout.editText?.setText(selectedDate)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle nothing selected if needed
            }
        }



        val autoComplete: AutoCompleteTextView = view.findViewById(R.id.autoCompleteTextView)
        val autoComplete2: AutoCompleteTextView = view.findViewById(R.id.autoCompleteTextView2)
        val autoComplete3: AutoCompleteTextView = view.findViewById(R.id.autoCompleteTextView3)
        val nama_bank = resources.getStringArray(R.array.nama_bank)
        val nama_petugas = resources.getStringArray(R.array.nama_petugas)
        val nama_nasabah = resources.getStringArray(R.array.nama_nasabah)

        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, nama_bank)
        autoComplete.setAdapter(arrayAdapter)
        val arrayAdapter1 = ArrayAdapter(requireContext(), R.layout.dropdown_item, nama_petugas)
        autoComplete2.setAdapter(arrayAdapter1)
        val arrayAdapter2 = ArrayAdapter(requireContext(), R.layout.dropdown_item, nama_nasabah)
        autoComplete3.setAdapter(arrayAdapter2)

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
    private fun getAllDates(): List<String> {
        val dateOptions = mutableListOf<String>()
        val calendar = Calendar.getInstance()
        val currentDate = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.US)

        while (calendar <= currentDate) {
            val formattedDate = dateFormat.format(calendar.time)
            dateOptions.add(formattedDate)
            calendar.add(Calendar.DAY_OF_MONTH, 1)
        }

        return dateOptions
    }
}