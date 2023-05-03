package com.example.tinkoffsolutioncupfinal.fragments.lists.vertical

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tinkoffsolutioncupfinal.R
import com.example.tinkoffsolutioncupfinal.databinding.FragmentDarkVerticalButtonListBinding
import com.example.tinkoffsolutioncupfinal.helpers.MAIN


class DarkVerticalButtonListFragment : Fragment() {

    private lateinit var binding: FragmentDarkVerticalButtonListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDarkVerticalButtonListBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBack.setOnClickListener {
            MAIN.navController.navigate(R.id.action_darkVerticalButtonListFragment_to_lightVerticalButtonListFragment)
        }

        binding.btnNext.setOnClickListener {
            MAIN.navController.navigate(R.id.action_darkVerticalButtonListFragment_to_horizontalListFragment)
        }
    }

}