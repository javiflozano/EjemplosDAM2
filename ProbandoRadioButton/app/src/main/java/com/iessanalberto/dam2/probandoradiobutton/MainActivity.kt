package com.iessanalberto.dam2.probandoradiobutton

import android.os.Bundle
import android.widget.RadioGroup
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.iessanalberto.dam2.probandoradiobutton.ui.theme.ProbandoRadioButtonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProbandoRadioButtonTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val lista = listOf("Hola", "Adiós")
    val currentSelection = remember { mutableStateOf(lista.first()) }

    RadioGroup(
        modifier = Modifier.padding(16.dp).fillMaxWidth(),
        items = lista,
        selection = currentSelection.value,
        onItemClick = {clickedItem -> currentSelection.value = clickedItem}
    )
    Text(
        text = "Hello $name!",
        modifier = modifier
    )

}
@Composable
fun LabelledRadioButton(
    modifier: Modifier,
    label: String,
    selected: Boolean,
    onClick: (() -> Unit),
    enabled: Boolean = true,
    colors: RadioButtonColors = RadioButtonDefaults.colors()
){
    Row (modifier = modifier.padding(horizontal = 16.dp).height(56.dp), verticalAlignment = Alignment.CenterVertically)

    {
        RadioButton(
            selected = selected,
            onClick = onClick,
            enabled = enabled,
            colors = colors
        )
        Text(text = label,
            modifier = modifier.padding(start = 16.dp))
    }
}

@Composable
fun RadioGroup(
    modifier: Modifier,
    items: List<String>,
    selection: String,
    onItemClick: ((String) -> Unit))
{
        Column (modifier = modifier){
            items.forEach { item ->
                LabelledRadioButton(
                    modifier = Modifier.fillMaxWidth(),
                    label = item,
                    selected = item == selection,
                    onClick = {onItemClick(item)}
                )
            }
        }
    }


