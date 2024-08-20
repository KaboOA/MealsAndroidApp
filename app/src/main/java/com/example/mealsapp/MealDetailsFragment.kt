package com.example.mealsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.mealsapp.databinding.FragmentBrowseBinding
import com.example.mealsapp.databinding.FragmentMealDetailsBinding

class MealDetailsFragment : Fragment() {
    lateinit var bind: FragmentMealDetailsBinding
    private val args: MealDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bind = FragmentMealDetailsBinding.inflate(inflater, container, false)
        bind.mealModel = args.meal
        return bind.root
    }

}