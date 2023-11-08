package com.asystechs.uijetckpackcompose.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun Home(route: String , navController: NavController?) {
    Column(modifier = Modifier.fillMaxSize()) {
        TitleText(title = "Home")
        LazyColumn{
            var i =0
            items((0..5).toList()){
                TaskCard(route ,task = "Home Item ${it+1}" , navController)
            }
        }
    }
}
@Preview
@Composable
fun HomePreview(){
    Surface {
        Home("task" , null)
    }
}

@Composable
fun TaskCard(route: String?, task: String , navController: NavController?){
    Card(
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier.fillMaxSize().
        wrapContentHeight().padding(start = 10.dp, top =8.dp, end = 10.dp).clickable {
            route?.let {
                // for optional argument
//                navController?.navigate(it)
                navController?.navigate(it+"?item=${task}")

                // medatory
//                navController?.navigate(it+"/${task}")

            }
        }
    ){
        Row(modifier = Modifier.fillMaxSize().padding(10.dp)) {
            Image(
                modifier = Modifier.padding(10.dp),
                painter = painterResource(id = android.R.drawable.ic_input_add) , contentDescription = "image icon"
            )
            Text(text = task ,modifier = Modifier.padding(10.dp),)
        }
    }

}

@Composable
fun TitleText(title: String){
    Text(text = title, modifier = Modifier.fillMaxWidth().padding(10.dp).wrapContentHeight())
}