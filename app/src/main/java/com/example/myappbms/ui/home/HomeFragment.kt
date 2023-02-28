package com.example.myappbms.ui.home

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myappbms.App
import com.example.myappbms.R
import com.example.myappbms.databinding.FragmentHomeBinding
import com.example.myappbms.model.Task
import com.example.myappbms.ui.home.adapter.TaskAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = TaskAdapter(this::onLongClickListener)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.taskFragment)
        }
        setData()
        binding.recyclerView.adapter = adapter

    }

    private fun onLongClickListener(task: Task) {
        val alert = AlertDialog.Builder(requireContext())
        alert.setTitle("Are you sure you want to delete this?")
        alert.setMessage("If you delete this task, you will not be able to return it!")
        alert.setPositiveButton("Yes!") { d, _ ->
            App.db.taskDao().deleteTask(task)
            setData()
            d.dismiss()
        }
        alert.setNegativeButton("No!") { d, _ ->
            d.dismiss()
        }
        alert.create().show()
    }

    private fun setData() {
        val tasks = App.db.taskDao().getAll()
        adapter.addTask(tasks)
    }
}