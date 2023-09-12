package com.example.banksampah.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.banksampah.InputSampahAdapter
import com.example.banksampah.R
import com.example.banksampah.SampahAdapter
import com.example.banksampah.model.DataSampah
import com.example.banksampah.model.Sampah

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

private lateinit var sampahRecyclerView: RecyclerView
private var itemList: MutableList<DataSampah>? = null
private lateinit var adapter: InputSampahAdapter


/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment : Fragment() {
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

        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        val sampahRecyclerView = view.findViewById<RecyclerView>(R.id.rv_datasampah)
        sampahRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        sampahRecyclerView.setHasFixedSize(true)

        // Create and set the adapter for the RecyclerView
        adapter = InputSampahAdapter(itemList ?: mutableListOf())
        sampahRecyclerView.adapter = adapter

        val bundle = arguments
        if (bundle != null) {
            itemList = bundle.getParcelableArrayList<DataSampah>("itemList")
            if (itemList != null) {
                // Update the adapter with itemList

            }
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
         * @return A new instance of fragment ProfileFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic fun newInstance(param1: String, param2: String) =
                ProfileFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}