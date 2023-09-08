package com.example.banksampah.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.banksampah.R
import com.example.banksampah.SampahAdapter
import com.example.banksampah.model.Sampah

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

private lateinit var sampahRecyclerView: RecyclerView
private lateinit var sampahArrayList: ArrayList<Sampah>
lateinit var res_kat : Array<String>
lateinit var res_subkat : Array<String>


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

        res_kat = arrayOf("PET","Logam","Besi")
        res_subkat = arrayOf("Rongsok Campur","Tembaga","Aluminium")

        sampahRecyclerView = view.findViewById(R.id.rv_datasampah);
        sampahRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        sampahRecyclerView.setHasFixedSize(true)

        sampahArrayList = arrayListOf<Sampah>()
        getUserData()

        return view
    }

    private fun getUserData() {
        for(i in res_kat.indices){

            val sampahh = Sampah(res_kat[i], res_subkat[i])
            sampahArrayList.add(sampahh)
        }

        sampahRecyclerView.adapter = SampahAdapter(sampahArrayList)
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