package com.example.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.example.diffutil.data.Monster

class MonsterDiffCallBack : DiffUtil.ItemCallback<Monster>() {
    override fun areItemsTheSame(oldItem: Monster, newItem: Monster) =
        oldItem.name == newItem.name

    override fun areContentsTheSame(oldItem: Monster, newItem: Monster) =
        oldItem == newItem
}