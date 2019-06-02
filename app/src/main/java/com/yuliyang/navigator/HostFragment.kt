package com.yuliyang.navigator

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDeepLinkBuilder
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_host.*

/**
 * 跳转过程中生命周期和普通Activity,Fragment切换一样
 */
class HostFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_host, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        println("${javaClass.simpleName}onViewCreated")
        super.onViewCreated(view, savedInstanceState)
        jumpToDestA.setOnClickListener {
            findNavController().navigate(R.id.action_hostFragment_to_destAFragment)
        }
        jumpToModele.setOnClickListener {
            findNavController().navigate(R.id.action_hostFragment_to_module_nav_graph)
        }
        profileFragment.setOnClickListener {
            findNavController().navigate(R.id.action_hostFragment_to_profileFragment)
        }
        variableFragment.setOnClickListener {
            findNavController().navigate(NavGraphDirections.actionGlobalLoginFragment("18233335555"))
        }
        deepLinkExplicit.setOnClickListener {
            //            val pendingIntent = NavDeepLinkBuilder(requireActivity())
//                    .setGraph(R.navigation.deep_link_graph)
//                    .setDestination(R.id.deepLinkFragment)
//                    .setArguments(bundleOf("name" to "yuliyang"))
//                    .createPendingIntent()
            findNavController().navigate(Uri.parse("obj://com.yly.deeplink/lx"))
        }
        shareView.setOnClickListener {
            //            findNavController().navigate(R.id.action_hostFragment_to_shareElementFragment)
            val extras = FragmentNavigatorExtras(
                    shareView to "share")
            findNavController().navigate(R.id.action_hostFragment_to_shareElementFragment,
                    null, // Bundle of args
                    null, // NavOptions
                    extras)
        }
    }

    override fun onResume() {
        super.onResume()
        println("${javaClass.simpleName}onResume")
    }

    override fun onPause() {
        super.onPause()
        println("${javaClass.simpleName}onPause")
    }

    override fun onStop() {
        super.onStop()
        println("${javaClass.simpleName}onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("${javaClass.simpleName}onDestroy")
    }
}