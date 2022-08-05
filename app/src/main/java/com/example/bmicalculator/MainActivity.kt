package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bmicalculator.databinding.ActivityMainBinding

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
    }
}