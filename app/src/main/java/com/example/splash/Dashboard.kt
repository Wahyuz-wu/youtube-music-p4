package com.example.splash

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.webkit.WebView
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.NotificationsNone
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.LifecycleOwner
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import coil.compose.AsyncImage
import com.example.splash.ui.theme.SplashTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import kotlin.math.max
import androidx.media3.ui.R as ExoUiR
//import com.google.android.exoplayer2.ui.R as ExoPlayerUiR




class Dashboard : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SplashTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting3(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting3(name: String, modifier: Modifier = Modifier) {
    var isOn by remember { mutableStateOf(false) }
    val backgroundColor = if (isOn) Color.Black else Color.White
    val Coco = if (isOn) Color.White else Color.Black
    var activePlayer by remember { mutableStateOf("none") }

    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(
            color = backgroundColor,
            darkIcons = !isOn
        )
    }

    Column(
        modifier = Modifier.fillMaxSize().background(color = backgroundColor).padding(horizontal = 20.dp, vertical = 40.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logoo),
                    contentDescription = "Logo",
                    modifier = Modifier.size(40.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Europa",
                    fontSize = 20.sp,
                    color = Coco,
                    fontWeight = FontWeight.Bold
                )
            }
//            Spacer(modifier = Modifier.width(10.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .padding(horizontal = 0.dp, vertical = 0.dp)
                        .border(
                            width = 2.dp,
                            color = Color(0xFFFFFFFF),
                            shape = RoundedCornerShape(50.dp)
                        )
                        .padding(horizontal = 10.dp, vertical = 10.dp)
                        .clickable{},
                    contentAlignment = Alignment.CenterStart
                ) {
                    Icon(
                        imageVector = Icons.Outlined.NotificationsNone,
                        contentDescription = "Notification",
                        tint = Coco,
                        modifier = Modifier.size(25.dp)
                    )
                }
                Spacer(modifier = Modifier.width(12.dp))

                Image(
                    painter = painterResource(id = R.drawable.lisa),
                    contentDescription = "Profile Picture",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(12.dp))

                CustomSwitch(
                    checked = isOn,
                    onCheckedChange = { isOn = it }
                )
            }
        }
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(
                text = "Top Artist",
                fontSize = 25.sp,
                color = Coco,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(25.dp))
            val context = LocalContext.current
            Row(
                modifier = Modifier.horizontalScroll(rememberScrollState()),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.clickable {
                        val intent = Intent(context, DetailArt::class.java)
                        context.startActivity(intent)
                    }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.lisa),
                        contentDescription = "Profile Picture",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(80.dp)
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.width(15.dp))
                    Text(
                        text = "Lisa Manoban",
                        fontSize = 12.sp,
                        color = Coco,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.width(13.dp))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.lisa),
                        contentDescription = "Profile Picture",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(80.dp)
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.width(15.dp))
                    Text(
                        text = "Lisa Manoban",
                        fontSize = 12.sp,
                        color = Coco,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.width(13.dp))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.lisa),
                        contentDescription = "Profile Picture",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(80.dp)
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.width(15.dp))
                    Text(
                        text = "Lisa Manoban",
                        fontSize = 12.sp,
                        color = Coco,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.width(13.dp))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.lisa),
                        contentDescription = "Profile Picture",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(80.dp)
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.width(15.dp))
                    Text(
                        text = "Lisa Manoban",
                        fontSize = 12.sp,
                        color = Coco,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.width(13.dp))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.lisa),
                        contentDescription = "Profile Picture",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(80.dp)
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.width(15.dp))
                    Text(
                        text = "Lisa Manoban",
                        fontSize = 12.sp,
                        color = Coco,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.width(13.dp))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.lisa),
                        contentDescription = "Profile Picture",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(80.dp)
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.width(15.dp))
                    Text(
                        text = "Lisa Manoban",
                        fontSize = 12.sp,
                        color = Coco,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Spacer(modifier = Modifier.height(25.dp))
            Text(
                text = "New Album Videos",
                fontSize = 25.sp,
                color = Coco,
                fontWeight = FontWeight.Bold,
//            style = MaterialTheme.typography.titleSmall
            )
            Spacer(modifier = Modifier.height(20.dp))
            //Ini Kodingan sambungan yang Video dari Youtube
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(200.dp),
//            shape = MaterialTheme.shapes.medium
//        ) {
//            YouTubeVideo(
//                videoId = "dNCWe_6HAM8",
//                modifier = Modifier.fillMaxSize()
//                )
//        }
            NewAlbumMusicPlayer(
                isDark = isOn,
                onPlay = {
                    activePlayer = "album"
                },
                isActive = activePlayer == "album"
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Recently Played",
                fontSize = 25.sp,
                color = Coco,
                fontWeight = FontWeight.Bold,
//            style = MaterialTheme.typography.titleSmall
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.horizontalScroll(rememberScrollState()),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(200.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.LightGray)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.lisa),
                        contentDescription = "Promo Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Spacer(modifier = Modifier.width(20.dp))
                Box(
                    modifier = Modifier
                        .size(200.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.LightGray)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.lisa),
                        contentDescription = "Promo Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Spacer(modifier = Modifier.width(20.dp))
                Box(
                    modifier = Modifier
                        .size(200.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.LightGray)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.lisa),
                        contentDescription = "Promo Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Spacer(modifier = Modifier.width(20.dp))
                Box(
                    modifier = Modifier
                        .size(200.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.LightGray)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.lisa),
                        contentDescription = "Promo Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Short",
                fontSize = 25.sp,
                color = Coco,
                fontWeight = FontWeight.Bold,
//            style = MaterialTheme.typography.titleSmall
            )
            Spacer(modifier = Modifier.height(20.dp))
            ShortVideoPlayer()
            Spacer(modifier = Modifier.height(20.dp))

        }
    }
}
//(ini kodingan video youtube)
//@Composable
//fun YouTubeVideo(
//    videoId: String,
//    modifier: Modifier = Modifier,
//    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current
//) {
//    AndroidView(
//        factory = { context: Context ->
//            YouTubePlayerView(context).apply {
//                lifecycleOwner.lifecycle.addObserver(this)
//                addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
//                    override fun onReady(youTubePlayer: YouTubePlayer) {
//                        youTubePlayer.cueVideo(videoId, 0f)
//                    }
//                })
//            }
//        },
//        modifier = modifier
//    )
//}

