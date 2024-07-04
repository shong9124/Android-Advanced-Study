package com.example.diffutil

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.diffutil.data.Monster
import com.example.diffutil.databinding.ViewItemlistBinding
import java.util.Collections

class MonsterListAdapter : ListAdapter<Monster, RecyclerView.ViewHolder>(MonsterDiffCallBack()) {
    inner class MonsterViewHolder(private val binding: ViewItemlistBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun onBind(data: Monster) {
            binding.tvName.text = "Name: ${data.name}"
            binding.tvLevel.text = "Lv: ${data.level}"
            binding.tvStats.text = "Hp: ${data.stats[0]} / Mp: ${data.stats[1]} / Exp: ${data.stats[2]}"
        }
        fun setAlpha(alpha: Float) {
            with(binding) {
                tvName.alpha = alpha
                tvLevel.alpha = alpha
                tvStats.alpha = alpha
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ViewItemlistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MonsterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MonsterViewHolder) {
            holder.onBind(getItem(position))
        }
    }
    // 아이템 옮기기
    fun moveItem(fromPosition: Int, toPosition: Int) {
        val list = currentList.toMutableList()
        Collections.swap(list, fromPosition, toPosition)
        submitList(list)
    }
    // 아이템 삭제
    fun removeItem(position: Int) {
        val list = currentList.toMutableList()
        list.removeAt(position)
        submitList(list)
    }
}