package com.yuliyang.navigator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import kotlinx.android.synthetic.main.fragment_list_share_vm.*

class ListShareGraphVMFragment : Fragment() {

    val viewModel: GraphShareViewModel by navGraphViewModels(R.id.nav_list)

    val viewModel2: GraphShareViewModel by viewModels()

    val viewModel3: GraphShareViewModel by viewModels(ownerProducer = {
        findNavController().currentBackStackEntry as ViewModelStoreOwner
    })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_share_vm, container, false)
    }

    override fun onResume() {
        super.onResume()
        println(viewModel.hashCode())
        println(viewModel2.hashCode())
        println(viewModel3.hashCode())
        viewModel.shareValue.observe(this, Observer {
            it?.apply {
                shareVM.text = this
            }
        })

    }
}