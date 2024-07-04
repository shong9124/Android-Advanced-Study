package com.example.diffutil

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diffutil.data.Monster
import com.example.diffutil.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val adapter by lazy {
        MonsterListAdapter()
    }
    private val monsterList = mutableListOf<Monster>().apply {
        add(Monster("뿔버섯", 10, listOf(100, 10, 50)))
        add(Monster("스텀프", 23, listOf(200, 20, 100)))
        add(Monster("슬라임", 2, listOf(10, 1, 5)))
        add(Monster("주니어발록", 2500, listOf(10000, 1000, 50000)))
        add(Monster("이블아이", 100, listOf(1000, 200, 1000)))
        add(Monster("와일드카고", 50, listOf(2000, 250, 10000)))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerview.adapter = adapter
        // adapter 에 리스트 담아서 새로 고침
        adapter.submitList(monsterList)

        binding.btn.setOnClickListener {
            // 현재 list 에 새로운 아이템 추가를 위해 작성
            val newList = adapter.currentList.toMutableList()
            newList.add(Monster("드래곤", 999999, listOf(500000, 300000, 800000)))
            // 새로 고침
            adapter.submitList(newList)
        }

        val itemTouchHelper = ItemTouchHelper(MyItemTouchHelperCallback(binding.recyclerview))
        itemTouchHelper.attachToRecyclerView(binding.recyclerview)
    }
}