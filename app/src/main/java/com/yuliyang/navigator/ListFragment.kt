package com.yuliyang.navigator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import kotlinx.android.synthetic.main.fragment_list.*

/**
 * 1:NavControllerViewModel 这个管理所有NavBackStackEntry,并在clear的时候进行清理，这个owner是Activity
 * 2:每个NavBackStackEntry是一个ViewModelStore,并在NavControllerViewModel中管理
 */
class ListFragment : Fragment() {

    //viewModelStoreOwner获取的是backQueue的根NavBackStackEntry
    val viewModel: GraphShareViewModel by navGraphViewModels(R.id.nav_list)

    //viewModelStoreOwner获取的是fragmentManager的
    val viewModel2: GraphShareViewModel by viewModels()

    //viewModelStoreOwner获取的是当前BackStackEntry，不同于根
    val viewModel3: GraphShareViewModel by viewModels(ownerProducer = {
        findNavController().currentBackStackEntry as ViewModelStoreOwner
    })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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
        println(viewModel.hashCode())
        println(viewModel2.hashCode())
        println(viewModel3.hashCode())
        viewModel.shareValue.postValue("ShareGraph")
    }
}