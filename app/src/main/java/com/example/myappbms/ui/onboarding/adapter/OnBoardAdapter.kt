package com.example.myappbms.ui.onboarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.myappbms.taskmanager.model.OnBoarding
import com.example.myappbms.databinding.ItemOnboardingBinding
import com.example.myappbms.taskmanager.utils.loadImage

class OnBoardAdapter(private val onClick: () -> Unit) :
    RecyclerView.Adapter<OnBoardAdapter.OnBoardViewHolder>() {
    val data = arrayListOf<OnBoarding>(
        OnBoarding(
            "Привет!",
            "Вас приветствует моё приложение!",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRUcHVHL61RDtFRL8Z_jJRvprpTuzuo8M5iQg&usqp=CAU"
        ),
        OnBoarding(
            "Добро пожаловать!",
            "Я буду рад, если оно вам понравиться",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRUcHVHL61RDtFRL8Z_jJRvprpTuzuo8M5iQg&usqp=CAU"
        ),
        OnBoarding(
            "Особая благодарность",
            "Ментору Тилек! Ты правда крутой ментор :)",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRUcHVHL61RDtFRL8Z_jJRvprpTuzuo8M5iQg&usqp=CAU"
        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardViewHolder {
        return OnBoardViewHolder(
            ItemOnboardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardViewHolder, position: Int) {
        holder.bind(data.get(position))
    }

    override fun getItemCount(): Int = data.size

    inner class OnBoardViewHolder(private val binding: ItemOnboardingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(onBoarding: OnBoarding) {
            binding.title.text = onBoarding.title
            binding.desc.text = onBoarding.desc
            binding.ivBoarding.loadImage(onBoarding.img.toString())
            binding.btnSkip.isVisible = adapterPosition == data.lastIndex
            binding.btnSkip.setOnClickListener { onClick() }
        }

    }
}