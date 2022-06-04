package com.example.myapplication

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.myapplication.databinding.FragmentBargraphBinding
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

class BargraphFragment : Fragment() {
    private lateinit var binding:FragmentBargraphBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBargraphBinding.inflate(layoutInflater)
        setLineChartdata("jan")
        binding.jan.setOnClickListener {
            setLineChartdata("jan")
        }
        binding.feb.setOnClickListener {
            setLineChartdata("feb")
        }
        binding.mar.setOnClickListener {
            setLineChartdata("mar")
        }
        binding.apr.setOnClickListener {
            setLineChartdata("apr")
        }
        binding.may.setOnClickListener {
            setLineChartdata("may")
        }
        binding.june.setOnClickListener {
            setLineChartdata("june")
        }
        binding.jul.setOnClickListener {
            setLineChartdata("jul")
        }
        binding.aug.setOnClickListener {
            setLineChartdata("aug")
        }
        binding.sep.setOnClickListener {
            setLineChartdata("sep")
        }
        binding.oct.setOnClickListener {
            setLineChartdata("oct")
        }
        binding.nov.setOnClickListener {
            setLineChartdata("nov")
        }
        binding.dec.setOnClickListener {
            setLineChartdata("dec")
        }
        return binding.root
    }

    fun setLineChartdata(month: String){
        var days = 31
        when(month){
            "jan"-> {
                days = 31
                Toast.makeText(activity as Context,month,Toast.LENGTH_SHORT).show()
                setdata(days)
            }
            "feb"-> {
                Toast.makeText(activity as Context,month,Toast.LENGTH_SHORT).show()
                days = 28
                setdata(days)
            }
            "mar"-> {
                Toast.makeText(activity as Context,month,Toast.LENGTH_SHORT).show()
                days = 31
                setdata(days)
            }
            "apr"-> {
                Toast.makeText(activity as Context,month,Toast.LENGTH_SHORT).show()
                days = 30
                setdata(days)
            }
            "may"-> {
                Toast.makeText(activity as Context,month,Toast.LENGTH_SHORT).show()
                days = 31
                setdata(days)
            }
            "june"-> {
                Toast.makeText(activity as Context,month,Toast.LENGTH_SHORT).show()
                days = 30
                setdata(days)
            }
            "jul"-> {
                Toast.makeText(activity as Context,month,Toast.LENGTH_SHORT).show()
                days = 31
                setdata(days)
            }
            "aug"-> {
                Toast.makeText(activity as Context,month,Toast.LENGTH_SHORT).show()
                days = 31
                setdata(days)
            }
            "sep"-> {
                Toast.makeText(activity as Context,month,Toast.LENGTH_SHORT).show()
                days = 30
                setdata(days)
            }
            "oct"-> {
                Toast.makeText(activity as Context,month,Toast.LENGTH_SHORT).show()
                days = 31
                setdata(days)
            }
            "nov"-> {
                Toast.makeText(activity as Context,month,Toast.LENGTH_SHORT).show()
                days = 30
                setdata(days)
            }
            "dec"-> {
                Toast.makeText(activity as Context,month,Toast.LENGTH_SHORT).show()
                days = 31
                setdata(days)
            }
        }
    }
    fun setdata(days:Int){

        val lineentry = ArrayList<Entry>()
        for(i in 1..days){
            lineentry.add(Entry(i.toFloat(),(10..100).random().toFloat()))
        }

        val linedataset = LineDataSet(lineentry,"first")
        linedataset.color = resources.getColor(R.color.purple_200)
        linedataset.fillColor = resources.getColor(R.color.teal_200)
        binding.linechart.description.text = "Days"
        binding.linechart.data = LineData(linedataset)
        binding.linechart.animateX(1800,Easing.EaseInExpo)
    }
}