package com.santy.mvvmprueba.View.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment

class SwipeFragment : Fragment() {
    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String) =
                SwipeFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}