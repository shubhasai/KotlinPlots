package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentPiechartBinding
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.MPPointF


class PiechartFragment : Fragment() {
    private lateinit var binding: FragmentPiechartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPiechartBinding.inflate(layoutInflater)
        plotpiechart()
        return binding.root
    }

    fun plotpiechart(){
        val noGiven = ArrayList<PieEntry>()
        noGiven.add(PieEntry(40f,"Fourty"))
        noGiven.add(PieEntry(30f,"Thirty"))
        noGiven.add(PieEntry(20f,"Twenty"))
        noGiven.add(PieEntry(10f,"Ten"))

        val dataSet = PieDataSet(noGiven,"NUMBERS")
        dataSet.setDrawIcons(false)
        dataSet.sliceSpace = 3f
        dataSet.iconsOffset = MPPointF(0F, 40F)
        dataSet.selectionShift = 5f

        val data = PieData(dataSet)
        data.setValueTextSize(16f)
        data.setValueTextColor(Color.WHITE)
        binding.piechart.data = data
        binding.piechart.highlightValues(null)
        binding.piechart.invalidate()
        binding.piechart.description.text= "Pie Chart"
        binding.piechart.animateXY(5000, 5000)
    }
}