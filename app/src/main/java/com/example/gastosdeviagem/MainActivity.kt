package com.example.gastosdeviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        supportActionBar!!.hide()

        buttonCalculate.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val id = v.id
        if (id == R.id.buttonCalculate) {
            calculate()
        }
    }

    private fun calculate() {

        if (validationOk()) {

            try {

                val distance = valueDistance.text.toString().toFloat()
                val price = valuePrice.text.toString().toFloat()
                val autonomy = valueAutonomy.text.toString().toFloat()

                val totalValue = (distance * price) / autonomy
                textTotalValues.text = "R$ ${"%.2f".format(totalValue)}"

            } catch (execoes: NumberFormatException) {

                Toast.makeText(this, getString(R.string.notificcampos), Toast.LENGTH_LONG).show()

            }

        }

        Toast.makeText(this, getString(R.string.valoresValidos), Toast.LENGTH_LONG).show()

    }

    private fun validationOk(): Boolean = (
        valueDistance.text.toString() != "" &&
        valueAutonomy.text.toString() != "" &&
        valuePrice.text.toString()    != "" &&
        valuePrice.text.toString()    != "0" &&
        valueDistance.text.toString() != "0" &&
        valueAutonomy.text.toString() != "0")

}