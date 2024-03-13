package com.example.evoting.view.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.evoting.databinding.CardVoteCandidateBinding
import com.example.evoting.model.DataCandidateNumberResponse

class CandidatePairNumberAdapter (
    private val onItemClick: OnItemClickListener? = null,
    private val onButtonClick: (String) -> Unit
) : RecyclerView.Adapter<CandidatePairNumberAdapter.ViewHolder>() {

    private val diffCallBack = object : DiffUtil.ItemCallback<DataCandidateNumberResponse>(){
        override fun areItemsTheSame(
            oldItem: DataCandidateNumberResponse,
            newItem: DataCandidateNumberResponse
        ): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: DataCandidateNumberResponse,
            newItem: DataCandidateNumberResponse
        ): Boolean = oldItem == newItem
    }

    private val differ = AsyncListDiffer(this, diffCallBack)

    fun submitCandidateNumberResponse(value: List<DataCandidateNumberResponse>) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(CardVoteCandidateBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = differ.currentList[position]
        data.let { holder.bind(data) }
    }

    inner class ViewHolder(private var binding: CardVoteCandidateBinding): RecyclerView.ViewHolder(binding.root) {

        init {
            binding.buttonVote.setOnClickListener {
                val id = differ.currentList[adapterPosition].id
                onButtonClick(id!!)
            }
        }


        @SuppressLint("SetTextI18n")
        fun bind(data: DataCandidateNumberResponse) {
            binding.apply {
                candidateNumber.text = data.number.toString()
                capresTV.text = data.presidentalCandidateName.toString()
                cawapresTV.text = data.vicePresidentalCandidateName.toString()

                Glide.with(this.candidateImg)
                    .load(data.imgUrl)
                    .fitCenter()
                    .into(binding.candidateImg)
            }

        }

    }
}