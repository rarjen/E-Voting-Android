package com.example.evoting.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.evoting.databinding.CardPartySliderBinding
import com.example.evoting.model.DataGetAllParties

class PartiesAdapter(private val onItemClick: OnItemClickListener? = null): RecyclerView.Adapter<PartiesAdapter.ViewHolder>() {

    private val diffCallback = object : DiffUtil.ItemCallback<DataGetAllParties>() {
        override fun areItemsTheSame(
            oldItem: DataGetAllParties,
            newItem: DataGetAllParties
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: DataGetAllParties,
            newItem: DataGetAllParties
        ): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)
    fun submitAllParties(value: List<DataGetAllParties>) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(CardPartySliderBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = differ.currentList[position]
        data.let { holder.bind(data) }
    }

    inner class ViewHolder(private var binding: CardPartySliderBinding): RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                onItemClick?.onItemClick(differ.currentList[adapterPosition].id!!)
            }
        }

        fun bind(data: DataGetAllParties){
            binding.apply {
                valueNameParty.text = data.abbreviation
                Glide.with(this.imgParty)
                    .load(data.imgUrl)
                    .fitCenter()
                    .into(binding.imgParty)
            }
        }
    }

    interface OnItemClickListener{
        fun onItemClick(id: String)
    }
}