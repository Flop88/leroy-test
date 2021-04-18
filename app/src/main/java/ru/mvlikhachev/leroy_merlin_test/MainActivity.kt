package ru.mvlikhachev.leroy_merlin_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.InternalTextApi
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.mvlikhachev.leroy_merlin_test.ui.theme.LeroymerlintestTheme
import ru.mvlikhachev.leroy_merlin_test.ui.theme.LightColorPalette

val backgroundGreen = Color(0xFF6ED548)

class MainActivity : ComponentActivity() {

    @InternalTextApi
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


@InternalTextApi
@ExperimentalFoundationApi
@Composable
fun BaseScreen() {
    LazyColumn(
        content = {
            stickyHeader {
                Toolbar()
            }
            item { catalogRow()}
        },
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
fun catalogRow() {
    val categories: List<String> = listOf("Сад", "Освещение", "Инструменты", "Стройматериалы", "Декор")
    LazyRow(
        Modifier
            .fillMaxWidth()
            .padding(top = 30.dp)
    ) {
        items(categories) { category ->
            Box(Modifier.width(150.dp).height(150.dp).padding(start = 16.dp).background(Color.Red)) {
                CategoryRow(category = category)
            }
        }
    }
}


@Composable
fun CategoryRow(category: String) {
    Text(category)
}


@InternalTextApi
@Composable
fun Toolbar() {
    Column(
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
            Text(
                "Поиск товаров",
                modifier = Modifier.weight(1f),
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Row(
            modifier = Modifier
                .height(60.dp)
                .padding(top = 8.dp)
                .fillMaxWidth()
        ) {
            Box(Modifier.weight(3f)) {
                SearchTextField()
            }
            Box(Modifier.weight(1f)) {
                QrCodeButton()
            }



        }
    }

}

@Composable
fun QrCodeButton() {
    Button(onClick = { /* Do something! */ },
        Modifier
            .padding(start = 16.dp)
            .width(56.dp)
            .height(56.dp),
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = Color.White,
        ),
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_qr_code_24),
            tint = Color.DarkGray,
            contentDescription = null, // decorative element
        )
    }
}

@Composable
fun SearchTextField() {
    var text by remember { mutableStateOf("") }

    TextField(
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White
        ),
        trailingIcon = {
            Button(onClick = { /* Do something! */ },
                Modifier
                    .width(48.dp)
                    .height(48.dp),
                colors = ButtonDefaults.textButtonColors(
                backgroundColor = backgroundGreen,
            ),
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search_24),
                    tint = Color.White,
                    contentDescription = null, // decorative element
                )
            }
        },
        value = text,
        onValueChange = { text = it },
        placeholder = { Text(text = "Поиск") },
    )

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LeroymerlintestTheme {
    }
}
