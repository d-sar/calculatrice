package com.example.calculatrice



import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.*

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: EditText
    private var lastNumeric = false
    private var lastDot = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.result)
    }

    fun onDigit(view: View) {
        resultTextView.append((view as Button).text)
        lastNumeric = true
    }

    fun onClear(view: View) {
        resultTextView.text = Editable.Factory.getInstance().newEditable("")
        lastNumeric = false
        lastDot = false
    }

    fun onDecimalPoint(view: View) {
        if (lastNumeric && !lastDot) {
            resultTextView.append(".")
            lastNumeric = false
            lastDot = true
        }
    }

    fun onOperator(view: View) {
        if (lastNumeric && !isOperatorAdded(resultTextView.text.toString())) {
            resultTextView.append((view as Button).text)
            lastNumeric = false
            lastDot = false
        }
    }

    fun onEqual(view: View) {
        if (lastNumeric) {
            var value = resultTextView.text.toString()
            try {
                if (value.contains("-")) {
                    val splitValue = value.split("-")
                    var one = splitValue[0]
                    val two = splitValue[1]
                    if (one.isEmpty()) {
                        one = "0"
                    }
                    value = (one.toDouble() - two.toDouble()).toString()
                } else if (value.contains("+")) {
                    val splitValue = value.split("+")
                    val one = splitValue[0]
                    val two = splitValue[1]
                    value = (one.toDouble() + two.toDouble()).toString()
                } else if (value.contains("/")) {
                    val splitValue = value.split("/")
                    val one = splitValue[0]
                    val two = splitValue[1]
                    value = (one.toDouble() / two.toDouble()).toString()
                } else if (value.contains("*")) {
                    val splitValue = value.split("*")
                    val one = splitValue[0]
                    val two = splitValue[1]
                    value = (one.toDouble() * two.toDouble()).toString()
                }
                resultTextView.setText(removeZeroAfterDot(value))
            } catch (e: ArithmeticException) {
                e.printStackTrace()
            }
        }
    }

    // Fonctions scientifiques
    fun onSin(view: View) {
        if (lastNumeric) {
            val value = resultTextView.text.toString().toDouble()
            val result = sin(Math.toRadians(value)) // Convertir en radians
            resultTextView.setText(removeZeroAfterDot(result.toString()))
        }
    }

    fun onCos(view: View) {
        if (lastNumeric) {
            val value = resultTextView.text.toString().toDouble()
            val result = cos(Math.toRadians(value)) // Convertir en radians
            resultTextView.setText(removeZeroAfterDot(result.toString()))
        }
    }

    fun onTan(view: View) {
        if (lastNumeric) {
            val value = resultTextView.text.toString().toDouble()
            val result = tan(Math.toRadians(value)) // Convertir en radians
            resultTextView.setText(removeZeroAfterDot(result.toString()))
        }
    }

    fun onLog(view: View) {
        if (lastNumeric) {
            val value = resultTextView.text.toString().toDouble()
            val result = log10(value)
            resultTextView.setText(removeZeroAfterDot(result.toString()))
        }
    }

    fun onSqrt(view: View) {
        if (lastNumeric) {
            val value = resultTextView.text.toString().toDouble()
            val result = sqrt(value)
            resultTextView.setText(removeZeroAfterDot(result.toString()))
        }
    }

    private fun removeZeroAfterDot(value: String): String {
        var res = value
        if (value.contains(".0")) {
            res = value.substring(0, value.length - 2)
        }
        return res
    }

    private fun isOperatorAdded(value: String): Boolean {
        return if (value.startsWith("-")) {
            false
        } else {
            value.contains("/") || value.contains("*") || value.contains("+") || value.contains("-")
        }
    }

    fun onBackspace(view: View) {
        val value = resultTextView.text.toString()
        if (value.isNotEmpty()) {
            resultTextView.text = Editable.Factory.getInstance().newEditable(value.substring(0, value.length - 1))
        }
    }
}