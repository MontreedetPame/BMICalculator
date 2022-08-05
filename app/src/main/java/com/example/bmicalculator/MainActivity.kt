package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.NumberPicker
import android.widget.Toast
import com.example.bmicalculator.databinding.ActivityMainBinding
import java.math.RoundingMode
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.weightPicker.minValue = 30
        binding.weightPicker.maxValue = 150
        binding.heightPicker.minValue = 100
        binding.heightPicker.maxValue = 250
        binding.weightPicker.setOnValueChangedListener{_,_,_ ->
            calculateBMI()
        }

        binding.heightPicker.setOnValueChangedListener{_,_,_ ->
            calculateBMI()
        }
    }

    private fun calculateBMI() {
        val weight = binding.weightPicker.value;
        val height = binding.heightPicker.value;
        val doubleHeight = height.toDouble() / 100
        val bmi = weight.toDouble() / (doubleHeight * doubleHeight)
        var textHealthy:String
        if(bmi < 18.5){
            textHealthy = "UnderWeight"
        }else if(bmi < 25.0){
            textHealthy = "Healthy"
        }else if(bmi < 30.0){
            textHealthy = "OverWeight"
        }else{
            textHealthy = "Cannot show result"
        }
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.UP
        val bmiShow = df.format(bmi)
        binding.healthyTV.text = "Considered = "+textHealthy
        binding.resultsTV.text = "Your BMI = "+bmiShow
    }
}