//@Composable
//fun NewAlbumMusicPlayer(isDark: Boolean) {
//    val context = LocalContext.current
//
//    val exoPlayer = remember {
//        ExoPlayer.Builder(context).build().apply {
//            val mediaItem = MediaItem.fromUri("android.resource://${context.packageName}/${R.raw.lisa1}")
//            setMediaItem(mediaItem)
//            prepare()
//        }
//    }
//
//    DisposableEffect(Unit) {
//        onDispose { exoPlayer.release() }
//    }
//
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .clip(RoundedCornerShape(12.dp))
//    ) {
//        Box(modifier = Modifier.fillMaxWidth().height(210.dp)) {
//            AndroidView(
//                factory = {
//                    PlayerView(context).apply {
//                        player = exoPlayer
//                        useController = true
//                    }
//                },
//                modifier = Modifier.matchParentSize()
//            )
//
//            Box(
//                modifier = Modifier
//                    .align(Alignment.BottomStart)
//                    .fillMaxWidth()
//                    .background(Color.Black.copy(alpha = 0.6f))
//                    .padding(8.dp)
//            ) {
//                Text(
//                    text = "Lisa",
//                    fontWeight = FontWeight.Bold,
//                    fontSize = 14.sp,
//                    color = Color.White,
//                    maxLines = 1
//                )
//            }
//        }
//    }
//}

