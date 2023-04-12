package com.example.redbluefragments

import androidx.lifecycle.ViewModel

class SurveyViewModel: ViewModel() {

    private var countA = 0
    private var countB = 0
//Make vars for each count
    fun addCountA() {
        countA++
    }

    fun getCountA(): Int {
        return countA
    }
//Make functions to add one to each count and to get each count
    fun addCountB() {
        countB++
    }

    fun getCountB(): Int {
        return countB
    }
//Make a function to reset each count to 0
    fun reset() {
        countA = 0
        countB = 0
    }
}