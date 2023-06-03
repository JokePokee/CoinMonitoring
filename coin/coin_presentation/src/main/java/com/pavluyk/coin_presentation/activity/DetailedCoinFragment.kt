package com.pavluyk.coin_presentation.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.pavluyk.coin_presentation.R
import com.pavluyk.coin_presentation.viewmodel.CoinDetailedViewModel

import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class DetailedCoinFragment : Fragment() {

    private val viewModel: CoinDetailedViewModel by viewModel(parameters = {
        parametersOf(
            arguments
        )
    })

    private var tvSelectedCoin: TextView? = null
    private var ivSelectedCoin: ImageView? = null
    private var tvDetailedInfo: TextView? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_selected_coin, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvSelectedCoin = view.findViewById(R.id.tvSelectedCoin)
        ivSelectedCoin = view.findViewById(R.id.ivSelectedCoin)
        tvDetailedInfo = view.findViewById(R.id.tvDetailedInfo)

        viewModel.coinDetailedLiveData.observe(viewLifecycleOwner) { coinDetailed ->
            tvSelectedCoin?.text = coinDetailed.name
            tvDetailedInfo?.text = coinDetailed.assetDescription
            ivSelectedCoin.apply {
                ivSelectedCoin?.context?.let { it1 ->
                    this?.let { it2 ->
                        Glide.with(it1).load(coinDetailed.logoUrl).into(
                            it2
                        )
                    }
                }
            }

        }
    }

    companion object {
        const val ARG_ID = "minModel"
    }
}