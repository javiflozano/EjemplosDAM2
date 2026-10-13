package com.iessanalberto.dam2.probandoscaffold

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.iessanalberto.dam2.probandoscaffold.ui.theme.ProbandoScaffoldTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProbandoScaffoldTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val mapaCapitales = mutableMapOf<String,String>(
                        "España" to "Madrid",
                        "Francia" to "Paris",
                        "Italia" to "Roma"
                    )
                    val listaPaises = mutableListOf<String>()

                    for (pais in mapaCapitales) {
                        listaPaises.add(pais.key)
                    }
                    listaPaises.shuffle()

                    Greeting("Android",mapaCapitales,listaPaises)

                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(
    name: String,
    mapaCapitales: MutableMap<String, String>,
    listaPaises: MutableList<String>
) {
    var presses by remember { mutableStateOf(0) }
    var pressesBack by remember { mutableStateOf(0) }
    var pressesMenu by remember { mutableStateOf(0) }

    var capital by remember {
        mutableStateOf("")
    }
    var numeroIntentos by remember {
        mutableStateOf(0)
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Top app bar")
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                navigationIcon = {
                    IconButton(onClick = { pressesBack++ }) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Atrás")
                    }
                },
                actions = { IconButton(onClick = { pressesMenu++ }) {
                    Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menú")
                }}
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.Check, contentDescription = "Check")
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.MailOutline, contentDescription = "Mail")
                    }
                    Text(text = "BottomBar")
                }

            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { presses++ }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                text =
                """
                    This is an example of a scaffold. It uses the Scaffold composable's parameters to create a screen with a simple top app bar, bottom app bar, and floating action button.

                    It also contains some basic inner content, such as this text.

                    You have pressed the floating action button $presses times.
                    
                    You have pressed the back button from the top bar $pressesBack times.
                    
                    You have pressed the menu icon from the top bar $pressesMenu times.
                """.trimIndent(),
            )
            TextField(value = capital, onValueChange = {capital = it},label = {Text("Introduce la capital de ${listaPaises.get(numeroIntentos)}")} )
            Button(onClick = { if (capital == mapaCapitales.get(listaPaises.get(numeroIntentos))){
                presses++
                numeroIntentos++
                capital = ""
            }
            }) {
                Text("Validar")
            }
        }
    }

}
