package com.example.myappbms.ui.task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.myappbms.databinding.FragmentTaskBinding
import com.example.myappbms.taskmanager.model.Task
import com.example.myappbms.ui.home.HomeFragment

class TaskFragment : Fragment() {
    private lateinit var binding: FragmentTaskBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSave.setOnClickListener {
            val task = Task(binding.etTittle.text.toString(), binding.etDesc.text.toString()
            )
            setFragmentResult(HomeFragment.RESULT_KEY, bundleOf(HomeFragment.TASK_KEY to task))
            findNavController().navigateUp()
        }
    }
}