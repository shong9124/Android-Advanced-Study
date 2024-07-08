package com.example.cleanarchitecture_mvvm.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecture_mvvm.databinding.ItemGithubRepoBinding
import com.example.cleanarchitecture_mvvm.domain.model.GithubRepo

class GithubAdapter : RecyclerView.Adapter<GithubViewHolder>() {

    private val items = mutableListOf<GithubRepo>()

    fun setItems(items: List<GithubRepo>) {
        this.items.clear()
        this.items.addAll(items)

        notifyDataSetChanged()
    }

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return GithubViewHolder(
            ItemGithubRepoBinding.inflate(layoutInflater)
        )
    }

    override fun onBindViewHolder(holder: GithubViewHolder, position: Int) {
        holder.bind(items[position])
    }
}

class GithubViewHolder(
    private val binding: ItemGithubRepoBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(repo: GithubRepo) {
        binding.repoName.text = repo.name
        binding.repoUrl.text = repo.url
    }
}