package com.example.calculatrice

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.divider.MaterialDivider
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager

class MainActivity : AppCompatActivity() {

    private  lateinit var expression: TextView
    private lateinit var result : TextView
    private lateinit var clear :Button
    private  lateinit var back:Button
    private  lateinit var dot : Button
    private  lateinit var divide:Button
    private lateinit var module : Button
    private  lateinit var multiple:Button
    private lateinit var soustraction:Button
    private lateinit var add : Button
    private lateinit var equal : Button
    private lateinit var zero : Button
    private lateinit var zerozero : Button
    private lateinit var one : Button
    private lateinit var two : Button
    private lateinit var three : Button
    private lateinit var four : Button
    private lateinit var five : Button
    private lateinit var six : Button
    private lateinit var seven : Button
    private lateinit var eight : Button
    private lateinit var nine : Button

    private lateinit var prime :Button
    private lateinit var x2 : Button
    private lateinit var xy :Button
    private lateinit var cos :Button
    private lateinit var sin :Button
    private lateinit var tan : Button
    private lateinit var sin_1 :Button
    private lateinit var cos_1 : Button
    private lateinit var tan_1 :Button
    private lateinit var log : Button
    private lateinit var ln : Button
    private lateinit var racine : Button
    private lateinit var expo : Button
    private lateinit var pi : Button
    private lateinit var vAbsolut : Button
    private lateinit var leftPare : Button
    private lateinit var rightPare : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        expression = findViewById(R.id.expression)
        result = findViewById(R.id.result)
        clear = findViewById(R.id.clear)
        back = findViewById(R.id.back)
        dot = findViewById(R.id.dot)
        divide = findViewById(R.id.divide)
        module = findViewById(R.id.module)
        multiple = findViewById(R.id.multiple)
        soustraction = findViewById(R.id.soustraction)
        add = findViewById(R.id.add)
        equal = findViewById(R.id.equal)
        zero = findViewById(R.id.zero)
        zerozero = findViewById(R.id.zerozero)
        one = findViewById(R.id.one)
        two = findViewById(R.id.two)
        three = findViewById(R.id.three)
        four = findViewById(R.id.four)
        five = findViewById(R.id.five)
        six = findViewById(R.id.six)
        seven = findViewById(R.id.seven)
        eight = findViewById(R.id.eight)
        nine = findViewById(R.id.nine)

        prime = findViewById(R.id.prime)
        x2 = findViewById(R.id.x2)
        xy = findViewById(R.id.xy)
        cos = findViewById(R.id.cos)
        sin = findViewById(R.id.sin)
        tan = findViewById(R.id.tan)
        cos_1 = findViewById(R.id.cos_1)
        sin_1 = findViewById(R.id.sin_1)
        tan_1 = findViewById(R.id.tan_1)
        log = findViewById(R.id.log)
        ln = findViewById(R.id.ln)
        racine = findViewById(R.id.racine)
        expo = findViewById(R.id.expo)
        pi = findViewById(R.id.pi)
        vAbsolut = findViewById(R.id.vAbsolut)
        leftPare = findViewById(R.id.leftPare)
        rightPare = findViewById(R.id.rightPare)

        expression.movementMethod = ScrollingMovementMethod()
        expression.isActivated = true
        expression.isPressed = true
        var str: String

