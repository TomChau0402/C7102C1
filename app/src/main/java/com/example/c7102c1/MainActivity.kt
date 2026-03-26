package com.example.c7102c1

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.material3.Surface
import androidx.compose.material3.Button
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.c7102c1.ui.theme.C7102C1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

@Composable
fun UserProfileScreen(){
    var fullName by remember { mutableStateOf( value = "Tom Chau") }
    var birthDate: String = "1975-05-15"
    var age by remember { mutableStateOf(value = 50) }
    var address by remember { mutableStateOf(value = "123 Main Street, Garden Grove, CA 10001")}
    var username by remember { mutableStateOf(value = "TomChau123") }
    var like by remember { mutableStateOf(value = 0) }
    val isVerified: Boolean = true

    Surface {
        ProfileContent(
            fullName,
            age,
            birthDate,
            address,
            username,
            isVerified,
            likesCount = like,
            //Challenge 4
            onLike = { like++ },
            OnChangeUsername = { username = "newUser123" }
        )

    }

}
@Composable
fun ProfileContent(
    fullName: String,
    age: Int,
    birthDate: String,
    address: String,
    username: String,
    isVerified: Boolean,
    likesCount: Int,
    onLike: () -> Unit,
    OnChangeUsername: () -> Unit
){
    Text(text = "user Profile")
    Text(text = "user name: $fullName")
    Text(text = "Age: $age")
}
//@Preview(showBackground = true)

