package com.pavluyk.coin_presentation.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.pavluyk.coin_presentation.R
import com.pavluyk.coin_presentation.activity.DetailedCoinFragment.Companion.ARG_ID
import com.pavluyk.coin_presentation.adapter.CoinMonitoringAdapter
import com.pavluyk.coin_presentation.viewmodel.CoinMonitoringViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class CoinMonitoringFragment : Fragment() {

    private val viewModel: CoinMonitoringViewModel by viewModel()
    var recyclerView: RecyclerView? = null

    val adapter = CoinMonitoringAdapter(
        clickListener = { id ->
            viewModel.onCoinClicked(id)
        },
        onScrolledToBottom = {
            viewModel.onPagination()
        })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.coinDataLiveData.observe(this, Observer {
            it?.let { adapter.setData(it) }
        })
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.rvCoin)
        recyclerView?.adapter = this@CoinMonitoringFragment.adapter

        viewModel.navigationEvent.observe(viewLifecycleOwner, ::handleNavigation)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_coin_monitoring, container, false)
    }

    private fun navigateToDetailedScreen(id: String) {
        val bundle = Bundle()
        bundle.putString(ARG_ID, id)
        findNavController().navigate(
            R.id.action_coinMonitoringFragment_to_selectedCoinFragment,
            bundle
        )
    }

    private fun handleNavigation(navigation: CoinMonitoringViewModel.Navigation) {
        when (navigation) {
            is CoinMonitoringViewModel.Navigation.ToDetailedFragment -> {
                navigateToDetailedScreen(navigation.id)
            }
        }
    }
}
