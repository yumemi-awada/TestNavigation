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

class Home2Fragment : Fragment() {

    private lateinit var viewModel: Home2ViewModel

    private val args: Home2FragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.title = "Home2"

        viewModel = ViewModelProvider(this).get(Home2ViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home2, container, false)

        root.findViewById<TextView>(R.id.text_count1).text = "ViewModel Count: ${viewModel.count.value}"
        root.findViewById<TextView>(R.id.text_count2).text = "Argument Count: ${args.count}"
        viewModel.setCount(args.count)

        root.findViewById<View>(R.id.button_open).setOnClickListener {
            findNavController().navigate(Home2FragmentDirections.actionHome2FragmentSelf(args.count + 1))
        }

        root.findViewById<View>(R.id.button_back).setOnClickListener {
            findNavController().popBackStack()
        }

        root.findViewById<View>(R.id.button_back2).setOnClickListener {
            findNavController().popBackStack()
            findNavController().popBackStack()
        }

        root.findViewById<View>(R.id.button_close).setOnClickListener {
            findNavController().popBackStack(R.id.homeFragment, false)
            // アニメーションがおかしくなるので対応する
            // https://qiita.com/links_2_3_4/items/3d1908ba0472da5ee734
        }

        root.findViewById<View>(R.id.button_open2).setOnClickListener {
            findNavController().navigate(Home2FragmentDirections.actionHome2FragmentToHomeFragment(100))

        }

        return root
    }
}
