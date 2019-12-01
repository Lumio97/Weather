package com.example.dssd.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dssd.R
import kotlinx.android.synthetic.main.fragment_search.*

class FirstFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Press.setOnClickListener {
            fragmentManager?.beginTransaction()
                ?.add(R.id.container, SecondFrragment())
                ?.addToBackStack(null)
                ?.commit()
        }

    }

}