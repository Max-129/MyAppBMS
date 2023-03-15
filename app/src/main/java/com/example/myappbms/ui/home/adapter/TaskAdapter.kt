package com.example.myappbms.ui.home.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myappbms.databinding.ItemTaskBinding
import com.example.myappbms.model.Task

class TaskAdapter(private val longClickListener: (Task) -> Unit) :
    RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {
    private val data = arrayListOf<Task>()
    private var color = true


    fun addTask(tasks: List<Task>) {
        data.clear()
        data.addAll(tasks)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            ItemTaskBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.count()
    }

    inner class TaskViewHolder(private val binding: ItemTaskBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(task: Task) {
            itemView.setOnLongClickListener {
                longClickListener(task)
                false
            }
            with(binding) {
                title.text = task.title
                description.text = task.descritpion
            }
            if (color && position % 2 == 0) {
                binding.linearLayout.setBackgroundColor(Color.BLACK)
                binding.description.setTextColor(Color.WHITE)
                binding.title.setTextColor(Color.WHITE)
            } else {
                binding.linearLayout.setBackgroundColor(Color.WHITE)
                binding.description.setTextColor(Color.BLACK)
                binding.title.setTextColor(Color.BLACK)
            }
        }



    }
}