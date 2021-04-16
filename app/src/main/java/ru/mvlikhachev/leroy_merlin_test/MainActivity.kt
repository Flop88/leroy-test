package ru.mvlikhachev.leroy_merlin_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.mvlikhachev.leroy_merlin_test.ui.theme.LeroymerlintestTheme
import ru.mvlikhachev.leroy_merlin_test.ui.theme.LightColorPalette

val backgroundGreen = Color(0xFF72C154)

class MainActivity : ComponentActivity() {

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(
                colors = LightColorPalette
            ) {
                // A surface container using the 'background' color from the theme
                BaseScreen()
            }
        }
    }
}
@ExperimentalFoundationApi
@Composable
fun BaseScreen() {
    LazyColumn(
        content = {
            stickyHeader {
                Toolbar()
            }
            item { Text(text = "test text") }
        },
        modifier = Modifier.fillMaxSize()
    )
}
@Composable
fun Toolbar() {
    Row(
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth()
            .background(color = backgroundGreen)
            .padding(start = 16.dp, end = 24.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(top = 60.dp)
                .height(40.dp)
                .fillMaxWidth()
        ) {
            Text("Поиск товаров",
                modifier = Modifier.weight(1f),
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LeroymerlintestTheme {

    }
}