package com.example.tinkoffsolutioncupfinal.fragments.headers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tinkoffsolutioncupfinal.R
import com.example.tinkoffsolutioncupfinal.databinding.FragmentHeaderBinding


class HeaderFragment : Fragment() {

    private lateinit var binding: FragmentHeaderBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHeaderBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_headerFragment_to_itemFragment)
        }

        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_headerFragment_to_buttonHeaderFragment)
        }
    }

}