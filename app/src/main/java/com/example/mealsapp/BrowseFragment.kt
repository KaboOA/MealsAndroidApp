package com.example.mealsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.mealsapp.databinding.FragmentBrowseBinding

class BrowseFragment : Fragment(), MealAdapter.MealClickListener {

    lateinit var bind: FragmentBrowseBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bind = FragmentBrowseBinding.inflate(inflater, container, false)

        val meals = listOf(
            MealModel(R.drawable.burger, "Burger"),
            MealModel(R.drawable.filletsteak, "Steak"),
            MealModel(R.drawable.pancakes, "Pan Cakes"),
            MealModel(R.drawable.pizza, "Pizza"),
            MealModel(R.drawable.shawerma, "Shawerma"),
            MealModel(R.drawable.waffles, "Waffles"),
        )
        bind.rv.adapter = MealAdapter(meals,this)
        return bind.root
    }

    override fun onMealClicked(meal: MealModel) {
        Toast.makeText(context,meal.title,Toast.LENGTH_SHORT).show()
        val action = BrowseFragmentDirections.actionBrowseToMealDetailsFragment(meal)
        findNavController().navigate(action)
    }
}