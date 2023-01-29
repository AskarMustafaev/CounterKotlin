package com.example.counterkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.counterkotlin.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private var counter: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            counter++
            binding.textView.text = counter.toString()
            if (counter == 10) {
                binding.button.text = requireContext().getString(R.string.minus_1)
                binding.button.setOnClickListener {
                    counter--
                    binding.textView.text = counter.toString()
                    if (counter == 1) {
                        binding.button.setOnClickListener {
                            transfer()
                        }
                    }
                }
            }
        }
    }

    private fun transfer() {
        val fragment = SecondFragment()
        val bundle = Bundle()
        bundle.putString("key", binding.etText.text.toString())
        fragment.arguments = bundle
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)
            .addToBackStack(null).commit()
    }
}
