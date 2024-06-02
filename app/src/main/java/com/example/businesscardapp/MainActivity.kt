package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardAppTheme {
                Surface(color = Color.Cyan) {
                    LogoTitleView(name = "Narasimhulu Muppalla", title = "Developer")
                    ContactView(phone = "123-4567-789", email = "c@gmail.com", tag = "@narsi")
                }
            }
        }
    }
}

@Composable
private fun LogoTitleView(name: String, title: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = "Logo",
            modifier = modifier
                .height(120.dp)
                .width(120.dp)
                .background(Color.Blue)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = name, fontSize = 20.sp, fontWeight = FontWeight.Thin, modifier = modifier)
        Text(text = title, fontWeight = FontWeight.Bold, modifier = modifier)
    }
}

@Composable
private fun ContactView(phone: String, email: String, tag: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(bottom = 20.dp),
        horizontalAlignment  = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
    ) {
        Row(modifier = modifier.padding(10.dp)) {
            Column {
                Image(painter = painterResource(id = R.drawable.android_logo),
                    contentDescription = "phone",
                    modifier = Modifier
                        .height(30.dp)
                        .padding(end = 10.dp)
                )
                Image(painter = painterResource(id = R.drawable.android_logo),
                    contentDescription = "phone",
                    modifier = Modifier
                        .height(30.dp)
                        .padding(end = 10.dp)
                )
                Image(painter = painterResource(id = R.drawable.android_logo),
                    contentDescription = "phone",
                    modifier = Modifier
                        .height(30.dp)
                        .padding(end = 10.dp)
                )
            }
            Column {
                Text(text = phone, modifier = modifier)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = tag, modifier = modifier)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = email, modifier = modifier)
            }
        }

//        Spacer(modifier = Modifier.height(8.dp))
//        Text(text = email, modifier = modifier)
//        Spacer(modifier = Modifier.height(8.dp))
//        Text(text = tag, modifier = modifier)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardAppTheme {
        Surface(color = Color.Cyan) {
            LogoTitleView(name = "Narasimhulu Muppalla", title = "Developer")
            ContactView(phone = "123-4567-789", email = "c@gmail.com", tag = "@narsi")
        }

    }
}