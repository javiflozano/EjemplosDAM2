package com.iessanalberto.dam2.probandonavigation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.iessanalberto.dam2.probandonavigation.navigation.AppScreens

@Composable
fun FirstScreen(navController: NavController){
    Scaffold (){
        innerpadding -> BodyContent(navController = navController,modifier = Modifier.padding(innerpadding))
    }
}

@Composable
fun BodyContent(navController: NavController, modifier: Modifier){
    Column (modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        )
    {
        Text(text = "Hola mundo para navegantes")
        Button(onClick = {navController.navigate(route = AppScreens.SecondScreen.route)}) {
            Text(text = "Navega")
        }
    }
}