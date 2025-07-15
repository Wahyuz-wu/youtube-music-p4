package com.example.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.outlined.ContentCopy
import androidx.compose.material.icons.outlined.NotificationsNone
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.splash.ui.theme.SplashTheme

class DetailArt : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SplashTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting4(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting4(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.lisas),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 15.dp, vertical = 30.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "Lisa Manoban",
                            fontSize = 30.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "A talented Thai singer, rapper, and dancer \nknown for exceptional skills, strong stage \npresence, and global fashion influence.",
                            fontSize = 14.sp,
                            color = Color.White,
                            style = MaterialTheme.typography.titleSmall
                        )
                    }
                    Box(
                        modifier = Modifier
                            .size(70.dp)
                            .offset(y = 15.dp, x = 35.dp)
                            .background(
                                color = Color(0xFF8BC5EF),
                                shape = RoundedCornerShape(10.dp)
                            )
                            .clickable { },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.ContentCopy,
                            contentDescription = "Copy",
                            tint = Color.White,
                            modifier = Modifier
                                .size(40.dp)
                                .graphicsLayer {
                                    scaleY = -1f
                                }
                        )
                        Icon(
                            imageVector = Icons.Filled.PlayArrow,
                            contentDescription = "Play",
                            tint = Color.White,
                            modifier = Modifier
                                .size(20.dp)
                                .offset(x = 2.dp, y = -5.dp)
                        )
                    }
                }
            }
        }
        Text(
            text = "New Release",
            fontSize = 22.sp,
            color = Color.Black,
            modifier = Modifier.padding(start = 15.dp, top = 20.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clickable{}
                    .padding(start = 15.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.LightGray)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.song1),
                        contentDescription = "Promo Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Spacer(modifier = Modifier.width(15.dp))
                Column {
                    Text(
                        text = "LISA - 'LALISA' M/V",
                        fontSize = 20.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Hits Album 2021",
                        fontSize = 15.sp,
                        color = Color.LightGray,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clickable{}
                    .padding(start = 15.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.LightGray)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.song1),
                        contentDescription = "Promo Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Spacer(modifier = Modifier.width(15.dp))
                Column {
                    Text(
                        text = "LISA - 'LALISA' M/V",
                        fontSize = 20.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Hits Album 2021",
                        fontSize = 15.sp,
                        color = Color.LightGray,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clickable{}
                    .padding(start = 15.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.LightGray)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.song1),
                        contentDescription = "Promo Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Spacer(modifier = Modifier.width(15.dp))
                Column {
                    Text(
                        text = "LISA - 'LALISA' M/V",
                        fontSize = 20.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Hits Album 2021",
                        fontSize = 15.sp,
                        color = Color.LightGray,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clickable{}
                    .padding(start = 15.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.LightGray)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.song1),
                        contentDescription = "Promo Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Spacer(modifier = Modifier.width(15.dp))
                Column {
                    Text(
                        text = "LISA - 'LALISA' M/V",
                        fontSize = 20.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Hits Album 2021",
                        fontSize = 15.sp,
                        color = Color.LightGray,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clickable{}
                    .padding(start = 15.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.LightGray)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.song1),
                        contentDescription = "Promo Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Spacer(modifier = Modifier.width(15.dp))
                Column {
                    Text(
                        text = "LISA - 'LALISA' M/V",
                        fontSize = 20.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Hits Album 2021",
                        fontSize = 15.sp,
                        color = Color.LightGray,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clickable{}
                    .padding(start = 15.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.LightGray)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.song1),
                        contentDescription = "Promo Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Spacer(modifier = Modifier.width(15.dp))
                Column {
                    Text(
                        text = "LISA - 'LALISA' M/V",
                        fontSize = 20.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Hits Album 2021",
                        fontSize = 15.sp,
                        color = Color.LightGray,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}