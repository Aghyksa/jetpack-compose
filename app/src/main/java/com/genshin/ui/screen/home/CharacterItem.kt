package com.genshin.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.genshin.model.Character
import com.genshin.model.CharacterData
import com.genshin.ui.theme.GenshinDataTheme


@Composable
fun CharacterItem(
    character: Character,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .padding(15.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(character.photo),
                contentDescription = "avatar",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Gray, CircleShape)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = character.name,
                    fontWeight = FontWeight.Medium,
                    fontSize = 25.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                )

                Text(
                    text = character.intro,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun CharacterItemPreview() {
    GenshinDataTheme {
        CharacterItem(
            CharacterData.characters[0]
        )
    }
}