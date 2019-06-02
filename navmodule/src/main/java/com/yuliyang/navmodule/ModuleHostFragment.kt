package com.yuliyang.navmodule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import kotlinx.android.synthetic.main.fragment_module_host.*

class ModuleHostFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_module_host, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        println("${javaClass.simpleName}onViewCreated")
        super.onViewCreated(view, savedInstanceState)
        jumpToAppDestA.setOnClickListener {
            findNavController(it).navigate(R.id.action_mudule_to_app)
        }
    }
}