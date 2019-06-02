package com.yuliyang.navigator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.navGraphViewModels
import kotlinx.android.synthetic.main.fragment_list_share_vm.*

class ListShareGraphVMFragment : Fragment() {

    val viewModel: GraphShareViewModel
            by navGraphViewModels(R.id.nav_list)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list_share_vm, container, false)
    }

    override fun onResume() {
        super.onResume()
        viewModel.shareValue.observe(this, Observer {
            it?.apply {
                shareVM.text = this
            }
        })

    }
}