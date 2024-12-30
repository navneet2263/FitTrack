package com.example.fittrack.Activity

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fittrack.Adapter.WorkoutAdapter
import com.example.fittrack.Domain.Lession
import com.example.fittrack.Domain.Workout
import com.example.fittrack.R
import com.example.fittrack.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)



        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        binding!!.view1.layoutManager =
            LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
        binding!!.view1.adapter = WorkoutAdapter(data)
    }

    private val data: ArrayList<Workout>
        //this sample data for list, you can use your data with api services//
        get() {
            val list = ArrayList<Workout>()

            list.add(
                Workout(
                    "Running",
                    "You just woke up. It is a brand new day. The canvas is blank. How do you begin? Take 21 minutes to cultivate a peaceful mind and strong body ",
                    "pic_1",
                    160,
                    "9 min",
                    lession_1
                )
            )
            list.add(
                Workout(
                    "Stretching",
                    "You just woke up. It is a brand new day. The canvas is blank. How do you begin? Take 21 minutes to cultivate a peaceful mind and strong body ",
                    "pic_2",
                    230,
                    "85 min",
                    lession_2
                )
            )
            list.add(
                Workout(
                    "Yoga",
                    "You just woke up. It is a brand new day. The canvas is blank. How do you begin? Take 21 minutes to cultivate a peaceful mind and strong body ",
                    "pic_3",
                    180,
                    "65 min",
                    lession_3
                )
            )

            return list
        }
    private val lession_1: ArrayList<Lession>
        get() {
            val list = ArrayList<Lession>()

            list.add(Lession("Lesson 1", "03:46", "HBPMvFkpNgE", "pic_1_1"))
            list.add(Lession("Lesson 2", "03:41", "K6I24WgiiPw", "pic_1_2"))
            list.add(Lession("Lesson 3", "01:57", "Zc08v4YY0eA", "pic_1_3"))

            return list
        }
    private val lession_2: ArrayList<Lession>
        get() {
            val list = ArrayList<Lession>()

            list.add(Lession("Lesson 1", "20:23", "L3eImBAXT7I", "pic_3_1"))
            list.add(Lession("Lesson 2", "18:27", "47Exgz07FlU", "pic_3_2"))
            list.add(Lession("Lesson 3", "32:25", "0mLx8tmaQ-4", "pic_3_3"))
            list.add(Lession("Lesson 4", "07:52", "w86ealEoFRY", "pic_3_4"))

            return list
        }
    private val lession_3: ArrayList<Lession>
        get() {
            val list = ArrayList<Lession>()

            list.add(Lession("Lesson 1", "23:00", "v7AYKMP6r0E", "pic_3_1"))
            list.add(Lession("Lesson 2", "27:00", "Eml2xnoLpYE", "pic_3_2"))
            list.add(Lession("Lesson 3", "25:00", "v7SN-d4qXx0", "pic_3_3"))
            list.add(Lession("Lesson 4", "21:00", "LqXZ628YNj4", "pic_3_4"))

            return list
        }
}