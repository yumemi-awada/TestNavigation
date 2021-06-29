package com.example.testscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel

    private val args: HomeFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.title = "Home"

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        root.findViewById<TextView>(R.id.text_count1).text = "ViewModel Count: ${viewModel.count.value}"
        root.findViewById<TextView>(R.id.text_count2).text = "Argument Count: ${args.count}"
        viewModel.setCount(args.count)

        root.findViewById<View>(R.id.button_open).setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToHome2Fragment(0))
        }

        root.findViewById<View>(R.id.button_next).setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentSelf(args.count + 1))
        }

        root.findViewById<View>(R.id.button_back).setOnClickListener {
            findNavController().popBackStack()
        }

        return root
    }
}