@Composable
fun NewAlbumMusicPlayer(
    isDark: Boolean,
    onPlay: () -> Unit,
    isActive: Boolean
) {
    val context = LocalContext.current

    val mediaItems = listOf(
        MediaItem.fromUri("android.resource://${context.packageName}/${R.raw.lisa1}"),
        MediaItem.fromUri("android.resource://${context.packageName}/${R.raw.lisa2}")
    )

    val mediaTitles = mapOf(
        0 to "Money - Lisa",
        1 to "Lalisa - Lisa"
    )

    val currentTitle = remember { mutableStateOf("Lisa") }
    val hasStartedPlaying = remember { mutableStateOf(false) }

    val exoPlayer = remember {
        ExoPlayer.Builder(context).build().apply {
            setMediaItems(mediaItems)
            prepare()

            addListener(object : Player.Listener {
                override fun onIsPlayingChanged(isPlaying: Boolean) {
                    if (isPlaying) {
                        if (!hasStartedPlaying.value) {
                            hasStartedPlaying.value = true
                        }
                        currentTitle.value = mediaTitles[currentMediaItemIndex] ?: "Unknown"
                        onPlay()
                    }
                }

                override fun onMediaItemTransition(mediaItem: MediaItem?, reason: Int) {
                    if (hasStartedPlaying.value) {
                        currentTitle.value = mediaTitles[currentMediaItemIndex] ?: "Unknown"
                    }
                }
            })
        }
    }

    LaunchedEffect(isActive) {
        if (isActive) exoPlayer.playWhenReady = true
        else exoPlayer.pause()
    }

    DisposableEffect(Unit) {
        onDispose { exoPlayer.release() }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(210.dp)
        ) {
            AndroidView(
                factory = {
                    PlayerView(context).apply {
                        player = exoPlayer
                        useController = true
                    }
                },
                modifier = Modifier.matchParentSize()
            )

            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = currentTitle.value,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color.White,
                    maxLines = 1
                )
            }
        }
    }
}

//@Composable
//fun ShortVideoPlayer() {
//    val context = LocalContext.current
//
//    val mediaItem = MediaItem.fromUri("android.resource://${context.packageName}/${R.raw.lisa3}")
//    val exoPlayer = remember {
//        ExoPlayer.Builder(context).build().apply {
//            setMediaItem(mediaItem)
//            prepare()
//        }
//    }
//
//    DisposableEffect(Unit) {
//        onDispose {
//            exoPlayer.release()
//        }
//    }
//
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .wrapContentHeight()
//            .clip(RoundedCornerShape(20.dp))
//            .background(Color.Black)
//    ) {
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .aspectRatio(9f / 16f)
//        ) {
//            AndroidView(
//                factory = {
//                    PlayerView(context).apply {
//                        player = exoPlayer
//                        useController = true
////                        setShutterBackgroundColor(android.graphics.Color.BLACK)
//                    }
//                },
//                modifier = Modifier.matchParentSize()
//            )
//        }
//
////        Text(
////            text = "Lisa Cute Moment",
////            modifier = Modifier.padding(8.dp),
////            fontSize = 14.sp,
////            color = Color.White,
////            fontWeight = FontWeight.Bold
////        )
//    }
//}


@Composable
fun ShortVideoPlayer() {
    val context = LocalContext.current

    val videoList = listOf(
        R.raw.lisa3,
        R.raw.lisa4,
        R.raw.lisa5,
        R.raw.lisa6
    )

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp),
        horizontalArrangement = Arrangement.spacedBy(14.dp),
        contentPadding = PaddingValues(horizontal = 0.dp)
    ) {
        items(videoList, key = { it }) { videoRes ->
            VideoPlayerItem(videoRes = videoRes)
        }
    }
}

