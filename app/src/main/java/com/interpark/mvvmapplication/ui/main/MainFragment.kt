package com.interpark.mvvmapplication.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import com.interpark.mvvmapplication.R
import com.interpark.mvvmapplication.core.BindingFragment
import com.interpark.mvvmapplication.databinding.FragmentMainBinding

class MainFragment(private val viewModel: AddressViewModel) : BindingFragment<FragmentMainBinding>() {

    @LayoutRes
    override fun getLayoutResId() = R.layout.fragment_main

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    fun onClick(view: View) {
        Toast.makeText(context, "click!!!", Toast.LENGTH_SHORT).show()
    }
}