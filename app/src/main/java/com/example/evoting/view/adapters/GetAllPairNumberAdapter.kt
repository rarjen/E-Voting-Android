package com.example.evoting.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.evoting.databinding.CardCandidatePairBinding
import com.example.evoting.model.DataCandidateNumberResponse

class GetAllPairNumberAdapter (
    private val onItemClick: OnItemClickListener? = null
): RecyclerView.Adapter<GetAllPairNumberAdapter.ViewHolder>() {

    private val diffCallBack = object : DiffUtil.ItemCallback<DataCandidateNumberResponse>(){
        override fun areItemsTheSame(
            oldItem: DataCandidateNumberResponse,
            newItem: DataCandidateNumberResponse
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: DataCandidateNumberResponse,
            newItem: DataCandidateNumberResponse
        ): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallBack)

    fun submitData(value: List<DataCandidateNumberResponse>) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(CardCandidatePairBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = differ.currentList[position]
        data.let { holder.bind(data) }
    }

    inner class ViewHolder(private var binding: CardCandidatePairBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: DataCandidateNumberResponse) {
            binding.apply {
                tvValuePresidentialName.text = data.presidentalCandidateName
                tvValueVicePresidentialName.text = data.vicePresidentalCandidateName
                Glide.with(this.imgCover)
                    .load(data.imgUrl)
                    .fitCenter()
                    .into(binding.imgCover)
            }
        }
    }
}