package com.example.datastore

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.datastore.data.UserManager
import com.example.datastore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var userManager: UserManager
    private var age = -1
    private var firstName = ""
    private var lastName = ""
    private var gender = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_store_test)

        userManager = UserManager(dataStore)

        binding.run {
            buttonSave()
            observeData()
        }
    }

    private fun ActivityMainBinding.buttonSave() {
        btnSave.setOnClickListener {
            firstName = etFname.text.toString()
            lastName = etLname.text.toString()
            age = etAge.text.toString().toInt()
            val isMale = switchGender.isChecked


        }
    }

    private fun observeData() {
        userManager.userAgeFlow.asLiveData().observe(this) {

        }

        userManager.userFirstNameFlow.asLiveData().observe(this) {

        }

        userManager.userLastNameFlow.asLiveData().observe(this) {

        }

        userManager.userGenderFlow.asLiveData().observe(this) {

        }
    }
}