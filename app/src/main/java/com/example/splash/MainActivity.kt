package com.example.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.splash.ui.theme.SplashTheme
import kotlinx.coroutines.delay


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SplashTheme {
                SplashScreen {
                    startActivity(Intent(this, HalamanUtama::class.java))
                    finish()
                }
            }
        }
    }
}

@Composable
fun SplashScreen(onTimeout: () -> Unit = {}) {
    LaunchedEffect(Unit) {
        delay(3000)
        onTimeout()
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFB1E9F8)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(id = R.drawable.logoo),
                    contentDescription = "Logo",
                    modifier = Modifier.size(150.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Europa",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(color = 0xFFFFFFFF)
                )
                Spacer(modifier = Modifier.height(80.dp))
            }
        }
    }
}