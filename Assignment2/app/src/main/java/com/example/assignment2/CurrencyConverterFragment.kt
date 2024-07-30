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
    private lateinit var radioGroup: RadioGroup

    private lateinit var radioUsd: RadioButton
    private lateinit var radioEur: RadioButton
    private lateinit var radioJpy: RadioButton
    // Add more RadioButton references if needed

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.currency_fragment, container, false)

        inputEditText = view.findViewById(R.id.inputEditText)
        outputTextView = view.findViewById(R.id.outputTextView)
        convertButton = view.findViewById(R.id.convertButton)
        currencySpinnerFrom = view.findViewById(R.id.currencySpinnerFrom)
        radioGroup = view.findViewById(R.id.radioGroup)

        radioUsd = view.findViewById(R.id.radio_usd)
        radioEur = view.findViewById(R.id.radio_eur)
        radioJpy = view.findViewById(R.id.radio_jpy)
        // Initialize other RadioButtons if needed

        convertButton.setOnClickListener {
            it.startAnimation(AnimationUtils.loadAnimation(context, R.anim.button_click))
            val input = inputEditText.text.toString().toDoubleOrNull()
            val selectedCurrency = when (radioGroup.checkedRadioButtonId) {
                R.id.radio_usd -> "USD"
                R.id.radio_eur -> "EUR"
                R.id.radio_jpy -> "JPY"
                else -> null
            }

            if (input != null && selectedCurrency != null) {
                val result = convertCurrency(input, selectedCurrency)
                outputTextView.text = result?.toString() ?: getString(R.string.invalid_input)
            } else {
                outputTextView.text = getString(R.string.invalid_input)
            }
        }

        return view
    }

    private fun convertCurrency(amount: Double, currency: String): Double? {
        // Implement your currency conversion logic here
        // Example conversion logic (replace with actual rates):
        return when (currency) {
            "USD" -> amount * 1.0
            "EUR" -> amount * 0.9
            "JPY" -> amount * 153.0
            else -> null
        }
    }
}