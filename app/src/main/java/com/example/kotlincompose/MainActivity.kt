package com.example.kotlincompose

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.kotlincompose.R.drawable.thinker
import com.example.kotlincompose.starbucks.navigation.StarBucksNavigation
import com.example.kotlincompose.ui.theme.KotlinComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            window?.decorView?.systemUiVisibility = (View.SYSTEM_UI_FLAG_FULLSCREEN)
            window.statusBarColor = android.graphics.Color.TRANSPARENT

            KotlinComposeTheme {
                StarBucksNavigation()
            }
        }
    }
}


