package com.asystechs.uijetckpackcompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asystechs.uijetckpackcompose.R
import com.asystechs.uijetckpackcompose.model.User
import com.asystechs.uijetckpackcompose.ui.theme.UiJetckPackComposeTheme

//https://www.youtube.com/watch?v=_9eriTPdwsk&list=PLk7v1Z2rk4hiqKRfuVyhkdwNJ3bniUMJf&index=4
//https://developer.android.com/jetpack/compose/tutorial
class MainActivity_LazyList : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UiJetckPackComposeTheme {
                // A surface container using the 'background' color from the theme
//                UserList()
                GreetingPreview_()
            }
        }
    }
}
// recyclerview in compose
@Composable
fun MainContent_(){
    val user = User(23,"Ajay")
    var users = remember {
        mutableListOf(user)
    }
    Box{
        UserListinRecycler_(user = users)
        Button(
            modifier = Modifier
                .padding(24.dp)
                .align(Alignment.BottomCenter),
            onClick = {
                users.add(User(23,"VIJAYES"))
        }) {
            Text(text= "Add More")
        }
    }
}
@Composable
fun UserListinRecycler_(user: List<User>){
    val name = remember{ mutableStateOf("Ajay") }
    LazyColumn{
        items(user){user->
            displayUserCard()
        }
    }
}

// display the row and coloums
@Composable
fun displayUserCard_(){

    Card (
        elevation = CardDefaults.cardElevation(5.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .wrapContentHeight()){
        Row (modifier = Modifier
            .fillMaxSize()
            .wrapContentHeight()
            .padding(12.dp)
            ){
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
            )

            Column {
                Text(text = "Ajay" ,
                    fontSize = 20.sp,
                    fontFamily = FontFamily.Default,
                    color = colorResource(id = R.color.purple_700))

                Text(text = "Ajay prpfile information" ,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.Default,
                    color = colorResource(id = R.color.black))

                Button(onClick = {}
                ) {
                    Text(text = "View Profile")
                }
            }


        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview_() {
    Surface (modifier = Modifier.fillMaxSize()) {
        MainContent_()
    }
}