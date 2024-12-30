package com.example.fittrack.Adapter

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fittrack.Domain.Lession
import com.example.fittrack.databinding.ViewholderExerciseBinding

class LessionsAdapter(private val list: ArrayList<Lession>) :
    RecyclerView.Adapter<LessionsAdapter.Viewholder>() {
    private var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        context = parent.context
        val binding =
            ViewholderExerciseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: Viewholder, @SuppressLint("RecyclerView") position: Int) {
        holder.binding.titleTxt.text = list[position].title
        holder.binding.durationTxt.text = list[position].duration

        val resId = context!!.resources.getIdentifier(
            list[position].picPath,
            "drawable",
            context!!.packageName
        )
        Glide.with(context!!)
            .load(resId)
            .into(holder.binding.pic)

        holder.binding.root.setOnClickListener {
            val appIntent =
                Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + list[position].link))
            val webIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("http://www.youtube.com/watch?v=" + list[position].link)
            )
            try {
                context!!.startActivity(appIntent)
            } catch (ex: ActivityNotFoundException) {
                context!!.startActivity(webIntent)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class Viewholder(var binding: ViewholderExerciseBinding) : RecyclerView.ViewHolder(
        binding.root
    )
}
