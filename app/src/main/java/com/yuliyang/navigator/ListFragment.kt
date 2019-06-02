package com.yuliyang.navigator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment : Fragment() {

    val viewModel: GraphShareViewModel
            by navGraphViewModels(R.id.nav_list)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        testShareVM.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_listShareGraphVMFragment)
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.shareValue.postValue("ShareGraph")
    }
}