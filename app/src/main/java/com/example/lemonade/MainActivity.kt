package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LemonadeApp(modifier = Modifier)
                }
            }
        }
    }
}

@Composable
fun LemonadeApp(modifier: Modifier){
    var step by remember {
        mutableStateOf(1)
    }
    androidx.compose.material.Surface() {
        when(step){
            1-> Column(horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()) {
                Text(text = stringResource(id = R.string.image1_description))
                Spacer(modifier = Modifier.height(16.dp))
                Image(painter = painterResource(id = R.drawable.lemon_tree), contentDescription ="screen 1"
                    ,modifier=Modifier.wrapContentSize().clickable { step=2 }.border(width = 2.dp, color= Blue))
            }

            2->Column(horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()) {
                Text(text = stringResource(id = R.string.image2_description))
                Spacer(modifier = Modifier.height(16.dp))
                Image(painter = painterResource(id = R.drawable.lemon_squeeze), contentDescription ="screen 2"
                    ,modifier=Modifier.wrapContentSize().clickable { step=3 }.border(width = 2.dp, color= Blue))
            }

            3-> Column(horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()) {
                Text(text = stringResource(id = R.string.image3_description))
                Spacer(modifier = Modifier.height(16.dp))
                Image(painter = painterResource(id = R.drawable.lemon_drink), contentDescription ="screen 3"
                        ,modifier=Modifier.wrapContentSize().clickable { step=4 }.border(width = 2.dp, color= Blue))
            }

            4-> Column(horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()) {
                Text(text = stringResource(id = R.string.image4_description))
                Spacer(modifier = Modifier.height(16.dp))
                Image(painter = painterResource(id = R.drawable.lemon_restart), contentDescription ="screen 4"
                ,modifier=Modifier.wrapContentSize().clickable { step=1 }.border(width = 2.dp, color= Blue))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        LemonadeApp(modifier = Modifier)
    }
}