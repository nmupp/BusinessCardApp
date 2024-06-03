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
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
            var name = remember { mutableStateOf("Anroid Text") }
            BusinessCardAppTheme {
                Surface {
//                    LogoTitleView(name = "Narasimhulu Muppalla", title = "Developer")
//                    ContactView(phone = "123-4567-789", email = "c@gmail.com", tag = "@narsi")
                    MyApp(modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}

@Composable
private fun LogoTitleView(name: String, title: String, modifier: Modifier = Modifier) {
    val expanded = remember { mutableStateOf(false) }
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
        ElevatedButton(modifier = Modifier
            .width(100.dp)
            .background(color = Color.Black),onClick = {
            expanded.value = !expanded.value
        }) {
            Text(text = expanded.value .toString())
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {
   var showGreeting = remember { mutableStateOf(false) }
    Surface(modifier) {
        if (showGreeting.value) {
            Greeting(name = "Android")
        } else {
            OnboardingScreen(func = { showGreeting.value = !showGreeting.value })
        }
    }
}

@Preview
@Composable
fun MyAppPreview() {
    BusinessCardAppTheme {
        MyApp(modifier = Modifier.fillMaxSize())
    }
}

@Composable
private fun OnboardingScreen(modifier: Modifier = Modifier, func: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome to the Basics Codelab!")
        Button(
            modifier = Modifier.padding(vertical = 24.dp),
            onClick = { func() }
        ) {
            Text("Continue")
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnBoardingPreview() {
    BusinessCardAppTheme {
        OnboardingScreen(func = {})
    }
}


    @Composable
    private fun ContactView(
        phone: String,
        email: String,
        tag: String,
        modifier: Modifier = Modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,
        ) {
            Row(modifier = modifier.padding(10.dp)) {
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.android_logo),
                        contentDescription = "phone",
                        modifier = Modifier
                            .height(30.dp)
                            .padding(end = 10.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.android_logo),
                        contentDescription = "phone",
                        modifier = Modifier
                            .height(30.dp)
                            .padding(end = 10.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.android_logo),
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
            Surface() {
                LogoTitleView(name = "Narasimhulu Muppalla", title = "Developer")
                ContactView(phone = "123-4567-789", email = "c@gmail.com", tag = "@narsi")
            }

        }
    }
