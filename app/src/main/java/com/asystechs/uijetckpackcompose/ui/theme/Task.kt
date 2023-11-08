package com.asystechs.uijetckpackcompose.ui.theme

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController

@Composable
fun Task(task: String, navController: NavController?=null) {
    val context = LocalContext.current
    Toast.makeText(context , task, Toast.LENGTH_LONG) .show()
    Column(modifier = Modifier.fillMaxSize()) {
        TitleText(title = "Task Details")
        LazyColumn{
            var i =0
            items((0..5).toList()){
                TaskCard(null, task = "Task Detail Item ${it+1}", navController)
            }
        }
    }
}