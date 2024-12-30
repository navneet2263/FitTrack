package com.example.fittrack.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fittrack.Activity.WorkoutActivity
import com.example.fittrack.Domain.Workout
import com.example.fittrack.databinding.ViewholderWorktoutBinding

class WorkoutAdapter(private val list: ArrayList<Workout>) :
    RecyclerView.Adapter<WorkoutAdapter.Viewholder>() {
    private var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        context = parent.context
        val binding =
            ViewholderWorktoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        holder.binding.titleTxt.text = list[position].title
        val resId = context!!.resources.getIdentifier(
            list[position].picPath,
            "drawable",
            context!!.packageName
        )

        Glide.with(holder.itemView.context)
            .load(resId)
            .into(holder.binding.pic)

        holder.binding.excersizeTxt.text = list[position].lessions.size.toString() + " Exercise"
        holder.binding.kcalTxt.text = list[position].kcal.toString() + " Kcal"
        holder.binding.durationTxt.text = list[position].durationAll

        holder.binding.root.setOnClickListener { view: View? ->
            val intent = Intent(context, WorkoutActivity::class.java)
            intent.putExtra("object", list[position])
            context!!.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class Viewholder(var binding: ViewholderWorktoutBinding) : RecyclerView.ViewHolder(
        binding.root
    )
}
