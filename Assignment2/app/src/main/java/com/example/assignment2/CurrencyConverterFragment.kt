package com.example.assignment2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import android.view.animation.AnimationUtils

class CurrencyConverterFragment : Fragment() {

    private lateinit var inputEditText: EditText
    private lateinit var outputTextView: TextView
    private lateinit var convertButton: Button
    private lateinit var currencySpinnerFrom: Spinner
    private lateinit var currencySpinnerTo: Spinner

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.currency_fragment, container, false)

        inputEditText = view.findViewById(R.id.inputEditText)
        outputTextView = view.findViewById(R.id.outputTextView)
        convertButton = view.findViewById(R.id.convertButton)
        currencySpinnerFrom = view.findViewById(R.id.currencySpinnerFrom)
        currencySpinnerTo = view.findViewById(R.id.currencySpinnerTo)

        // Assuming you have an array resource with currency codes
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.currencies,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            currencySpinnerFrom.adapter = adapter
            currencySpinnerTo.adapter = adapter
        }

        convertButton.setOnClickListener {
            it.startAnimation(AnimationUtils.loadAnimation(context, R.anim.button_click))
            val input = inputEditText.text.toString().toDoubleOrNull()
            if (input != null) {
                val fromCurrency = currencySpinnerFrom.selectedItem.toString()
                val toCurrency = currencySpinnerTo.selectedItem.toString()
                val result = convertCurrency(input, fromCurrency, toCurrency)
                outputTextView.text = result?.toString() ?: getString(R.string.invalid_input)
            } else {
                outputTextView.text = getString(R.string.invalid_input)
            }
        }

        return view
    }

    private fun convertCurrency(amount: Double, fromCurrency: String, toCurrency: String): Double? {
        // Dummy conversion rates for demonstration purposes
        val conversionRates = mapOf(
            "USD" to mapOf("EUR" to 0.85, "JPY" to 110.0),
            "EUR" to mapOf("USD" to 1.18, "JPY" to 129.0),
            "JPY" to mapOf("USD" to 0.0091, "EUR" to 0.0078)
        )
        return conversionRates[fromCurrency]?.get(toCurrency)?.let { rate ->
            amount * rate
        }
    }
}