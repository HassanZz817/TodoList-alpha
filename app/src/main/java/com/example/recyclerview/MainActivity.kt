package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var todoList = mutableListOf(
            Todo("2 hours of code", false),
            Todo("Social media management",false),
            Todo("Workout",false),
            Todo("Read",false),
            Todo("Meditate",false),
            Todo("Connect With family",false),
            Todo("write Content For Youtube",false),
            Todo("make Online Business with Hussam",false)
        )
        val adapter = ToDoAdapter(todoList)
        rvTodos.adapter = adapter
        rvTodos.layoutManager = LinearLayoutManager(this)

        btnAddTodo.setOnClickListener{
            val title = etTodo.text.toString()
            val todo = Todo(title,false)
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size-1)
        }
    }
}