package com.example.c7102c1

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.c7102c1.ui.theme.C7102C1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UserProfileScreen()

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
    val ageGroup = getAgeGroup(age)
    val friends = remember { mutableStateListOf("Ana", "luis", "Ed", "Chelsea", "Karen") }

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
            OnChangeUsername = { username = "newUser123" },
            // Session 2
            ageGroup,
            friends = friends,
            onAddFriend = { addFriend( friendList = friends, newFriend = "Sophia")},
            onRemoveFriend = { removeFriend( friends, "Ed")}
        )

    }

}

// Challenge 4 session 2
fun getAgeGroup(age: Int): String {
    return when {
        age < 13 -> "Child"
        age in 13..17 -> "Teenager"
        age in 18..59 -> "Adult"
        else -> "Senior"
    }
}
//challenge 5 session 2
fun addFriend(friendList: MutableList<String>, newFriend: String) {
    if (!friendList.contains(newFriend)) {
        friendList.add(newFriend)
    }
}
//challenge 6 session 2
fun removeFriend(friendList: MutableList<String>, friendName: String){
    friendList.remove( element = friendName)
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
    OnChangeUsername: () -> Unit,
    ageGroup: String,
    friends: List<String>,
    onAddFriend: () -> Unit,
    onRemoveFriend: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Challenge 1 session 2
        Text(
            text = "User Profile",
            modifier = Modifier.padding(all = 30.dp)
        )
        Text(
            text = "Age: $age",
            modifier = Modifier.padding(all = 5.dp)
        )
        Text(
            text = "BirthDate: $birthDate",
            modifier = Modifier.padding(all = 5.dp)
        )
        Text(
            text = "Address: $address",
            modifier = Modifier.padding(all = 5.dp)
        )
        Text(
            text = "user name: $fullName",
            modifier = Modifier.padding(all = 5.dp)
        )
        Text(
            text = "Likes: $likesCount",
            modifier = Modifier.padding(all = 5.dp)
        )
        Text(
            text = "Verified: $${if (isVerified) "Yes" else "No"}",
            modifier = Modifier.padding(all = 5.dp)
        )
        Text(
            text = "Age Group: $ageGroup",
            modifier = Modifier.padding(all = 5.dp)
        )
        Text(
            text = "Friends: ${friends.size}",
            modifier = Modifier.padding(all = 5.dp)
        )
        friends.forEach {
            Text(
                it,
                modifier = Modifier.padding(all = 5.dp)
            )
        }
        Row() {
            Button(onClick = onLike) {
                Text("Like")
            }
        }

        //challenge 3 session 2
        Button(onClick = OnChangeUsername) {
            Text("change username")
        }
    }
    Row() {
        Button(onClick = onRemoveFriend) {
            Text(
                "Remove Friends",
                modifier = Modifier.padding(all = 2.dp)
            )
        }
        Button(onClick = onAddFriend) {
            Text(
                "Add Friends",
                modifier = Modifier.padding(all = 2.dp)
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewUSerProfile() {
    UserProfileScreen()
}