        clear.setOnClickListener(){
            expressionText("0")
            expression.textSize = 60F
            result.textSize = 30F
            resultText()

        }
        back.setOnClickListener{
            if(expression.text.toString().isNotEmpty()){
                val lastIndex = expression.text.toString().lastIndex
                str = expression.text.toString().substring(0,lastIndex)
                expressionText(str)
                resultText()

            }

        }
        module.setOnClickListener{
            if (expression.text.toString().endsWith("%")||expression.text.toString().endsWith("/")||expression.text.toString().endsWith("*")||expression.text.toString().endsWith("+")||expression.text.toString().endsWith("-")||expression.text.toString().endsWith(".")){
                str = expression.text.toString()
                expressionText(str)
            }else{
                str =expression.text.toString()+"%"
                expressionText(str)

            }


        }
        divide.setOnClickListener{
            if (expression.text.toString().endsWith("%")||expression.text.toString().endsWith("/")||expression.text.toString().endsWith("*")||expression.text.toString().endsWith("+")||expression.text.toString().endsWith("-")||expression.text.toString().endsWith(".")){
                str = expression.text.toString()
                expressionText(str)
            }else{
                str =expression.text.toString()+"/"
                expressionText(str)

            }

        }
        multiple.setOnClickListener{
            if (expression.text.toString().endsWith("%")||expression.text.toString().endsWith("/")||expression.text.toString().endsWith("*")||expression.text.toString().endsWith("+")||expression.text.toString().endsWith("-")||expression.text.toString().endsWith(".")){
                str = expression.text.toString()
                expressionText(str)
            }else{
                str =expression.text.toString()+"*"
                expressionText(str)

            }


        }
        add.setOnClickListener{
            if (expression.text.toString().endsWith("%")||expression.text.toString().endsWith("/")||expression.text.toString().endsWith("*")||expression.text.toString().endsWith("+")||expression.text.toString().endsWith("-")||expression.text.toString().endsWith(".")){
                str = expression.text.toString()
                expressionText(str)
            }else{
                str =expression.text.toString()+"+"
                expressionText(str)

            }


        }
        soustraction.setOnClickListener{
            if (expression.text.toString().endsWith("%")||expression.text.toString().endsWith("/")||expression.text.toString().endsWith("*")||expression.text.toString().endsWith("+")||expression.text.toString().endsWith("-")||expression.text.toString().endsWith(".")){
                str = expression.text.toString()
                expressionText(str)
            }else{
                str =expression.text.toString()+"-"
                expressionText(str)

            }


        }
        equal.setOnClickListener{
            expression.textSize = 30F
            result.textSize= 60F


        }
        dot.setOnClickListener{
            if (expression.text.toString().endsWith("%")||expression.text.toString().endsWith("/")||expression.text.toString().endsWith("*")||expression.text.toString().endsWith("+")||expression.text.toString().endsWith("-")||expression.text.toString().endsWith(".")){
                str = expression.text.toString()
                expressionText(str)
            }else{
                str =expression.text.toString()+"."
                expressionText(str)
            }

        }
        zero.setOnClickListener{
          if(expression.text.toString().startsWith("0")){
              str = expression.text.toString().replace("0","")+"0"
              expressionText(str)
              resultText()
          }else{
              str = expression.text.toString()+"0"
              expressionText(str)
              resultText()
          }

        }
        zerozero.setOnClickListener{
            if(expression.text.toString().startsWith("0")){
                str = expression.text.toString().replace("0","")+"00"
                expressionText(str)
                resultText()
            }else{
                str = expression.text.toString()+"00"
                expressionText(str)
                resultText()
            }

        }
        one.setOnClickListener{
            if(expression.text.toString().startsWith("0")){
                str = expression.text.toString().replace("0","")+"1"
                expressionText(str)
                resultText()
            }else{
                str = expression.text.toString()+"1"
                expressionText(str)
                resultText()
            }

        }
        two.setOnClickListener{
            if(expression.text.toString().startsWith("0")){
                str = expression.text.toString().replace("0","")+"2"
                expressionText(str)
                resultText()
            }else{
                str = expression.text.toString()+"2"
                expressionText(str)
                resultText()
            }

        }
        three.setOnClickListener{
            if(expression.text.toString().startsWith("0")){
                str = expression.text.toString().replace("0","")+"3"
                expressionText(str)
                resultText()
            }else{
                str = expression.text.toString()+"3"
                expressionText(str)
                resultText()
            }

        }
        four.setOnClickListener{

            if(expression.text.toString().startsWith("0")){
                str = expression.text.toString().replace("0","")+"4"
                expressionText(str)
                resultText()
            }else{
                str = expression.text.toString()+"4"
                expressionText(str)
                resultText()
            }
        }
        five.setOnClickListener{
            if(expression.text.toString().startsWith("0")){
                str = expression.text.toString().replace("0","")+"5"
                expressionText(str)
                resultText()
            }else{
                str = expression.text.toString()+"5"
                expressionText(str)
                resultText()
            }

        }
        six.setOnClickListener{
            if(expression.text.toString().startsWith("0")){
                str = expression.text.toString().replace("0","")+"6"
                expressionText(str)
                resultText()
            }else{
                str = expression.text.toString()+"6"
                expressionText(str)
                resultText()
            }

        }
        seven.setOnClickListener{
            if(expression.text.toString().startsWith("0")){
                str = expression.text.toString().replace("0","")+"7"
                expressionText(str)
                resultText()
            }else{
                str = expression.text.toString()+"7"
                expressionText(str)
                resultText()
            }

        }
        eight.setOnClickListener{
            if(expression.text.toString().startsWith("0")){
                str = expression.text.toString().replace("0","")+"8"
                expressionText(str)
                resultText()
            }else{
                str = expression.text.toString()+"8"
                expressionText(str)
                resultText()
            }

        }
        nine.setOnClickListener{
            if(expression.text.toString().startsWith("0")){
                str = expression.text.toString().replace("0","")+"9"
                expressionText(str)
                resultText()
            }else{
                str = expression.text.toString()+"9"
                expressionText(str)
                resultText()
            }

        }

