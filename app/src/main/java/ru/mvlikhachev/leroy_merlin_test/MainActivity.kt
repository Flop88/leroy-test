package ru.mvlikhachev.leroy_merlin_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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

val brownGreyColor = Color(0xFF959595)
val backgroundGreen = Color(0xFF29B619)

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
    ) {
        Text("Поиск товаров",
            modifier = Modifier.weight(1f),
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LeroymerlintestTheme {

    }
}