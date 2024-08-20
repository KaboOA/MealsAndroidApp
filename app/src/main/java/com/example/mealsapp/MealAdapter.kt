package com.example.mealsapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mealsapp.databinding.MealItemBinding

class MealAdapter(val meals: List<MealModel>, val mealClickListener: MealClickListener) :
    ListAdapter<MealModel, MealAdapter.MyViewHolder>(UserItemDiffCallback()) {

    class MyViewHolder(val mealItemBinding: MealItemBinding) :
        RecyclerView.ViewHolder(mealItemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            MealItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    interface MealClickListener {
        fun onMealClicked(meal: MealModel)
    }

    override fun getItemCount(): Int {
        return meals.size
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.mealItemBinding.mealModel = meals[position]
        holder.mealItemBinding.mealItemCard.setOnClickListener {
            mealClickListener.onMealClicked(meals[position])
        }
    }
}

class UserItemDiffCallback : DiffUtil.ItemCallback<MealModel>() {
    override fun areItemsTheSame(oldItem: MealModel, newItem: MealModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: MealModel, newItem: MealModel): Boolean {
        return oldItem == newItem
    }

}