        x2.setOnClickListener {
            val currentText = expression.text.toString()
            if (currentText.isNotEmpty()) {
                val number = currentText.toDouble()
                val squared = number * number
                expressionText(squared.toString())
                resultText()
            }
        }
        xy.setOnClickListener {
            val currentText = expression.text.toString()
            if (currentText.isNotEmpty()) {
                expressionText("$currentText^")
            }
        }
        sin.setOnClickListener {
            val currentText = expression.text.toString()
            if (currentText.isNotEmpty()) {
                val number = Math.toRadians(currentText.toDouble()) // Convertir en radians
                val sinValue = Math.sin(number)
                expressionText(sinValue.toString())
                resultText()
            }
        }
        cos.setOnClickListener {
            val currentText = expression.text.toString()
            if (currentText.isNotEmpty()) {
                val number = Math.toRadians(currentText.toDouble()) // Convertir en radians
                val cosValue = Math.cos(number)
                expressionText(cosValue.toString())
                resultText()
            }
        }
        tan.setOnClickListener {
            val currentText = expression.text.toString()
            if (currentText.isNotEmpty()) {
                val number = Math.toRadians(currentText.toDouble()) // Convertir en radians
                val tanValue = Math.tan(number)
                expressionText(tanValue.toString())
                resultText()
            }
        }
        sin_1.setOnClickListener {
            val currentText = expression.text.toString()
            if (currentText.isNotEmpty()) {
                val number = currentText.toDouble()
                val asinValue = Math.toDegrees(Math.asin(number)) // Convertir en degrés
                expressionText(asinValue.toString())
                resultText()
            }
        }
        cos_1.setOnClickListener {
            val currentText = expression.text.toString()
            if (currentText.isNotEmpty()) {
                val number = currentText.toDouble()
                val acosValue = Math.toDegrees(Math.acos(number)) // Convertir en degrés
                expressionText(acosValue.toString())
                resultText()
            }
        }
        tan_1.setOnClickListener {
            val currentText = expression.text.toString()
            if (currentText.isNotEmpty()) {
                val number = currentText.toDouble()
                val atanValue = Math.toDegrees(Math.atan(number)) // Convertir en degrés
                expressionText(atanValue.toString())
                resultText()
            }
        }
        log.setOnClickListener {
            val currentText = expression.text.toString()
            if (currentText.isNotEmpty()) {
                val number = currentText.toDouble()
                val logValue = Math.log10(number)
                expressionText(logValue.toString())
                resultText()
            }
        }
        ln.setOnClickListener {
            val currentText = expression.text.toString()
            if (currentText.isNotEmpty()) {
                val number = currentText.toDouble()
                val lnValue = Math.log(number)
                expressionText(lnValue.toString())
                resultText()
            }
        }
        racine.setOnClickListener {
            val currentText = expression.text.toString()
            if (currentText.isNotEmpty()) {
                val number = currentText.toDouble()
                val sqrt = Math.sqrt(number)
                expressionText(sqrt.toString())
                resultText()
            }
        }
        expo.setOnClickListener {
            val currentText = expression.text.toString()
            if (currentText.isNotEmpty()) {
                val number = currentText.toDouble()
                val exp = Math.exp(number)
                expressionText(exp.toString())
                resultText()
            }
        }
        pi.setOnClickListener {
            expressionText(expression.text.toString() + Math.PI.toString())
        }
        vAbsolut.setOnClickListener {
            val currentText = expression.text.toString()
            if (currentText.isNotEmpty()) {
                val number = currentText.toDouble()
                val abs = Math.abs(number)
                expressionText(abs.toString())
                resultText()
            }
        }
        leftPare.setOnClickListener {
            expressionText(expression.text.toString() + "(")
        }
        rightPare.setOnClickListener {
            expressionText(expression.text.toString() + ")")
        }
    }



    private fun expressionText(str : String){
        expression.text =str

    }

    private fun resultText(){
        val exp = expression.text.toString()
        val engine:ScriptEngine = ScriptEngineManager().getEngineByName("rhino")
        try{
            val res = engine.eval(exp)
            if(res.toString().endsWith("0")){
                result.text="="+res.toString().replace(".0","")
            }else{
                result.text= "=$res"
            }
        }catch (e:Exception){
            expression.text=expression.text.toString()
            result.text=expression.text.toString()
        }

    }
}