@Composable
fun VideoPlayerItem(videoRes: Int) {
    val context = LocalContext.current
    var isFullscreen by remember { mutableStateOf(false) }
    var controlsVisible by remember { mutableStateOf(false) }
    var isMuted by remember { mutableStateOf(true) }
    var isPlaying by remember { mutableStateOf(false) }

    // Inisialisasi ExoPlayer hanya sekali
    val exoPlayer = remember {
        ExoPlayer.Builder(context).build().apply {
            setMediaItem(MediaItem.fromUri("android.resource://${context.packageName}/$videoRes"))
            prepare()
            playWhenReady = false
            repeatMode = Player.REPEAT_MODE_ONE
        }
    }

    LaunchedEffect(isMuted) {
        exoPlayer.volume = if (isMuted) 0f else 1f
    }
    LaunchedEffect(isPlaying) {
        exoPlayer.playWhenReady = isPlaying
    }

    DisposableEffect(Unit) {
        onDispose {
            exoPlayer.release()
        }
    }

    if (isFullscreen) {
        Dialog(onDismissRequest = { isFullscreen = false }, properties = DialogProperties(usePlatformDefaultWidth = false)) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black)
            ) {
                AndroidView(
                    factory = { ctx ->
                        PlayerView(ctx).apply {
                            player = exoPlayer
                            useController = true
                            layoutParams = FrameLayout.LayoutParams(
                                FrameLayout.LayoutParams.MATCH_PARENT,
                                FrameLayout.LayoutParams.MATCH_PARENT
                            )
                        }
                    },
                    modifier = Modifier.fillMaxSize()
                )

                IconButton(
                    onClick = { isFullscreen = false },
                    modifier = Modifier.align(Alignment.TopEnd).padding(16.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close Fullscreen",
                        tint = Color.White
                    )
                }
            }
        }
    } else {
        Box(
            modifier = Modifier
                .width(240.dp)
                .aspectRatio(9f / 16f)
                .clip(RoundedCornerShape(20.dp))
                .background(Color.Black)
                .clickable{ controlsVisible = !controlsVisible }
        ) {
            AndroidView(
                factory = { context ->
                    PlayerView(context).apply {
                        player = exoPlayer
                        useController = false
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(9f / 16f)
            )

            if (controlsVisible) {
                Box(modifier = Modifier.fillMaxSize()) {
                    // Tombol Play di tengah
                    IconButton(
                        onClick = { isPlaying = !isPlaying },
                        modifier = Modifier.align(Alignment.Center)
                    ) {
                        Icon(
                            imageVector = if (isPlaying) Icons.Default.Pause else Icons.Default.PlayArrow,
                            contentDescription = "Play/Pause",
                            tint = Color.White,
                            modifier = Modifier.size(40.dp)
                        )
                    }

                    // Tombol Previous lebih dekat ke tengah
                    IconButton(
                        onClick = { /* TODO: Implement previous video */ },
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .padding(start = 16.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.SkipPrevious,
                            contentDescription = "Previous",
                            tint = Color.White,
                            modifier = Modifier.size(32.dp)
                        )
                    }

                    // Tombol Next lebih dekat ke tengah
                    IconButton(
                        onClick = { /* TODO: Implement next video */ },
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                            .padding(end = 16.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.SkipNext,
                            contentDescription = "Next",
                            tint = Color.White,
                            modifier = Modifier.size(32.dp)
                        )
                    }

                    // Tombol Mute (kiri bawah)
                    IconButton(
                        onClick = { isMuted = !isMuted },
                        modifier = Modifier.align(Alignment.TopStart).padding(8.dp)
                    ) {
                        Icon(
                            imageVector = if (isMuted) Icons.Default.VolumeOff else Icons.Default.VolumeUp,
                            contentDescription = "Mute",
                            tint = Color.White,
                            modifier = Modifier.size(28.dp)
                        )
                    }

                    IconButton(
                        onClick = { isFullscreen = true },
                        modifier = Modifier.align(Alignment.TopEnd).padding(8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Fullscreen,
                            contentDescription = "Fullscreen",
                            tint = Color.White
                        )
                    }

                }
            }
        }
    }
}


//@Composable
//fun VideoPlayerItem(videoRes: Int, onClick: () -> Unit) {
//    val context = LocalContext.current
//    val exoPlayer = remember(videoRes) {
//        ExoPlayer.Builder(context).build().apply {
//            setMediaItem(MediaItem.fromUri("android.resource://${context.packageName}/$videoRes"))
//            prepare()
//            playWhenReady = false
//        }
//    }
//
//    DisposableEffect(Unit) {
//        onDispose { exoPlayer.release() }
//    }
//
//    Box(
//        modifier = Modifier
//            .width(240.dp)
//            .aspectRatio(9f / 16f)
//            .clip(RoundedCornerShape(20.dp))
//            .clickable { onClick() }
//    ) {
//        AndroidView(
//            factory = {
//                PlayerView(context).apply {
//                    player = exoPlayer
//                    useController = true
//                }
//            },
//            modifier = Modifier.matchParentSize()
//        )
//    }
//}
//
//@Composable
//fun FullscreenVideo(videoRes: Int, onExit: () -> Unit) {
//    val context = LocalContext.current
//    val exoPlayer = remember(videoRes) {
//        ExoPlayer.Builder(context).build().apply {
//            setMediaItem(MediaItem.fromUri("android.resource://${context.packageName}/$videoRes"))
//            prepare()
//            playWhenReady = true
//        }
//    }
//
//    val systemUiController = rememberSystemUiController()
//    val useDarkIcons = false
//    SideEffect {
//        systemUiController.isSystemBarsVisible = false
//        systemUiController.setSystemBarsColor(Color.Black, darkIcons = useDarkIcons)
//    }
//
//    BackHandler {
//        // ketika back ditekan, keluar dari fullscreen
//        onExit()
//    }
//
//    DisposableEffect(Unit) {
//        onDispose {
//            exoPlayer.release()
//            systemUiController.isSystemBarsVisible = true
//        }
//    }
//
//    Box(modifier = Modifier
//        .fillMaxSize()
//        .background(Color.Black)
//        .clickable { onExit() } // keluar dari fullscreen saat diklik
//    ) {
//        AndroidView(
//            factory = {
//                PlayerView(context).apply {
//                    player = exoPlayer
//                    useController = true
//                }
//            },
//            modifier = Modifier.fillMaxSize()
//        )
//    }
//}




//Card(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(200.dp),
//            shape = MaterialTheme.shapes.medium
//        ) {
//            YouTubeVideo(
//                videoId = "dNCWe_6HAM8",
//                modifier = Modifier.fillMaxSize()
//                )
//        }


@Composable
fun CustomSwitch(checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    val thumbSize = 24.dp
    val trackHeight = 12.dp
    val trackWidth = 40.dp

    val animatedOffsetX by animateDpAsState(
        targetValue = if (checked) trackWidth - thumbSize else 0.dp,
        animationSpec = tween(durationMillis = 200),
        label = "thumb_offset"
    )

    Box(
        modifier = Modifier
            .width(trackWidth)
            .height(thumbSize)
            .clickable { onCheckedChange(!checked) },
        contentAlignment = Alignment.CenterStart
    ) {
        // Track
        Box(
            modifier = Modifier
                .height(trackHeight)
                .fillMaxWidth()
                .clip(RoundedCornerShape(50))
                .background(if (checked) Color.LightGray else Color.DarkGray)
        )

        // Thumb
        Box(
            modifier = Modifier
                .offset(x = animatedOffsetX)
                .size(thumbSize)
                .clip(CircleShape)
                .background(if (checked) Color.White else Color.Black)
                .border(1.dp, Color.Transparent, CircleShape)
        )
    }
}