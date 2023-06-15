package com.example.tinkoffsolutioncupfinal.fragments.button

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tinkoffsolutioncupfinal.R
import com.example.tinkoffsolutioncupfinal.databinding.FragmentButtonBinding


class ButtonFragment : Fragment() {

    private lateinit var binding: FragmentButtonBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentButtonBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_buttonFragment_to_itemFragment)
        }
    }

}