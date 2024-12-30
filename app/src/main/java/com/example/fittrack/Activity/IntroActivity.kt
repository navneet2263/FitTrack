package com.example.fittrack.Activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.fittrack.databinding.ActivityIntroBinding

class IntroActivity : AppCompatActivity() {
    var binding: ActivityIntroBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        binding!!.startBtn.setOnClickListener { view: View? ->
            startActivity(
                Intent(
                    this@IntroActivity, MainActivity::class.java
                )
            )
        }
    }
}