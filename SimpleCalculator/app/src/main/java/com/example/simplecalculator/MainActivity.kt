package com.example.simplecalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var txtResult: TextView
    lateinit var btnZero: Button
    lateinit var btnOne: Button
    lateinit var btnTwo: Button
    lateinit var btnThree: Button
    lateinit var btnFour: Button
    lateinit var btnFive: Button
    lateinit var btnSix: Button
    lateinit var btnSeven: Button
    lateinit var btnEight: Button
    lateinit var btnNine: Button
    lateinit var btnClear: Button
    lateinit var btnSign: Button
    lateinit var btnDot: Button
    lateinit var btnPlus: Button
    lateinit var btnMinus: Button
    lateinit var btnMultiply: Button
    lateinit var btnDivision: Button
    lateinit var btnRatio: Button
    lateinit var btnEquals: Button
    var operator: String = ""       //연산자 저장
    var operand: String = ""        //피연산자 저장
    var calculationResult: Double = 0.0  //이전 계산 결과 저장

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        setOnClicks()
    }

    override fun onClick(v: View) {
        var result: String = txtResult.text.toString()
        if (result.compareTo("0") == 0 && operand.isEmpty()) {
            operand = ""
        }

        when (v.id) {
            R.id.btn_zero -> if (operand.isNotEmpty()) {
                operand += "0"
                if (operand.contains(".")) {
                    var operandDecimal: String = operand.split(".")[0]
                    var belowDecimalPoint: String = operand.split(".")[1]
                    txtResult.text = Util.setNumberFormat(operandDecimal, v.context) + "." + belowDecimalPoint
                } else {
                    txtResult.text = Util.setNumberFormat(operand, v.context)
                }
            } else {
                txtResult.text = "0"
            }
            R.id.btn_one -> {
                operand += "1"
                txtResult.text = Util.setNumberFormat(operand, v.context)
            }
            R.id.btn_two -> {
                operand += "2"
                txtResult.text = Util.setNumberFormat(operand, v.context)
            }
            R.id.btn_three -> {
                operand += "3"
                txtResult.text = Util.setNumberFormat(operand, v.context)
            }
            R.id.btn_four -> {
                operand += "4"
                txtResult.text = Util.setNumberFormat(operand, v.context)
            }
            R.id.btn_five -> {
                operand += "5"
                txtResult.text = Util.setNumberFormat(operand, v.context)
            }
            R.id.btn_six -> {
                operand += "6"
                txtResult.text = Util.setNumberFormat(operand, v.context)
            }
            R.id.btn_seven -> {
                operand += "7"
                txtResult.text = Util.setNumberFormat(operand, v.context)
            }
            R.id.btn_eight -> {
                operand += "8"
                txtResult.text = Util.setNumberFormat(operand, v.context)
            }
            R.id.btn_nine -> {
                operand += "9"
                txtResult.text = Util.setNumberFormat(operand, v.context)
            }
            R.id.btn_clear -> {
                operator = ""
                operand = ""
                txtResult.text = "0"
                calculationResult = 0.0
            }
            R.id.btn_sign -> if (operand.isNotEmpty()) {
                if (operand.contains(".")) {
                    var operandDecimal: String = operand.split(".")[0]
                    var belowDecimalPoint: String = operand.split(".")[1]
                    var result: String = (-1 * operandDecimal.toInt()).toString()
                    operand = "$result.$belowDecimalPoint"
                    txtResult.text = Util.setNumberFormat(result, v.context) + "." + belowDecimalPoint
                } else {
                    operand = (-1 * operand.toInt()).toString()
                    txtResult.text = Util.setNumberFormat(operand, v.context)
                }
            }
            R.id.btn_dot ->
                if (operand.isEmpty()) {
                    txtResult.text = "0."
                    operand = "0."
                } else {
                    txtResult.text = Util.setNumberFormat(operand, v.context) + "."
                    operand += "."
                }
            R.id.btn_plus -> {
                calculate(R.id.btn_plus)
                operator = "+"
                operand = ""
            }
            R.id.btn_minus -> {
                calculate(R.id.btn_minus)
                operator = "-"
                operand = ""
            }
            R.id.btn_multiply -> {
                calculate(R.id.btn_multiply)
                operator = "*"
                operand = ""
            }
            R.id.btn_division -> {
                calculate(R.id.btn_division)
                operator = "/"
                operand = ""
            }
            R.id.btn_ratio -> {
                calculate(R.id.btn_ratio)
                operator = "%"
                operand = ""
            }
            R.id.btn_equals -> {
                calculate(R.id.btn_equals)
                operator = "="
                operand = ""
            }
        }
    }

    private fun calculate(id: Int) {
        if (operator.isNotEmpty() && operand.isNotEmpty()) {
            when (operator) {
                "+" -> calculationResult += operand.toDouble()
                "-" -> calculationResult -= operand.toDouble()
                "*" -> calculationResult *= operand.toDouble()
                "/" -> calculationResult /= operand.toDouble()
                "%" -> calculationResult %= operand.toDouble()
            }
            txtResult.text = Util.setNumberFormat(calculationResult.toString(), applicationContext)
        } else if (operand.isNotEmpty() && id != R.id.btn_equals) {
            calculationResult = operand.toDouble()
        }
    }

    private fun initView() {
        txtResult = findViewById(R.id.txt_result)
        btnZero = findViewById(R.id.btn_zero)
        btnOne = findViewById(R.id.btn_one)
        btnTwo = findViewById(R.id.btn_two)
        btnThree = findViewById(R.id.btn_three)
        btnFour = findViewById(R.id.btn_four)
        btnFive = findViewById(R.id.btn_five)
        btnSix = findViewById(R.id.btn_six)
        btnSeven = findViewById(R.id.btn_seven)
        btnEight = findViewById(R.id.btn_eight)
        btnNine = findViewById(R.id.btn_nine)
        btnClear = findViewById(R.id.btn_clear)
        btnSign = findViewById(R.id.btn_sign)
        btnDot = findViewById(R.id.btn_dot)
        btnPlus = findViewById(R.id.btn_plus)
        btnMinus = findViewById(R.id.btn_minus)
        btnMultiply = findViewById(R.id.btn_multiply)
        btnDivision = findViewById(R.id.btn_division)
        btnRatio = findViewById(R.id.btn_ratio)
        btnEquals = findViewById(R.id.btn_equals)
    }

    private fun setOnClicks() {
        btnZero.setOnClickListener(this)
        btnOne.setOnClickListener(this)
        btnTwo.setOnClickListener(this)
        btnThree.setOnClickListener(this)
        btnFour.setOnClickListener(this)
        btnFive.setOnClickListener(this)
        btnSix.setOnClickListener(this)
        btnSeven.setOnClickListener(this)
        btnEight.setOnClickListener(this)
        btnNine.setOnClickListener(this)
        btnClear.setOnClickListener(this)
        btnSign.setOnClickListener(this)
        btnDot.setOnClickListener(this)
        btnPlus.setOnClickListener(this)
        btnMinus.setOnClickListener(this)
        btnMultiply.setOnClickListener(this)
        btnDivision.setOnClickListener(this)
        btnRatio.setOnClickListener(this)
        btnEquals.setOnClickListener(this)
    }
}
