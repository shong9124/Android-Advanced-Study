package com.example.cleanarchitecture_mvvm.presentation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cleanarchitecture_mvvm.R
import com.example.cleanarchitecture_mvvm.databinding.ActivityMainBinding
import com.example.cleanarchitecture_mvvm.presentation.base.BaseActivity

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(R.layout.activity_main) {

    override val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.recyclerView.adapter = GithubAdapter()

        binding.submitBtn.setOnClickListener {
            val owner = binding.ownerEditText.text.toString()
            viewModel.getGithubRepositories(owner)
        }

        subscribeToLiveData()
    }

    private fun subscribeToLiveData() {
        viewModel.githubRepositories.observe(this) {
            (binding.recyclerView.adapter as GithubAdapter).setItems(it)
        }
    }
}