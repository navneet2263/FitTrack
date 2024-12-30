package com.example.fittrack.Activity

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.fittrack.Adapter.LessionsAdapter
import com.example.fittrack.Domain.Workout
import com.example.fittrack.databinding.ActivityWorkoutBinding

class WorkoutActivity : AppCompatActivity() {
    var binding: ActivityWorkoutBinding? = null
    private var workout: Workout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWorkoutBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        `object`
        setVariable()
    }

    private val `object`: Unit
        get() {
            workout = intent.getSerializableExtra("object") as Workout?
        }

    private fun setVariable() {
        val resId = resources.getIdentifier(workout!!.picPath, "drawable", packageName)
        Glide.with(this)
            .load(resId)
            .into(binding!!.pic)

        binding!!.backBtn.setOnClickListener { finish() }

        binding!!.titleTxt.text = workout!!.title
        binding!!.excersizeTxt.text = workout!!.lessions.size.toString() + " Exercise"
        binding!!.kcalTxt.text = workout!!.kcal.toString() + " Kcal"
        binding!!.durationTxt.text = workout!!.durationAll
        binding!!.description.text = workout!!.description

        binding!!.View3.layoutManager =
            LinearLayoutManager(this@WorkoutActivity, LinearLayoutManager.VERTICAL, false)
        binding!!.View3.adapter = LessionsAdapter(workout!!.lessions)
    }
}