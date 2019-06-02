package com.yuliyang.navigator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_desta.*

class DestAFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_desta, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("${javaClass.simpleName}onViewCreated")
        jumpToDestB.setOnClickListener {
            findNavController().navigate(R.id.action_destAFragment_to_destBFragment)
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