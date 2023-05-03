package com.example.tinkoffsolutioncupfinal.fragments.lists.vertical

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tinkoffsolutioncupfinal.R
import com.example.tinkoffsolutioncupfinal.databinding.FragmentLightVerticalButtonListBinding
import com.example.tinkoffsolutioncupfinal.helpers.MAIN


class LightVerticalButtonListFragment : Fragment() {

    private lateinit var binding: FragmentLightVerticalButtonListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLightVerticalButtonListBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBack.setOnClickListener {
            MAIN.navController.navigate(R.id.action_lightVerticalButtonListFragment_to_verticalListFragment)
        }

        binding.btnNext.setOnClickListener {
            MAIN.navController.navigate(R.id.action_lightVerticalButtonListFragment_to_darkVerticalButtonListFragment)
        }
    }

}