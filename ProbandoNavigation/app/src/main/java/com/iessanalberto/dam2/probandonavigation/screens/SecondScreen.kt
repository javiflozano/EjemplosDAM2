package com.iessanalberto.dam2.probandonavigation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun SecondScreen(navController: NavController, texto: String?){
    Scaffold {
        innerpadding -> SecondBodyContent(navController = navController, modifier = Modifier.padding(innerpadding))
    }
}

@Composable
fun SecondBodyContent(navController: NavController, modifier: Modifier) {
    Column (modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        )
    {
        Text(text = "Bienvenido al otro lado",
            modifier = Modifier.clickable {navController.popBackStack()})
    }

}
