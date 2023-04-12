package com.example.redbluefragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class ResultsFragment : Fragment() {

    private lateinit var countATextView: TextView
    private lateinit var countBTextView: TextView
    private lateinit var resetButton: Button

    private val surveyViewModel: SurveyViewModel by lazy {
        ViewModelProvider(requireActivity()).get(SurveyViewModel::class.java)
    }
//Declare your components
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//Inflate everything you need and set the count value and click listener for the button
        val view = inflater.inflate(R.layout.results_fragment, container, false)
        countATextView = view.findViewById(R.id.results_count_a_textview)
        countBTextView = view.findViewById(R.id.results_count_b_textview)
        resetButton = view.findViewById(R.id.reset_button)
        countATextView.text = surveyViewModel.getCountA().toString()
        countBTextView.text = surveyViewModel.getCountB().toString()
        resetButton.setOnClickListener {
            reset()
        }
        return view
    }
//Create the reset function to use the viewmodel reset function and set the textviews using the viewmodel get functions
    private fun reset() {
        surveyViewModel.reset()
        countATextView.text = surveyViewModel.getCountA().toString()
        countBTextView.text = surveyViewModel.getCountB().toString()
    }

    companion object {
//Where the new instance of this fragment is created
        @JvmStatic
        fun newInstance() = ResultsFragment()
    }
}