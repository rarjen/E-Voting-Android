package com.example.evoting.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.evoting.databinding.CardSupportingPartiesBinding

class SupportinPartiesAdapter(private val imgUrls: List<String>): RecyclerView.Adapter<SupportinPartiesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CardSupportingPartiesBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return imgUrls.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imgUrls = imgUrls[position]
        holder.bind(imgUrls)
    }

    inner class ViewHolder(private var binding: CardSupportingPartiesBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(imgUrl: String) {
            Glide.with(binding.root)
                .load(imgUrl)
                .fitCenter()
                .into(binding.candidateImg)
        }
    }
}