package com.genshin.ui.screen.detail

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import com.genshin.model.CharacterData
import com.genshin.ui.theme.GenshinDataTheme

@Composable
fun DetailScreen(
    name: String,
    modifier: Modifier = Modifier,
) {
    val character = CharacterData.getCharacter(name)
    val context = LocalContext.current
    Box(
        modifier = modifier
            .verticalScroll(rememberScrollState())
    ) {
        ConstraintLayout{
            val (background, photo, name, data, element, intro, share) = createRefs()
            Image(
                painter = painterResource(character.backgroud),
                contentDescription = "background",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .constrainAs(background) {
                        top.linkTo(parent.top)
                    }
                    .fillMaxWidth()
                    .height(309.dp)
                    .clipToBounds()

            )
            Image(
                painter = painterResource(character.photo),
                contentDescription = "avatar",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .constrainAs(photo) {
                        top.linkTo(background.bottom)
                        bottom.linkTo(background.bottom)
                        start.linkTo(background.start)
                    }
                    .padding(15.dp, 15.dp, 15.dp, 0.dp)
                    .size(106.dp)
                    .clipToBounds()

            )
            Text(
                text = character.name,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .constrainAs(name){
                        bottom.linkTo(photo.bottom)
                        start.linkTo(photo.end)
                    }
            )
            Column(
                modifier = Modifier
                    .constrainAs(data) {
                        top.linkTo(photo.bottom)
                    }
                    .padding(15.dp)
            ) {
                Text(text = "Vision: ${character.vision}")
                Text(text = "Affiliation: ${character.affiliation}")
                Text(text = "Birthday: ${character.birthday}")
                Text(text = "Weapon: ${character.weapon}")
            }
            Image(
                painter = painterResource(character.element),
                contentDescription = "element",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .constrainAs(element) {
                        top.linkTo(data.top)
                        bottom.linkTo(data.bottom)
                        end.linkTo(parent.end)
                    }
                    .padding(15.dp, 0.dp)
                    .size(100.dp)
                    .clipToBounds()

            )
            Column(
                modifier = Modifier
                    .constrainAs(intro) {
                        top.linkTo(data.bottom)
                    }
                    .padding(15.dp)
            ) {
                Text(
                    text = "Intro",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = character.intro
                )
            }
            Button(
                modifier = Modifier
                    .constrainAs(share) {
                        top.linkTo(intro.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                onClick = {
                    val goShare = Intent()
                    goShare.action = Intent.ACTION_SEND
                    goShare.putExtra(Intent.EXTRA_TEXT, "Hey look at this Genshin Character: ${character.url}")
                    goShare.type = "text/plain"
                    context.startActivity(Intent.createChooser(goShare, "Share To:"))
                }
            ) {
                Text(
                    text = "SHARE"
                )
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    GenshinDataTheme {
        DetailScreen(name = "Venti")
    }
}