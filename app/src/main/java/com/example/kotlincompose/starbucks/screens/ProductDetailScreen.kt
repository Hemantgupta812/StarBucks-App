package com.example.kotlincompose.starbucks.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.W500
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.kotlincompose.R
import com.example.kotlincompose.starbucks.components.AppIconComponent
import com.example.kotlincompose.starbucks.components.IconComponent
import com.example.kotlincompose.starbucks.components.LogoComponent
import com.example.kotlincompose.ui.theme.Background
import com.example.kotlincompose.ui.theme.DarkGreen
import com.example.kotlincompose.ui.theme.Gray400_1
import com.example.kotlincompose.ui.theme.Gray_1
import com.example.kotlincompose.ui.theme.LightRed_1
import com.example.kotlincompose.ui.theme.TextColor


@Composable
fun ProductDetailScreen(
    navHostController: NavHostController
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ) {
        Column(
            Modifier.padding(20.dp)
        ) {
            ProductHeader { navHostController.navigateUp() }
            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(Modifier.fillMaxSize()) {
                item {

                    ShowProduct()
                    ProductDescription()
                }
            }


        }

        ButtonComponent(
            modifier = Modifier
                .padding(20.dp)
                .align(Alignment.BottomCenter)
        )
    }

}


@Composable
fun ProductDescription(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 15.dp)
    ) {

        Text(
            text = stringResource(id = R.string.coffee), style = TextStyle(
                fontSize = 18.sp,
                color = DarkGreen
            )
        )

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween) {

            Text(
                text = stringResource(id = R.string.chocolate_cappuccino),
                style = TextStyle(
                    fontSize = 22.sp,
                    fontWeight = W500
                )
            )

            Row {
                IconComponent(
                    icon = R.drawable.star, size = 20.dp,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )

                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = stringResource(id = R.string._4_5),
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = W500,
                        color = Gray_1
                    ),
                    modifier = Modifier.weight(0.2f)
                )
            }

        }

        Spacer(modifier = Modifier.height(15.dp))


        Text(
            text = stringResource(id = R.string.lorem_ipsum_dolor_sit_amet_consectetur_adipiscing_elit_etiam_at_mi_vitae_augue_feugiat_scelerisque_in_a_eros),
            style = TextStyle(
                fontSize = 18.sp,
                color = Gray400_1,
                fontWeight = FontWeight.W400
            )
        )


    }

}


@Composable
fun ShowProduct() {
    var counter by remember {
        mutableStateOf(0)
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                LightRed_1,
                RoundedCornerShape(14.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = R.drawable.image), contentDescription = "",
                Modifier.size(200.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Box(modifier = Modifier.background(Color.White, RoundedCornerShape(20.dp))) {
                Row {
                    AppIconComponent(icon = R.drawable.plus, Modifier.background(DarkGreen)) {
                        counter++

                    }

                    Spacer(modifier = Modifier.width(10.dp))

                    Text(
                        text = "$counter", style = TextStyle(
                            fontWeight = W500,
                            fontSize = 25.sp,
                            color = TextColor
                        ),
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                    Spacer(modifier = Modifier.width(10.dp))


                    AppIconComponent(icon = R.drawable.minus, Modifier.background(DarkGreen)) {
                        if (counter > 0) {
                            counter--
                        }
                    }


                }
            }

        }
    }

}

@Composable
fun ButtonComponent(
    modifier: Modifier = Modifier
) {

    Button(
        onClick = { /*TODO*/ },
        modifier = modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = DarkGreen
        ),
        shape = RoundedCornerShape(35.dp),
        contentPadding = PaddingValues(vertical = 15.dp),
        elevation = ButtonDefaults.buttonElevation(0.dp)
    ) {

        Text(
            text = stringResource(R.string.add_to_bag),
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.W600
            )
        )

    }

}


@Composable
private fun ProductHeader(onClick: () -> Unit) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        AppIconComponent(icon = R.drawable.back) {
            onClick()
        }
        LogoComponent(size = 55.dp)
        AppIconComponent(icon = R.drawable.love)

    }

}

@Preview
@Composable
fun preview() {
//    ProductHeader()
}