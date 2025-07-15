package com.example.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.splash.ui.theme.SplashTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class HalamanUtama : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SplashTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting2(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color.Transparent,
            darkIcons = false
        )
    }
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.auhah),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier.fillMaxSize().padding(horizontal = 15.dp, vertical = 30.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logoo),
                    contentDescription = "Logo",
                    modifier = Modifier.size(40.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Europa",
                    fontSize = 25.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.White)) {
                        append("The ")
                    }
                    withStyle(style = SpanStyle(color = Color.Blue)) {
                        append("rythhm ")
                    }
                    withStyle(style = SpanStyle(color = Color.White)) {
                        append("of life with the ")
                    }
                    withStyle(style = SpanStyle(color = Color.Blue)) {
                        append("Melody ")
                    }
                    withStyle(style = SpanStyle(color = Color.White)) {
                        append("in your life")
                    }
                },
                fontSize = 62.sp,
                lineHeight = 80.sp
            )
            Spacer(modifier = Modifier.height(100.dp))
            Image(
                painter = painterResource(id = R.drawable.lirik),
                contentDescription = "Promo Image",
                modifier = Modifier
                    .size(200.dp)
                    .offset(x = 55.dp)
                    .scale(2.5f),
            )
            Spacer(modifier = Modifier.height(50.dp))
            val context = LocalContext.current
            Button(
                onClick = {
                    val intent = Intent(context, Dashboard::class.java)
                    context.startActivity(intent)
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF095291)),
                shape = RoundedCornerShape(100.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .width(200.dp)
            ) {
                Text(text = "Explore", color = Color.White, fontSize = 25.sp)
            }
        }
    }
}

@Preview
@Composable
fun GreetingPreview2() {
    Greeting2("hi")
}