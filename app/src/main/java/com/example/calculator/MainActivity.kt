package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.ln
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    var inputText : String = ""
    var solution = 0.0f
    var numList = mutableListOf<String>()
    var operationList = mutableListOf<String>()
    var newNum :String = ""
    var buttonPressCount = 0

    fun onClickOneButton(view: View)
    {
        tvInputView.append("1")
        inputText += 1
    }
    fun onClickTwoButton(view: View)
    {
        tvInputView.append("2")
        inputText += 2
    }
    fun onClickThreeButton(view: View)
    {
        tvInputView.append("3")
        inputText += 3
    }
    fun onClickFourButton(view: View)
    {
        tvInputView.append("4")
        inputText += 4
    }
    fun onClickFiveButton(view: View)
    {
        tvInputView.append("5")
        inputText += 5
    }
    fun onClickSixButton(view: View)
    {
        tvInputView.append("6")
        inputText += 6
    }
    fun onClickSevenButton(view: View)
    {
        tvInputView.append("7")
        inputText += 7
    }
    fun onClickEightButton(view: View)
    {
        tvInputView.append("8")
        inputText += 8
    }
    fun onClickNineButton(view: View)
    {
        tvInputView.append("9")
        inputText += 9
    }
    fun onClickZeroButton(view: View)
    {
        tvInputView.append("0")
        inputText += 0
    }
    fun onClickDotButton(view: View)
    {
        tvInputView.append(".")
        inputText += "."
    }
    fun onClickEqualsButton(view: View)
    {
        numList.add(inputText)

        var count = 0
            while(operationList.isNotEmpty())
            {
                when
                {
                    operationList.contains("log") ->
                    {
                        when
                        {
                            operationList[count] == "log" ->
                            {
                                if(numList[count] == "")
                                {
                                    operationList.removeAt(count - 1)
                                    count = 0
                                }
                                else
                                {
                                    newNum = ln(numList[count].toDouble()).toString()
                                    operationList.removeAt(count)
                                    numList.removeAt(count)
                                    numList.add(count, newNum)
                                    count = 0
                                }
                            }
                            else -> count++
                        }
                    }
                    operationList.contains("√") ->
                    {
                        when
                        {
                            operationList[count] == "√" ->
                            {
                                if(numList[count] == "")
                                {
                                    operationList.removeAt(count - 1)
                                    count = 0
                                }
                                else
                                {
                                    newNum = sqrt(numList[count].toDouble()).toString()
                                    operationList.removeAt(count)
                                    numList.removeAt(count)
                                    numList.add(count, newNum)
                                    count = 0
                                }
                            }
                            else ->count++
                        }
                    }
                    operationList.contains("^2") ->
                    {
                        when
                        {
                            operationList[count] == "^2" ->
                            {
                                if(numList[count] == "")
                                {
                                    operationList.removeAt(count - 1)
                                    count = 0
                                }
                                else
                                {
                                    newNum = Math.pow(numList[count].toDouble(), 2.0).toString()
                                    operationList.removeAt(count)
                                    numList.removeAt(count)
                                    numList.add(count, newNum)
                                    count = 0
                                }
                            }
                            else ->count++
                        }
                    }
                    operationList.contains("^") ->
                    {
                        when
                        {
                            operationList[count] == "^" ->
                            {
                                newNum = numList[count].toDouble().pow(numList[count + 1].toDouble()).toString()
                                operationList.removeAt(count)
                                numList.removeAt(count)
                                numList.removeAt(count)
                                numList.add(count, newNum)
                                count = 0
                            }
                            else -> count++
                        }
                    }
                    operationList.contains("x") ->
                    {
                        when
                        {
                            operationList[count] == "x" -> {
                                newNum = (numList[count].toFloat() * numList[count + 1].toFloat()).toString()
                                operationList.removeAt(count)
                                numList.removeAt(count)
                                numList.removeAt(count)
                                numList.add(count, newNum)
                                count = 0

                            }
                            else -> count++
                        }
                    }
                    operationList.contains("/") ->
                    {
                        when
                        {
                            operationList[count] == "/" ->
                            {
                                newNum = (numList[count].toFloat() / numList[count + 1].toFloat()).toString()
                                operationList.removeAt(count)
                                numList.removeAt(count)
                                numList.removeAt(count)
                                numList.add(count, newNum)
                                count = 0
                            }
                            else -> count++
                        }
                    }
                    operationList.contains("+") ->
                    {
                        when
                        {
                            operationList[count] == "+" ->
                            {
                                newNum = (numList[count].toFloat() + numList[count + 1].toFloat()).toString()
                                operationList.removeAt(count)
                                numList.removeAt(count)
                                numList.removeAt(count)
                                numList.add(count, newNum)
                                count = 0

                            }
                            else -> count++
                        }
                    }
                    operationList.contains("-") ->
                    {
                        when
                        {
                            operationList[count] == "-" ->
                            {
                                newNum = (numList[count].toFloat() - numList[count + 1].toFloat()).toString()
                                operationList.removeAt(count)
                                numList.removeAt(count)
                                numList.removeAt(count)
                                numList.add(count, newNum)
                                count = 0
                            }
                            else -> count++
                        }
                    }
                }
            }
        solution = numList[0].toFloat()
        tvOutputView.text = solution.toString()
        count = 0

    }
    fun onClickPlusButton(view: View)
    {
        operationList.add("+")
        numList.add(inputText)
        buttonPressCount ++
        inputText = ""
        tvInputView.append(" + ")

    }
    fun onClickMinusButton(view: View)
    {
        operationList.add("-")
        numList.add(inputText)
        buttonPressCount ++
        inputText = ""
        tvInputView.append(" - ")
    }
    fun onClickMultiplyButton(view: View)
    {
        operationList.add("x")
        numList.add(inputText)
        buttonPressCount ++
        inputText = ""
        tvInputView.append(" x ")
    }
    fun onClickDivideButton(view: View)
    {
        operationList.add("/")
        numList.add(inputText)
        buttonPressCount ++
        inputText = ""
        tvInputView.append(" / ")
    }
    fun onClickSquareRootButton(view: View)
    {
        when {
            numList.count() == 0 ->
            {
                operationList.add("√")
                numList.add(inputText)
                buttonPressCount++
            }
            else ->
            {
                operationList.add("x")
                operationList.add("√")
                numList.add(inputText)
                buttonPressCount ++
            }
        }
        inputText = ""
        tvInputView.append(" √ ")
    }
    fun onClickSquareButton(view: View)
    {
        when
        {
            numList.count() == 0 ->
            {
                operationList.add("^2")
                numList.add(inputText)
                buttonPressCount ++
            }
            else ->
            {
                operationList.add("x")
                operationList.add("^2")
                numList.add(inputText)
                buttonPressCount++
            }
        }
        inputText = ""
        tvInputView.append(" ^2 ")
    }
    fun onClickLogButton(view: View)
    {
        Log.d("TAG", numList.count().toString())
        operationList.add("x")
        operationList.add("log")
        numList.add(inputText)
        buttonPressCount ++
        inputText = ""
        tvInputView.append(" ln ")
    }
    fun onClickPowButton(view: View)
    {
        operationList.add("^")
        numList.add(inputText)
        buttonPressCount ++
        inputText = ""
        tvInputView.append(" ^ ")
    }

    fun onClickClear(view: View)
    {
        numList.clear()
        operationList.clear()
        tvInputView.text = ""
        tvOutputView.text = ""
        inputText = ""
        solution = 0.0f
        buttonPressCount = 0
    }
}
