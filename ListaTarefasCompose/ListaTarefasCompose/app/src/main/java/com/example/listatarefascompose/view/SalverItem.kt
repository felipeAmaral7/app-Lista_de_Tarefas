package com.example.listatarefascompose.view


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.listatarefascompose.itens.CaixadeTexto
import com.example.listatarefascompose.ui.theme.Purple40
import com.example.listatarefascompose.ui.theme.green_desabilitado
import com.example.listatarefascompose.ui.theme.green_habilitado
import com.example.listatarefascompose.ui.theme.red_desabilitado
import com.example.listatarefascompose.ui.theme.red_habilitado
import com.example.listatarefascompose.ui.theme.yellow_desabilitado
import com.example.listatarefascompose.ui.theme.yellow_habilitado


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun SalverItem(navController: NavController)
{
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Purple40
                ),
                title = {
                    Text(
                        text = "Salvar Tarefa",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            )

        }
    ) {

        var titulotarefa by remember { //estado: titulo da tarefa
            mutableStateOf("")
        }

        var descricaodaTarefa by remember { //estado: descrição da tarefa
            mutableStateOf("")
        }

        var prioridadeZero by remember { //estado: prioridade da tarefa
            mutableStateOf(false)
        }

        var prioridadeUm by remember { //estado: prioridade alta da tarefa
            mutableStateOf(false)
        }

        var prioridadeDois by remember { //estado: prioridade media da tarefa
            mutableStateOf(false)
        }

        var prioridadeTres by remember { //estado: prioridade baixa da tarefa
            mutableStateOf(false)
        }


        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            CaixadeTexto(
                value = titulotarefa,
                onValueChange = { titulotarefa = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 20.dp, 20.dp, 0.dp),
                label = "Título da Tarefa",
                maxLines = 1,
                keyboardType = KeyboardType.Text
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                CaixadeTexto(
                    value = descricaodaTarefa,
                    onValueChange = { descricaodaTarefa = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .padding(20.dp, 10.dp, 20.dp, 0.dp),
                    label = "Descrição da Tarefa",
                    maxLines = 8,
                    keyboardType = KeyboardType.Text
                )

                Row(
                    verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Nível de Prioridade")

                    RadioButton(selected = prioridadeUm, onClick = { prioridadeUm =! prioridadeUm },
                        colors = RadioButtonDefaults.colors(
                            unselectedColor = red_desabilitado,
                            selectedColor = red_habilitado
                        )
                    )

                    RadioButton(selected = prioridadeDois, onClick = { prioridadeDois =! prioridadeDois },
                        colors = RadioButtonDefaults.colors(
                            unselectedColor = green_desabilitado,
                            selectedColor = green_habilitado
                        )
                    )

                    RadioButton(selected = prioridadeTres, onClick = { prioridadeTres =! prioridadeTres },
                        colors = RadioButtonDefaults.colors(
                            unselectedColor = yellow_desabilitado,
                            selectedColor = yellow_habilitado
                        )
                    )
                    RadioButton(selected = prioridadeZero, onClick = { prioridadeZero =! prioridadeZero },
                        colors = RadioButtonDefaults.colors(
                            unselectedColor = yellow_desabilitado,
                            selectedColor = yellow_habilitado
                        )
                    )
                }
            }
        }
    }
}