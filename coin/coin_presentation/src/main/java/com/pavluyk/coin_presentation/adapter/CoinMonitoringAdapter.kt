package com.pavluyk.coin_presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.pavluyk.coin_domain.models.CoinModel
import com.pavluyk.coin_presentation.R
import java.text.DecimalFormat

class CoinMonitoringAdapter(
    var clickListener: (String) -> (Unit),
    val onScrolledToBottom: (CoinModel) -> (Unit)
) :
    RecyclerView.Adapter<CoinMonitoringAdapter.CoinViewHolder>() {

    private var coinItems: MutableList<CoinModel> = mutableListOf()
        set(value) {
            val diffUtil = object : DiffUtil.Callback() {
                override fun getOldListSize() = field.size

                override fun getNewListSize() = value.size

                override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                    return field[oldItemPosition].rank == value[newItemPosition].rank
                }

                override fun areContentsTheSame(
                    oldItemPosition: Int,
                    newItemPosition: Int
                ): Boolean {
                    return field[oldItemPosition] == value[newItemPosition]
                }

            }
            val diffResult = DiffUtil.calculateDiff(diffUtil)
            field.clear()
            field.addAll(value)
            diffResult.dispatchUpdatesTo(this)
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        return CoinViewHolder(
            view = LayoutInflater.from(parent.context)
                .inflate(R.layout.coin_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return coinItems.size
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        holder.bind(coinItems[position])
        if (position == coinItems.lastIndex) {
            onScrolledToBottom(coinItems[position])
        }
    }


    inner class CoinViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        fun bind(coinModel: CoinModel) {
            itemView.findViewById<TextView>(R.id.tvCoinName).apply {
                text = coinModel.name
            }
            itemView.findViewById<TextView>(R.id.tvSymbol).apply {
                text = coinModel.symbol
            }
            itemView.findViewById<TextView>(R.id.tvPrefix).apply {
                val decimalFormat = DecimalFormat("##.##")
                text = decimalFormat.format(coinModel.changePercent24Hr)

            }

            itemView.findViewById<ViewGroup>(R.id.rlPrefix).apply {
                if (coinModel.changePercent24Hr < 0) {
                    setBackgroundResource(R.drawable.coin_minus_bg)
                } else {
                    setBackgroundResource(R.drawable.coin_plus_bg)
                }
            }

            itemView.setOnClickListener {
                clickListener(coinModel.symbol)
            }
        }
    }

    fun setData(list: List<CoinModel>) {
        coinItems = list.toMutableList()
        notifyDataSetChanged()
    }
}
