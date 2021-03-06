package ru.mvlikhachev.leroy_merlin_test

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.InternalTextApi
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.mvlikhachev.leroy_merlin_test.model.Category
import ru.mvlikhachev.leroy_merlin_test.model.Goods
import ru.mvlikhachev.leroy_merlin_test.model.Screen
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
                BaseScreen()
            }
        }
    }
}

@InternalTextApi
@ExperimentalFoundationApi
@Composable
fun BaseScreen() {
    Scaffold(
        topBar = { Toolbar() },
        content = { Content() },
        bottomBar = { BottomNav() }
    )
}

@Composable
fun BottomNav() {

    val screens: List<Screen> = listOf(
        Screen("??????????????", R.drawable.ic_search_24),
        Screen("????????????", R.drawable.ic_list_24),
        Screen("??????????????", R.drawable.ic_shopping_24),
        Screen("??????????????", R.drawable.ic_person_24),
        Screen("??????????????", R.drawable.ic_cart_24)
    )

    BottomNavigation(
        backgroundColor = Color.White,
    ) {
        screens.forEach {
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = it.icon),
                        tint = Color.DarkGray,
                        contentDescription = null, // decorative element
                    )
                },
                label = { Text(text = it.label, color = Color.DarkGray, fontSize = 12.sp) },
                onClick = {
                    Log.d("clickBottomNavigation", "Clicked on: ${it.label}")
                },
                selected = true
            )
        }
    }
}

@InternalTextApi
@ExperimentalFoundationApi
@Composable
fun Content() {
    LazyColumn(
        content = {
            item { CatalogRow() }
            item {
                Row(
                    Modifier
                        .padding(start = 14.dp, top = 64.dp)
                        .fillMaxWidth()
                ) {
                    Text(text = "?????????????????????? ????????????????????", fontWeight = FontWeight.Bold)
                }
            }
            item { LimitedOfferRow() }
            item {
                Row(
                    Modifier
                        .padding(start = 14.dp, top = 64.dp)
                        .fillMaxWidth()
                ) {
                    Text(text = "???????????? ????????", fontWeight = FontWeight.Bold)
                }
            }
            item { LimitedOfferRow() }
        },
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun LimitedOfferRow() {
    val goods: List<Goods> = listOf(
        Goods(
            "???????????????????? ???????????????????????????????? ???????????????? Knauf ???? 75 ???????????? 30 ????",
            337.00,
            R.drawable.goods_shtukaturka
        ),
        Goods(
            "???????????????????? ???????????????????????????????? ???????????????? Knauf ???? 75 ???????????? 30 ????",
            337.00,
            R.drawable.goods_shtukaturka
        ),
        Goods(
            "???????????????????? ???????????????????????????????? ???????????????? Knauf ???? 75 ???????????? 30 ????",
            337.00,
            R.drawable.goods_shtukaturka
        ),
        Goods(
            "???????????????????? ???????????????????????????????? ???????????????? Knauf ???? 75 ???????????? 30 ????",
            337.00,
            R.drawable.goods_shtukaturka
        ),
        Goods(
            "???????????????????? ???????????????????????????????? ???????????????? Knauf ???? 75 ???????????? 30 ????",
            337.00,
            R.drawable.goods_shtukaturka
        ),
        Goods(
            "???????????????????? ???????????????????????????????? ???????????????? Knauf ???? 75 ???????????? 30 ????",
            337.00,
            R.drawable.goods_shtukaturka
        ),
    )
    LazyRow(
        Modifier
            .fillMaxWidth()
            .padding(top = 30.dp)
    ) {
        items(goods) { it ->
            Row(Modifier.padding(horizontal = 16.dp)) {
                GoodsRow(goods = it)
            }
        }
    }
}

@Composable
fun GoodsRow(goods: Goods) {
    Column(
        Modifier
            .width(130.dp)
            .height(200.dp)
            .clickable(onClick = { Log.d("clickOnGoods", "click on Goods") })
    ) {
        Column(
            Modifier
                .height(25.dp)
                .padding(4.dp)
                .weight(3f)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = goods.img),
                modifier = Modifier.fillMaxSize(),
                contentDescription = null
            )
        }
        Column(
            Modifier
                .height(25.dp)
                .padding(horizontal = 4.dp)
                .weight(1f)
                .fillMaxWidth()
        ) {
            Text(
                text = goods.price.toString() + " ???/????.",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 6.dp)
            )
        }
        Column(
            Modifier
                .height(25.dp)
                .padding(start = 4.dp, end = 4.dp, bottom = 4.dp)
                .weight(2f)
                .fillMaxWidth()
        ) {
            Text(
                text = goods.name,
                fontSize = 12.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 6.dp)
            )
        }
    }
}

