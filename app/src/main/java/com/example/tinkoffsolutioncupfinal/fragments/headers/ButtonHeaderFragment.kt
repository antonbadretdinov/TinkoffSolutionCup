package com.example.tinkoffsolutioncupfinal.fragments.headers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tinkoffsolutioncupfinal.R
import com.example.tinkoffsolutioncupfinal.databinding.FragmentButtonHeaderBinding
import com.example.tinkoffsolutioncupfinal.helpers.MAIN


class ButtonHeaderFragment : Fragment() {

    private lateinit var binding: FragmentButtonHeaderBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentButtonHeaderBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBack.setOnClickListener {
            MAIN.navController.navigate(R.id.action_buttonHeaderFragment_to_headerFragment)
        }

        binding.btnNext.setOnClickListener {
            MAIN.navController.navigate(R.id.action_buttonHeaderFragment_to_verticalListFragment)
        }
    }

}