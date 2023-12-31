@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.kotlincompose.starbucks.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.W400
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.kotlincompose.R
import com.example.kotlincompose.starbucks.Menu
import com.example.kotlincompose.starbucks.components.AppIconComponent
import com.example.kotlincompose.starbucks.components.IconComponent
import com.example.kotlincompose.starbucks.components.LogoComponent
import com.example.kotlincompose.starbucks.menuList
import com.example.kotlincompose.starbucks.navigation.product_detail
import com.example.kotlincompose.ui.theme.Background
import com.example.kotlincompose.ui.theme.DarkGray_1
import com.example.kotlincompose.ui.theme.DarkGreen
import com.example.kotlincompose.ui.theme.Gray_1
import com.example.kotlincompose.ui.theme.LightRed_1
import com.example.kotlincompose.ui.theme.Red
import com.example.kotlincompose.ui.theme.TextColor


@Composable
fun HomeScreen(
    navHostController: NavHostController
) {

    var search by remember { mutableStateOf("") }
    var chipId by remember { mutableStateOf(1) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {

            //header
            HeaderBar()

            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                item {
                    TextDescription()
                    Box {
                        SearchBarScreen(text = search, onvalueChange = { search = it })
                        AppIconComponent(
                            icon = R.drawable.filter, background = DarkGreen,
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .size(50.dp)
                        )
                    }

                    LazyRow(modifier = Modifier.padding(vertical = 20.dp)) {
                        items(menuList, key = { it.id }) {
                            CustomChipScreen(menu = it, selected = it.id == chipId) { data ->
                                chipId = data
                            }
                        }
                    }
                    Popular {

                        navHostController.navigate(product_detail)

                    }
                }



            }
        }
    }

}

@Composable
fun CustomChipScreen(
    menu: Menu,
    selected: Boolean,
    modifier: Modifier = Modifier,
    onvalueChange: (Int) -> Unit
) {

    TextButton(
        onClick = {
            onvalueChange(menu.id)
        },
        shape = RoundedCornerShape(22.dp),
        colors = ButtonDefaults.textButtonColors(
            containerColor = if (selected) DarkGreen else Gray_1,
            contentColor = if (selected) Color.White else TextColor
        ),
        contentPadding = PaddingValues(15.dp),
        modifier = Modifier.padding(end = 10.dp)
    ) {

        Text(
            text = menu.title,
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.W400
            ),
            modifier = Modifier.padding(end = 10.dp)
        )
    }

}


@Composable
fun Popular(onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, start = 16.dp, end = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(id = R.string.popular),
                style = TextStyle(
                    fontSize = 22.sp,
                    fontWeight = FontWeight.W500,
                    color = TextColor
                )
            )
            Text(
                text = stringResource(id = R.string.see_all),
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    color = DarkGreen
                ),
                modifier = Modifier
                    .clickable { onClick() }
                    .padding(8.dp)
            )
        }

        Spacer(Modifier.height(10.dp))

        LazyRow() {
            items(5) {
                ItemViewStartBucks {
                    onClick()
                }
            }
        }
    }
}

@Composable
fun ItemViewStartBucks(onClick: () -> Unit) {
    var selected by rememberSaveable { mutableStateOf(false) }

    Card(
        shape = RoundedCornerShape(14.dp),
        modifier = Modifier
            .width(220.dp)
            .padding(end = 10.dp)
            .clickable { onClick() }
    ) {
        Column {
            Box(
                modifier = Modifier
                    .background(
                        LightRed_1,
                        shape = RoundedCornerShape(bottomEnd = 14.dp, bottomStart = 14.dp)
                    )
                    .fillMaxWidth()
                    .height(200.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.image),
                    contentDescription = "",
                    modifier = Modifier.size(180.dp)
                )
            }

            Column(
                modifier = Modifier.padding(15.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.chocolate_cappuccino),
                    style = TextStyle(
                        color = DarkGray_1,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.W500
                    )
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = stringResource(id = R.string._20_00),
                        style = TextStyle(
                            color = DarkGreen,
                            fontSize = 25.sp,
                            fontWeight = FontWeight.W400
                        )
                    )

                    IconButton(
                        onClick = {
                            selected = !selected
                        },
                        modifier = Modifier.size(24.dp)
                    ) {
                        IconComponent(
                            icon = R.drawable.love,
                            tint = if (selected) Red else Color.Unspecified
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun SearchBarScreen(

    text: String,
    onvalueChange: (String) -> Unit,
    modifier: Modifier = Modifier

) {

    TextField(
        value = text, onValueChange = onvalueChange,
        placeholder = {
            Text(
                text = stringResource(id = R.string.search),
                style = TextStyle(
                    color = DarkGray_1,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W400
                )
            )
        },
        leadingIcon = {
            IconComponent(icon = R.drawable.search)
        },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(25.5.dp),
        singleLine = true,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = DarkGreen
        )
    )


}

@Composable
fun TextDescription() {

    Text(
        text = stringResource(id = R.string.our_way_of_loving_you_back),
        style = TextStyle(
            fontSize = 25.sp,
            fontWeight = FontWeight.W600,
            color = Color.Black
        ),
        modifier = Modifier.padding(vertical = 30.dp)
    )

}


@Composable
fun HeaderBar() {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        AppIconComponent(icon = R.drawable.menu)
        LogoComponent(size = 60.dp)
        AppIconComponent(icon = R.drawable.bag)

    }

}