@Composable
fun CatalogRow() {
    val categories: List<Category> = listOf(
        Category("??????", R.drawable.category_garden),
        Category("??????????????????", R.drawable.category_osveshchenie),
        Category("??????????????????????", R.drawable.category_instrumenty),
        Category("????????????????????????????", R.drawable.category_brick),
        Category("??????????", R.drawable.category_dekor)
    )
    LazyRow(
        Modifier
            .fillMaxWidth()
            .padding(top = 30.dp, start = 16.dp)
    ) {

        item { CatalogBox() }

        items(categories) { category ->
            Row(Modifier.padding(start = 16.dp)) {
                CategoryBox(category = category)
            }
        }

        item { AllButtonBox() }
    }
}

@Composable
fun AllButtonBox() {
    Row(
        Modifier
            .padding(start = 16.dp, end = 16.dp)
            .clickable(onClick = { Log.d("clickOnBox", "click") })
    ) {
        Column(
            modifier = Modifier
                .background(backgroundGray)
                .width(125.dp)
                .height(125.dp)
                .padding(start = 16.dp, end = 16.dp)
                .clip(RoundedCornerShape(4.dp))
        ) {
            Box(
                modifier = Modifier
                    .absoluteOffset()
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                //Square FAB
                FloatingActionButton(
                    onClick = { },
                    backgroundColor = backgroundGreen,
                    contentColor = Color.White,
                    modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp),
                ) {
                    Icon(Icons.Filled.ArrowForward, "")
                }
            }
            Box(
                Modifier
                    .padding(top = 8.dp)
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                Text(text = "???????????????? ??????", fontSize = 13.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun CatalogBox() {
    Row(Modifier.clickable(onClick = { Log.d("clickOnBox", "click") })) {
        Column(
            modifier = Modifier
                .background(backgroundGreen)
                .width(125.dp)
                .height(125.dp)
                .padding(start = 16.dp, end = 16.dp)
                .clip(RoundedCornerShape(4.dp))
        ) {
            Box(
                Modifier
                    .padding(top = 14.dp)
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                Text(text = "??????????????", fontSize = 14.sp, color = Color.White)
            }
            Box(
                modifier = Modifier
                    .absoluteOffset()
                    .weight(1f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.BottomEnd

            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_menu_24),
                    modifier = Modifier
                        .width(48.dp)
                        .height(48.dp)
                        .padding(end = 8.dp),
                    contentDescription = null
                )
            }
        }
    }

}


@Composable
fun CategoryBox(category: Category) {
    Row(Modifier.clickable(onClick = { Log.d("clickOnBox", "click") })) {
        Column(
            modifier = Modifier
                .background(backgroundGray)
                .width(125.dp)
                .height(125.dp)
                .padding(start = 16.dp, end = 16.dp)
                .clip(RoundedCornerShape(4.dp))
        ) {
            Box(
                Modifier
                    .padding(top = 14.dp)
                    .weight(1f)
                    .fillMaxWidth()
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
                Image(
                    painter = painterResource(id = category.categoryImg),
                    modifier = Modifier
                        .width(48.dp)
                        .height(48.dp)
                        .padding(end = 8.dp),
                    contentDescription = null
                )
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
                "?????????? ??????????????",
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
    Button(
        onClick = { /* Do something! */ },
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
            Button(
                onClick = { /* Do something! */ },
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
        placeholder = { Text(text = "??????????") },
    )
}
