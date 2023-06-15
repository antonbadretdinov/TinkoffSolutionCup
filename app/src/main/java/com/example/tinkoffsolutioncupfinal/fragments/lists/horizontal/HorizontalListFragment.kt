package com.example.tinkoffsolutioncupfinal.fragments.lists.horizontal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tinkoffsolutioncupfinal.R
import com.example.tinkoffsolutioncupfinal.databinding.FragmentHorizontalListBinding


class HorizontalListFragment : Fragment() {

    private lateinit var binding: FragmentHorizontalListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHorizontalListBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_horizontalListFragment_to_darkVerticalButtonListFragment)
        }

        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_horizontalListFragment_to_horizontalButtonListFragment)
        }
    }

}