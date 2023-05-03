package com.example.tinkoffsolutioncupfinal.fragments.item

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tinkoffsolutioncupfinal.R
import com.example.tinkoffsolutioncupfinal.databinding.FragmentItemBinding
import com.example.tinkoffsolutioncupfinal.helpers.MAIN


class ItemFragment : Fragment() {

    private lateinit var binding: FragmentItemBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentItemBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBack.setOnClickListener {
            MAIN.navController.navigate(R.id.action_itemFragment_to_buttonFragment)
        }

        binding.btnNext.setOnClickListener {
            MAIN.navController.navigate(R.id.action_itemFragment_to_headerFragment)
        }
    }

}