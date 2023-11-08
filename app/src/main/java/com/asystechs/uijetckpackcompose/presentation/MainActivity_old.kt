package com.asystechs.uijetckpackcompose.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
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
class MainActivity_old : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UiJetckPackComposeTheme {
                // A surface container using the 'background' color from the theme
//                UserList()
                UserListinRecycler()
            }
        }
    }
}
// recyclerview in compose
val users = listOf<User>(
    User(1, "Ajay"),
    User(2, "Ajay 1"),
    User(3, "Ajay 2"),
    User(4, "Ajay 3"),
    User(5, "Ajay 4"),
    User(1, "Ajay"),
    User(2, "Ajay 1"),
    User(3, "Ajay 2"),
    User(4, "Ajay 3"),
    User(5, "Ajay 4"),

)
@Composable
fun UserListinRecycler(){
    LazyColumn{
        items(users){user->
            displayUserCard()
        }
    }
}


@Composable
fun UserList(){
    Column(modifier = Modifier.verticalScroll(rememberScrollState())){
        for(i in 1..10){
            displayUserCard()
        }
    }
}
// display the row and coloums
@Composable
fun displayUserCard(){

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

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Column {
        Text(
            text = "Hello $name!",
            fontSize = 32.sp,
            fontFamily =  FontFamily.Cursive,
            color = colorResource(id = R.color.purple_700),
            modifier = modifier.clickable {
                Toast.makeText(context, "Title Clicked" , Toast.LENGTH_LONG).show()
            }
        )
        displayUserCard()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreviews() {
    UiJetckPackComposeTheme {
//        Greeting("Android")
        UserListinRecycler()
    }
}