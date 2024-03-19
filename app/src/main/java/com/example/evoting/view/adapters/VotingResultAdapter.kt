package com.example.evoting.view.adapters

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.evoting.databinding.CardResultCandidateBinding
import com.example.evoting.model.DataVotingResultResponse
import kotlin.math.floor

class VotingResultAdapter(private val onItemClick: OnItemClickListener? = null) : RecyclerView.Adapter<VotingResultAdapter.ViewHolder>() {

    private val diffCallBack = object : DiffUtil.ItemCallback<DataVotingResultResponse>() {
        override fun areItemsTheSame(
            oldItem: DataVotingResultResponse,
            newItem: DataVotingResultResponse
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: DataVotingResultResponse,
            newItem: DataVotingResultResponse
        ): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallBack)

    fun submitVotingResultResponse(value: List<DataVotingResultResponse>) = differ.submitList(value)

    inner class ViewHolder(private var binding: CardResultCandidateBinding): RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(data: DataVotingResultResponse) {
            val percentageDouble = data.percentage!!.toDouble()
            val formattedPercentage = String.format("%.2f", percentageDouble)
            Log.d("TESTPERCENTAGE", formattedPercentage)
            val intPart = percentageDouble.toInt()
            binding.apply {
                candidateNumber.text = data.number.toString()
                capres.text = data.presidentalName.toString()
                cawapres.text = data.vicePresidentalName.toString()
                valueTotalSuara.text = data.totalVote.toString()
                tvIndicatorPercentage.text = "$formattedPercentage %"
                votePercentage.progress = intPart
                Glide.with(this.candidateImg)
                    .load(data.imgResult)
                    .fitCenter()
                    .into(candidateImg)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(CardResultCandidateBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = differ.currentList[position]
        data.let { holder.bind(data) }
    }
}