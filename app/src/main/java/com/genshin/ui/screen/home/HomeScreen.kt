package com.genshin.ui.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.genshin.model.CharacterData
import com.genshin.ui.theme.GenshinDataTheme


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navigateToDetail: (String) -> Unit,
) {
    Column(modifier = modifier) {

        LazyColumn {
            items(CharacterData.characters, key = { it.name }) { item ->
                CharacterItem(
                    item,
                    modifier = Modifier
                        .clickable {
                            navigateToDetail(item.name)
                        }
                )
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    GenshinDataTheme {
        HomeScreen(navigateToDetail = {})
    }
}