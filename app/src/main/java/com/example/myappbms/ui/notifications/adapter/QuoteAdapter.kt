package com.example.myappbms.ui.notifications.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myappbms.databinding.ItemTaskBinding
import com.example.myappbms.model.Quotes
import com.example.myappbms.model.Task

class QuoteAdapter() :
    RecyclerView.Adapter<QuoteAdapter.QuoteViewHolder>() {
    private val data = arrayListOf<Quotes>()


    fun addQuote(quotes: List<Quotes>) {
        data.clear()
        data.addAll(quotes)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        return QuoteViewHolder(
            ItemTaskBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        holder.bind(data[position])

    }

    override fun getItemCount(): Int {
        return data.count()
    }

    inner class QuoteViewHolder(private val binding: ItemTaskBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(quotes: Quotes) {
            itemView.setOnLongClickListener {
                false

            }
            with(binding) {
                title.text = quotes.text
                description.text = quotes.author
            }
        }
    }
}
