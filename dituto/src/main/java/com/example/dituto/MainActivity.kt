package com.example.dituto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.dituto.data.repository.EmailService
import com.example.dituto.data.repository.RegisterUserService
import com.example.dituto.data.repository.UserService
import com.example.dituto.ui.theme.RoomDBTutoTheme

class MainActivity : ComponentActivity() {

    private lateinit var registerUserService: RegisterUserService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val emailService = EmailService()
        val userService = UserService()

        registerUserService = RegisterUserService(emailService, userService)
        setContent {
            RoomDBTutoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainContent("Click Me", onClick = {
                        registerUserService.createUser("Dhiraj Gurunule", "drj@ff.com")
                    })
                }
            }
        }
    }
}

@Composable
fun MainContent(name: String, onClick: () -> Unit, modifier: Modifier = Modifier) {

    Box {
        ClickableText(text = AnnotatedString(name),
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = modifier.padding(16.dp),
            onClick = {
                onClick.invoke()
            })
    }
}