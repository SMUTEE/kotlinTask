package com.example.mykotlintask

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_second.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(bin_recycler){
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = BioRecyclerAdapter(populate())
        }
        button_second.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }
    fun populate(): List<BioItem> {
        return listOf(
            BioItem("AvailableBooks:", getString(R.string.how_to_succeed_chain_to_success)),
            BioItem("Albums", getString(R.string.oxygene_after_hours)),
            BioItem("Art", getString(R.string.mona_lisa_the_last_supper))
        )
    }
}
