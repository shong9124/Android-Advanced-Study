package com.example.viewmodel

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.viewmodel.databinding.ActivityMainBinding
import com.example.viewmodel.ui.MainFragment
import com.example.viewmodel.ui.SubFragment

class MainActivity : AppCompatActivity() {
    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_1_holder, MainFragment())
                .commit()

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_2_holder, SubFragment())
                .commit()
        }
    }
}