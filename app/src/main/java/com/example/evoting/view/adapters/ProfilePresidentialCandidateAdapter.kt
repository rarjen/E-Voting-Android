package com.example.evoting.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.evoting.databinding.CardCandidateBinding
import com.example.evoting.model.DataGetAllPresidentialResponse

class ProfilePresidentialCandidateAdapter(
    private val onItemClick: AdapterView.OnItemClickListener? = null
):  RecyclerView.Adapter<ProfilePresidentialCandidateAdapter.ViewHolder>(){

    private val diffCallback = object : DiffUtil.ItemCallback<DataGetAllPresidentialResponse>() {
        override fun areItemsTheSame(
            oldItem: DataGetAllPresidentialResponse,
            newItem: DataGetAllPresidentialResponse
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: DataGetAllPresidentialResponse,
            newItem: DataGetAllPresidentialResponse
        ): Boolean {
            return oldItem == newItem
        }

    }

    private val differ = AsyncListDiffer(this, diffCallback)
    fun submitAllPresidential(value: List<DataGetAllPresidentialResponse>) = differ.submitList(value)


    inner class ViewHolder(private var binding: CardCandidateBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: DataGetAllPresidentialResponse) {
            binding.apply {
                tvValueCandidateName.text = data.name
                Glide.with(this.imgCapres)
                    .load(data.imgUrl)
                    .fitCenter()
                    .into(binding.imgCapres)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(CardCandidateBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = differ.currentList[position]
        data.let { holder.bind(data) }
    }
}