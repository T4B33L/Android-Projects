package com.example.mycalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycalculator.ui.theme.MyCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCalculatorTheme {
                Calculator()
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun Calculator(){
    val preview = remember { mutableStateOf("0")}
    val operand1 = remember { mutableStateOf("")}
    val operand2 = remember { mutableStateOf("")}
    val operator = remember { mutableStateOf("") }
    val operatorIsPressed = remember { mutableStateOf( false) }
    val performCalcultion = remember { mutableStateOf( false) }
    val result = remember { mutableStateOf("") }    
    Column(verticalArrangement = Arrangement.Bottom, modifier = Modifier
        .fillMaxSize()
        .background(color = Color.DarkGray)
        .padding(10.dp)) {
        Cal_Screen(preview = preview.value)

        if(performCalcultion.value){
            result.value = calculation(operand1.value,operand2.value,operator.value)
            preview.value = result.value
            operand1.value = ""
            operand2.value = ""
            operator.value = ""
            operatorIsPressed.value = false
            performCalcultion.value = false
        }
        else{
            Divider()
            Spacer(modifier = Modifier.padding(vertical = 3.dp))
            Row {
                Cal_Button(symbol = "7", modifier = Modifier.background(color = Color.LightGray)){ if(!operatorIsPressed.value){ operand1.value =operand1.value.plus("7")
                    preview.value=operand1.value } else{ operand2.value =operand2.value.plus("7")
                    preview.value=operand2.value} }
                Spacer(modifier = Modifier.padding(horizontal = 9.dp))
                Cal_Button(symbol = "8", modifier = Modifier.background(color = Color.LightGray)){ if(!operatorIsPressed.value){  operand1.value =operand1.value.plus("8")
                    preview.value=operand1.value} else{ operand2.value =operand2.value.plus("8")
                    preview.value=operand2.value} }
                Spacer(modifier = Modifier.padding(horizontal = 9.dp))
                Cal_Button(symbol = "9", modifier = Modifier.background(color = Color.LightGray)){ if(!operatorIsPressed.value){  operand1.value =operand1.value.plus("9")
                    preview.value=operand1.value} else{ operand2.value =operand2.value.plus("9")
                    preview.value=operand2.value} }
                Spacer(modifier = Modifier.padding(horizontal = 9.dp))
                Cal_Button(symbol = "AC", modifier = Modifier.background(color = Color(0xffe39939))){
                    preview.value = "0"
                    operand1.value = ""
                    operand2.value = ""
                    operator.value = ""
                    operatorIsPressed.value = false
                    performCalcultion.value = false
                }
            }
            Spacer(modifier = Modifier.padding(vertical = 6.dp))
            Row {
                Cal_Button(symbol = "4", modifier = Modifier.background(color = Color.LightGray)){ if(!operatorIsPressed.value){  operand1.value =operand1.value.plus("4")
                    preview.value=operand1.value} else{  operand2.value =operand2.value.plus("4")
                    preview.value=operand2.value} }
                Spacer(modifier = Modifier.padding(horizontal = 9.dp))
                Cal_Button(symbol = "5", modifier = Modifier.background(color = Color.LightGray)){ if(!operatorIsPressed.value){  operand1.value =operand1.value.plus("5")
                    preview.value=operand1.value} else{ operand2.value =operand2.value.plus("5")
                    preview.value=operand2.value} }
                Spacer(modifier = Modifier.padding(horizontal = 9.dp))
                Cal_Button(symbol = "6", modifier = Modifier.background(color = Color.LightGray)){ if(!operatorIsPressed.value){  operand1.value =operand1.value.plus("6")
                    preview.value=operand1.value} else{ operand2.value =operand2.value.plus("6")
                    preview.value=operand2.value}}
                Spacer(modifier = Modifier.padding(horizontal = 9.dp))
                Cal_Button(symbol = "-", modifier = Modifier.background(color = Color(0xffe39939))){ if(!operatorIsPressed.value){ operator.value = "-" }
                operatorIsPressed.value = true}
            }
            Spacer(modifier = Modifier.padding(vertical = 6.dp))
            Row {
                Cal_Button(symbol = "1", modifier = Modifier.background(color = Color.LightGray)){ if(!operatorIsPressed.value){  operand1.value =operand1.value.plus("1")
                    preview.value=operand1.value} else{ operand2.value =operand2.value.plus("1")
                    preview.value=operand2.value} }
                Spacer(modifier = Modifier.padding(horizontal = 9.dp))
                Cal_Button(symbol = "2", modifier = Modifier.background(color = Color.LightGray)){ if(!operatorIsPressed.value){  operand1.value =operand1.value.plus("2")
                    preview.value=operand1.value} else{ operand2.value =operand2.value.plus("2")
                    preview.value=operand2.value} }
                Spacer(modifier = Modifier.padding(horizontal = 9.dp))
                Cal_Button(symbol = "3", modifier = Modifier.background(color = Color.LightGray)){ if(!operatorIsPressed.value){  operand1.value =operand1.value.plus("3")
                    preview.value=operand1.value} else{ operand2.value =operand2.value.plus("3")
                    preview.value=operand2.value} }
                Spacer(modifier = Modifier.padding(horizontal = 9.dp))
                Cal_Button(symbol = "+", modifier = Modifier.background(color = Color(0xffe39939))){ if(!operatorIsPressed.value){ operator.value = "+"
                operatorIsPressed.value = true} }
            }
            Spacer(modifier = Modifier.padding(vertical= 9.dp))
            Row {
                Cal_Button(symbol = "0", modifier = Modifier.background(color = Color.LightGray)){ if(!operatorIsPressed.value){  operand1.value =operand1.value.plus("0")
                    preview.value=operand1.value} else{ operand2.value =operand2.value.plus("0")
                    preview.value=operand2.value} }
                Spacer(modifier = Modifier.padding(horizontal = 9.dp))
                Cal_Button(symbol = "/", modifier = Modifier.background(color = Color(0xffe39939))){ if(!operatorIsPressed.value){ operator.value = "/" }
                operatorIsPressed.value = true}
                Spacer(modifier = Modifier.padding(horizontal = 9.dp))
                Cal_Button(symbol = "*", modifier = Modifier.background(color = Color(0xffe39939))){ if(!operatorIsPressed.value){ operator.value = "*" }
                operatorIsPressed.value = true}
                Spacer(modifier = Modifier.padding(horizontal = 9.dp))
                Cal_Button(symbol = "=", modifier = Modifier.background(color = Color(0xffe39939))){ if(operatorIsPressed.value){ performCalcultion.value = true }else {} }
            }

        }


    }
}


@Composable
fun Cal_Screen(preview:String){
    Text(text = preview, color = Color.White, fontSize = 50.sp, textAlign = TextAlign.Right)

}

@Composable
fun Cal_Button(symbol:String, modifier: Modifier,onclick:()->Unit){
    Box(contentAlignment = Alignment.Center, modifier = Modifier
        .size(80.dp)
        .clip(CircleShape)
        .clickable { onclick() }
        .then(modifier)
    ) {
        Text(text = symbol, fontSize = 26.sp, color = Color.Black)
    }
}

fun calculation(operand1:String,operand2:String,operator:String):String{
    var result = ""
    if(operator=="+"){result= (operand1.toInt() + operand2.toInt()).toString()  }
    if(operator=="-"){result= (operand1.toInt() - operand2.toInt()).toString()  }
    if(operator=="/"){result= (operand1.toInt() / operand2.toInt()).toString()  }
    if(operator=="*"){result= (operand1.toInt() * operand2.toInt()).toString()  }
    return result
}







