package com.example.calcutorbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var lastnumeric: Boolean = false
    var lastdot: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onDigit(view: View) {
        tvinput.append((view as Button).text)
        lastnumeric = true
        if (tvinput.text.contains("")) {
        }


    }

    fun onClear(view: View) {
        tvinput.text = ""
        lastnumeric = false
        lastdot = false
    }

    fun ondecimalpoint(view: View) {
        if (lastnumeric && !lastdot) {
            tvinput.append(".")
            lastnumeric = false
            lastdot = true
        }
    }

    fun onequal(view: View) {
        if (lastnumeric) {
            lastdot =true
            var prefix = ""
            var tvvalue = tvinput.text.toString()
            if (tvvalue.startsWith("-")) {
                prefix = "-"
                tvvalue = tvvalue.substring(1)
            }
            if (tvvalue.contains("-")) {
                val splitvalue = tvvalue.split("-")
                var one = splitvalue[0]
                var two = splitvalue[1]
                if (!prefix.isEmpty()) {
                    one = prefix + one
                }
                tvinput.text = (one.toDouble() - two.toDouble()).toString()

            } else if ((tvvalue.contains("+"))) {
                val splitvalue = tvvalue.split("+")
                var one = splitvalue[0]
                var two = splitvalue[1]
                if (!prefix.isEmpty()) {
                    one = prefix + one
                }
                tvinput.text = (one.toDouble() + two.toDouble()).toString()
            } else if ((tvvalue.contains("×"))) {
                val splitvalue = tvvalue.split("×")
                var one = splitvalue[0]
                var two = splitvalue[1]
                if (!prefix.isEmpty()) {
                    one = prefix + one
                }
                tvinput.text = (one.toDouble() * two.toDouble()).toString()

            } else if ((tvvalue.contains("÷"))) {
                val splitvalue = tvvalue.split("÷")
                var one = splitvalue[0]
                var two = splitvalue[1]
                if (!prefix.isEmpty()) {
                    one = prefix + one
                }
                tvinput.text = (one.toDouble() /two.toDouble()).toString()
            }
        }}
        fun onoperato(view: View) {
            if (lastnumeric && !isoperatoradded(tvinput.text.toString())) {
                tvinput.append((view as Button).text)
                lastnumeric = false
                lastdot = false
            }
        }



    fun isoperatoradded(value: String): Boolean {
        return if (value.startsWith("-")) {
            false
        } else {
            value.contains("÷") || value.contains("×") || value.contains("+") || value.contains("-")

        }

    }

}
