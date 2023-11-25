package com.genshin.ui.screen.profile

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import coil.compose.AsyncImage
import com.genshin.R
import com.genshin.ui.theme.GenshinDataTheme

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = R.drawable.profile,
            contentDescription = "profile",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
                .border(2.dp, Color.Gray, CircleShape)
        )
        Text(
            text = "Lion Younes Age Nesza Yadi Putra",
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp,
            modifier = modifier.padding(15.dp)
        )
        Text(text = "liony244@gmail.com")
    }
}
@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    GenshinDataTheme {
        ProfileScreen()
    }
}