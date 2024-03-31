package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onNumberClicked()
        onOperatorClicked()
    }

    private fun onOperatorClicked() {

        binding.btnAC.setOnClickListener {

            binding.txtExpression.text = ""

            binding.txtAnswer.text = ""

        }

        binding.btnDeleteOneNum.setOnClickListener {

            val oldText = binding.txtExpression.text.toString()

            if (oldText.isNotEmpty()) {

                binding.txtExpression.text =
                    oldText.substring(0, binding.txtExpression.length() - 1)

            }
        }

        binding.btnOpenPranthesis.setOnClickListener {
            appendText("(")
        }

        binding.btnCloseParenthesis.setOnClickListener {

            if (binding.txtExpression.text.isEmpty()) {
                Toast.makeText(this, "Invalid format used.", Toast.LENGTH_SHORT).show()
            } else {
                appendText(")")
            }
        }

        binding.btnMultiplication.setOnClickListener {

            if (binding.txtExpression.text.isEmpty()) {
                Toast.makeText(this, "Invalid format used.", Toast.LENGTH_SHORT).show()

            } else {

                val lastChar = binding.txtExpression.text.last()
                if (lastChar != '+' &&
                    lastChar != '/' &&
                    lastChar != '-' &&
                    lastChar != '*'
                ) {
                    appendText("*")
                }
            }
        }

        binding.btnDivision.setOnClickListener {

            if (binding.txtExpression.text.isEmpty()) {
                Toast.makeText(this, "Invalid format used.", Toast.LENGTH_SHORT).show()

            } else {
                val lastChar = binding.txtExpression.text.last()
                if (lastChar != '+' &&
                    lastChar != '/' &&
                    lastChar != '-' &&
                    lastChar != '*'
                ) {
                    appendText("/")
                }
            }


        }

        binding.btnMinus.setOnClickListener {

            if (binding.txtExpression.text.isEmpty()) {
                Toast.makeText(this, "Invalid format used.", Toast.LENGTH_SHORT).show()

            } else {
                val lastChar = binding.txtExpression.text.last()
                if (lastChar != '+' &&
                    lastChar != '/' &&
                    lastChar != '-' &&
                    lastChar != '*'
                ) {
                    appendText("-")
                }
            }

        }

        binding.btnSum.setOnClickListener {

            if (binding.txtExpression.text.isEmpty()) {
                Toast.makeText(this, "Invalid format used.", Toast.LENGTH_SHORT).show()

            } else {
                val lastChar = binding.txtExpression.text.last()
                if (lastChar != '+' &&
                    lastChar != '/' &&
                    lastChar != '-' &&
                    lastChar != '*'
                ) {
                    appendText("+")
                }
            }

        }

        binding.btnEqual.setOnClickListener {

            val expression = ExpressionBuilder(binding.txtExpression.text.toString()).build()
            val result = expression.evaluate()

            val longResult = result.toLong()

            //handle kardane inke khoroji ashai bashe ya addade sahih
            //135 = 135.5

            if (result == longResult.toDouble()) {

                binding.txtAnswer.text = longResult.toString()

            } else {
                //float result:  darvaghe double hast
                binding.txtAnswer.text = result.toString()
            }

        }

    }

    private fun onNumberClicked() {
        val txtAnswer = binding.txtExpression

        binding.btn0.setOnClickListener {

            //to not type multiple 0 in a row when txtAnswer is empty!
            if (txtAnswer.text.toString().isEmpty()) {
                appendText("0")

            } else if (txtAnswer.text.toString()
                    .isNotEmpty() && txtAnswer.text.toString() != "0"
            ) {
                appendText("0")

            } else if (txtAnswer.text.toString() == "0") {
                //Do nothing! :)
            }
        }

        binding.btn1.setOnClickListener {

            if (txtAnswer.text.toString().length == 1 && txtAnswer.text.toString() == "0") {

                firstChangeNum(1)

            } else {
                appendText("1")
            }
        }

        binding.btn2.setOnClickListener {

            if (txtAnswer.text.toString().length == 1 && txtAnswer.text.toString() == "0") {
                firstChangeNum(2)

            } else {
                appendText("2")
            }

        }

        binding.btn3.setOnClickListener {

            if (txtAnswer.text.toString().length == 1 && txtAnswer.text.toString() == "0") {

                firstChangeNum(3)

            } else {
                appendText("3")
            }

        }

        binding.btn4.setOnClickListener {

            if (txtAnswer.text.toString().length == 1 && txtAnswer.text.toString() == "0") {

                firstChangeNum(4)

            } else {
                appendText("4")
            }

        }

        binding.btn5.setOnClickListener {
            if (txtAnswer.text.toString().length == 1 && txtAnswer.text.toString() == "0") {

                firstChangeNum(5)

            } else {
                appendText("5")
            }

        }

        binding.btn6.setOnClickListener {
            if (txtAnswer.text.toString().length == 1 && txtAnswer.text.toString() == "0") {

                firstChangeNum(6)

            } else {
                appendText("6")
            }

        }

        binding.btn7.setOnClickListener {
            if (txtAnswer.text.toString().length == 1 && txtAnswer.text.toString() == "0") {

                firstChangeNum(7)

            } else {
                appendText("7")
            }

        }

        binding.btn8.setOnClickListener {
            if (txtAnswer.text.toString().length == 1 && txtAnswer.text.toString() == "0") {

                firstChangeNum(8)

            } else {
                appendText("8")
            }

        }

        binding.btn9.setOnClickListener {

            if (txtAnswer.text.toString().length == 1 && txtAnswer.text.toString() == "0") {

                firstChangeNum(9)

            } else {
                appendText("9")
            }

        }

        binding.btnDot.setOnClickListener {

            if (binding.txtExpression.text.isEmpty() || binding.txtAnswer.text.isNotEmpty()) {
                appendText("0.")

            } else if (!txtAnswer.text.contains(".")) {
                appendText(".")
            }

        }
    }

    private fun appendText(newText: String) {

        if (binding.txtAnswer.text.isNotEmpty()) {

            binding.txtExpression.text = ""
            binding.txtAnswer.text = ""
        }

        binding.txtExpression.append(newText)

    }

    private fun firstChangeNum(enteredNum: Int) {
        val originalText = binding.txtExpression.text.toString()
        val modifiedText = originalText.replaceFirstChar { enteredNum.toString() }
        binding.txtExpression.text = modifiedText

    }
}
