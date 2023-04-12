package com.example.surveyWithFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import com.example.redbluefragments.R

class SurveyFragment : Fragment() {

    private lateinit var choiceAButton: Button
    private lateinit var choiceBButton: Button
//Declare your vars for components and viewmodel
    private val surveyViewModel: SurveyViewModel by lazy {
        ViewModelProvider(requireActivity()).get(SurveyViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//Inflate the necessary components
        val view = inflater.inflate(R.layout.survey_fragment, container, false)

        choiceAButton = view.findViewById(R.id.choice_a_button)
        choiceBButton = view.findViewById(R.id.choice_b_button)

        choiceAButton.setOnClickListener {
            addToCountA()
        }
//Add click listeners for choice A and choice B
        choiceBButton.setOnClickListener {
            addToCountB()
        }

        return view
    }

    private fun addToCountA() {
        surveyViewModel.addCountA()
    }
//Make functions to add to each count using the viewmodel
    private fun addToCountB() {
        surveyViewModel.addCountB()
    }

    companion object {
//Survey fragment object instance
        @JvmStatic
        fun newInstance() = SurveyFragment()
    }
}

