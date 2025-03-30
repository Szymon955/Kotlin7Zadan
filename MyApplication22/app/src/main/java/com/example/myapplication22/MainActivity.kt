package com.example.coffeeorder

import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication22.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val coffeeImageView: ImageView = findViewById(R.id.coffeeImageView)
        val espressoRadioButton: RadioButton = findViewById(R.id.radioEspresso)
        val cappuccinoRadioButton: RadioButton = findViewById(R.id.radioCappuccino)
        val latteRadioButton: RadioButton = findViewById(R.id.radioLatte)
        val milkCheckBox: CheckBox = findViewById(R.id.checkMilk)
        val sugarCheckBox: CheckBox = findViewById(R.id.checkSugar)
        val quantitySeekBar: SeekBar = findViewById(R.id.quantitySeekBar)
        val quantityTextView: TextView = findViewById(R.id.quantityTextView)
        val orderButton: Button = findViewById(R.id.orderButton)

        val coffeeImages = mapOf(
            R.id.radioEspresso to R.drawable.espresso,
            R.id.radioCappuccino to R.drawable.capuccino,
            R.id.radioLatte to R.drawable.latte
        )

        val coffeeTypeGroup: RadioGroup = findViewById(R.id.radioGroupCoffee)
        coffeeTypeGroup.setOnCheckedChangeListener { _, checkedId ->
            coffeeImages[checkedId]?.let { coffeeImageView.setImageResource(it) }
        }

        quantitySeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                quantityTextView.text = "$progress"
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        orderButton.setOnClickListener {
            val coffeeType = when (coffeeTypeGroup.checkedRadioButtonId) {
                R.id.radioEspresso -> "Espresso"
                R.id.radioCappuccino -> "Cappuccino"
                R.id.radioLatte -> "Latte"
                else -> "Brak wyboru"
            }
            val milk = if (milkCheckBox.isChecked) "z mlekiem" else "bez mleka"
            val sugar = if (sugarCheckBox.isChecked) "z cukrem" else "bez cukru"
            val quantity = quantitySeekBar.progress

            val orderSummary = "Zamówienie: $coffeeType, $milk, $sugar, Ilość: $quantity"
            Toast.makeText(this, orderSummary, Toast.LENGTH_LONG).show()
            Log.d("CoffeeOrder", orderSummary)
        }
    }
}
