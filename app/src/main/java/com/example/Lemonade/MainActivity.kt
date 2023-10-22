package com.example.Lemonade

import android.graphics.Paint.Style
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.Lemonade.ui.theme.LemonadeTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}

@Composable
fun LemonadeApp() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ){
        Text(
            text = "Lemonade",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 25.dp)
            )
        LemoadeWithImageTap()
    }
}

@Composable
fun LemoadeWithImageTap(modifier: Modifier = Modifier) {
    var currentStep by remember {
        mutableStateOf(1)
    }
    var squeezeCount by remember {
        mutableStateOf(1)
    }
    when (currentStep) {
        1 -> {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.lemon_tree),
                    contentDescription = null,
                    modifier = Modifier
                        .wrapContentSize()
                        .border(2.dp, Color(105), RoundedCornerShape(10.dp))
                        .clickable {
                            squeezeCount = (2..4).random()
                            currentStep = 2
                        }

                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Tap the lemon tree to select a lemon",
                    fontSize = 18.sp
                )
            }
        }

        2 -> {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.lemon_squeeze),
                    contentDescription = null,
                    modifier = Modifier
                        .wrapContentSize()
                        .border(2.dp, Color(205), RoundedCornerShape(10.dp))
                        .clickable {
                            squeezeCount--
                            if (squeezeCount == 0) {
                                currentStep = 3
                            }
//                            currentStep = 3

                        }
                )
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Keep the tapping to lemeon squeeze it",
                    fontSize = 18.sp
                )
            }
        }

        3 -> {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.lemon_drink),
                    contentDescription = null,
                    modifier = Modifier
                        .wrapContentSize()
                        .border(2.dp, Color(216), RoundedCornerShape(10.dp))
                        .clickable { currentStep = 4 }
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Tap the lemonade to drink it",
                    fontSize = 18.sp
                )
            }
        }

        4 -> {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.lemon_drink),
                    contentDescription = null,
                    modifier = Modifier
                        .wrapContentSize()
                        .border(2.dp, Color(105), RoundedCornerShape(10.dp))
                        .clickable { currentStep = 1 }
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Tap the lemonade to drink it",
                    fontSize = 18.sp
                )
            }
        }
    }
}
    

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    LemonadeTheme {
//        Greeting("Android")
//    }
//}