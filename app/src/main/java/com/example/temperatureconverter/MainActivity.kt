package com.example.temperatureconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.temperatureconverter.databinding.ActivityMainBinding

class ActivityMain : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.convertButton.setOnClickListener { fahrenheitCelcius() }
    }

    private fun fahrenheitCelcius() {
        val stringInTextField = binding.temperatureInput.text.toString()
        val temperature = stringInTextField.toDouble()
        if(temperature == null){
            binding.resultText.text = ""
            return
        }
        val celciusTemp = temperature + 32/1.8
        val fahrTemp = temperature -32 / 1.8
        val kelvTemp = temperature + 273

        when (binding.temperatureOptions.checkedRadioButtonId) {
            R.id.option_degree_celcius -> {
                binding.resultText.text = celciusTemp.toString()
            }
            R.id.option_degree_fahrenheit -> {
                 binding.resultText.text = fahrTemp.toString()
            }
            else -> {
                binding.resultText.text = kelvTemp.toString()
            }
        }
    }
}