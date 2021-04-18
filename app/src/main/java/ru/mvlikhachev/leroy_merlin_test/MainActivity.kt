package ru.mvlikhachev.leroy_merlin_test

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.InternalTextApi
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.mvlikhachev.leroy_merlin_test.model.Category
import ru.mvlikhachev.leroy_merlin_test.ui.theme.LeroymerlintestTheme
import ru.mvlikhachev.leroy_merlin_test.ui.theme.LightColorPalette
import ru.mvlikhachev.leroy_merlin_test.ui.theme.backgroundGray
import ru.mvlikhachev.leroy_merlin_test.ui.theme.backgroundGreen


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
    val categories: List<Category> = listOf(
        Category("Сад", R.drawable.category_garden),
        Category("Освещение", R.drawable.category_osveshchenie),
        Category("Инструменты", R.drawable.category_instrumenty),
        Category("Стройматериалы", R.drawable.category_brick),
        Category("Декор", R.drawable.category_dekor)
    )

    LazyRow(
        Modifier
            .fillMaxWidth()
            .padding(top = 30.dp)
    ) {

        item { Column( modifier = Modifier
            .background(backgroundGreen)
            .width(125.dp)
            .height(125.dp)
            .padding(start = 16.dp)
            .clickable (onClick = { Log.d("clickOnBox", "click") } )
            .clip(RoundedCornerShape(4.dp))
        ) {
            Box(
                Modifier
                    .padding(top = 14.dp, start = 14.dp)
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                Text(text = "Каталог", fontSize = 14.sp, color = Color.White)
            }
            Box(
                modifier = Modifier
                    .absoluteOffset()
                    .weight(1f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.BottomEnd

            ) {
                Image(painter = painterResource(id = R.drawable.ic_menu_24),
                    modifier = Modifier
                        .width(48.dp)
                        .height(48.dp)
                        .padding(end = 8.dp),
                    contentDescription = null)
            }
        } }
        items(categories) { category ->

                CategoryRow(category = category)
            }
        }
    }


@Composable
fun CategoryRow(category: Category) {
    Box(
        Modifier
            .width(125.dp)
            .height(125.dp)
            .padding(start = 16.dp)
            .clickable (onClick = { Log.d("clickOnBox", "click") } )
            .clip(RoundedCornerShape(4.dp))

    ) {
    Column( modifier = Modifier
        .background(backgroundGray)
        .width(150.dp)
        .height(150.dp)
    ) {
        Box(
            Modifier
                .padding(top = 14.dp, start = 14.dp)
                .weight(1f)
                .fillMaxWidth()
                .padding(end = 8.dp),
        ) {
            Text(text = category.categoryName, fontSize = 14.sp)
        }
        Box(
            modifier = Modifier
                .absoluteOffset()
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.BottomEnd

        ) {
            Image(painter = painterResource(id = category.categoryImg),
                modifier = Modifier
                    .width(64.dp)
                    .height(64.dp),
                contentDescription = null)
        }
    }
    }

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
