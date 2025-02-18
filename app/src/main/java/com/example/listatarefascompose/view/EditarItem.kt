@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.listatarefascompose.view
import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.listatarefascompose.itens.CaixadeTexto
import com.example.listatarefascompose.ui.theme.*
import com.example.listatarefascompose.view.model.TarefaViewModel
import java.util.Calendar


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditarItem(
    navController: NavController,
    viewModelParametro: TarefaViewModel) {
    var tarefa = viewModelParametro.getTarefaById()

    println("ID TAREFA EDITAR ITEM: " + tarefa?.id)
    // Conteúdo da tela de salvar item
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Purple40
                ),
                title = {
                    Text(
                        text = "Editar Tarefa",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate("listaItens") })
                    {
                        Icon(
                            imageVector = Icons.Default.ArrowBack, // Ícone padrão de "voltar"
                            contentDescription = "Voltar" // Descrição para acessibilidade
                        )
                    }
                }
            )
        }

    ) {
        // Estados para os campos de entrada
        var tituloDaTarefa by remember { mutableStateOf(tarefa!!.titulo) }
        var descricaoDaTarefa by remember { mutableStateOf(tarefa!!.descricao) }

        // Estado para prioridade (único selecionado)
        var prioridadeSelecionada by remember { mutableIntStateOf(tarefa!!.id) }

        var dataSelecionada by remember { mutableStateOf(tarefa!!.data) }
        val context = LocalContext.current // Obtendo o contexto atual no Compose
        val calendar = Calendar.getInstance() // Instância do calendário para data atual

        val datePickerDialog = DatePickerDialog(
            context, // Contexto fornecido aqui
            { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
                dataSelecionada = "$dayOfMonth/${month + 1}/$year"
            },
            calendar.get(Calendar.YEAR), // Ano atual
            calendar.get(Calendar.MONTH), // Mês atual
            calendar.get(Calendar.DAY_OF_MONTH) // Dia atual
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            // Campo de texto para o título
            CaixadeTexto(
                value = tituloDaTarefa,
                onValueChange = { tituloDaTarefa = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 120.dp, 20.dp, 0.dp),
                label = "Título da Tarefa",
                maxLines = 1,
                keyboardType = KeyboardType.Text
            )

            // Campo de texto para a descrição
            CaixadeTexto(
                value = descricaoDaTarefa,
                onValueChange = { descricaoDaTarefa = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(20.dp, 10.dp, 20.dp, 0.dp),
                label = "Descrição da Tarefa",
                maxLines = 8,
                keyboardType = KeyboardType.Text
            )
            OutlinedTextField(
                value = dataSelecionada,
                onValueChange = { dataSelecionada = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                label = { Text("Data da Tarefa") },
                readOnly = true,
                trailingIcon = {
                    IconButton(onClick = { datePickerDialog.show() }) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Selecionar Data"
                        )
                    }
                }
            )

            // Opções de prioridade com RadioButtons
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Nível de Prioridade")

                RadioButton(
                    selected = (prioridadeSelecionada == 1),
                    onClick = { prioridadeSelecionada = 1 },
                    colors = RadioButtonDefaults.colors(
                        unselectedColor = red_desabilitado,
                        selectedColor = red_habilitado
                    )
                )
                RadioButton(
                    selected = (prioridadeSelecionada == 2),
                    onClick = { prioridadeSelecionada = 2 },
                    colors = RadioButtonDefaults.colors(
                        unselectedColor = yellow_desabilitado,
                        selectedColor = yellow_habilitado
                    )
                )
                RadioButton(
                    selected = (prioridadeSelecionada == 3),
                    onClick = { prioridadeSelecionada = 3 },
                    colors = RadioButtonDefaults.colors(
                        unselectedColor = green_desabilitado,
                        selectedColor = green_habilitado
                    )
                )
                RadioButton(
                    selected = (prioridadeSelecionada == 4),
                    onClick = { prioridadeSelecionada = 4 },
                    colors = RadioButtonDefaults.colors(
                        unselectedColor = blue_desabilitado,
                        selectedColor = blue_habilitado
                    )
                )
            }

            // Botão para salvar a tarefa
            Button(
                onClick = {
                    if (tituloDaTarefa.isNotBlank() && descricaoDaTarefa.isNotBlank() && prioridadeSelecionada != -1 && dataSelecionada.isNotBlank()) {
                        tarefa!!.titulo = tituloDaTarefa
                        tarefa.descricao = descricaoDaTarefa
                        tarefa.prioridade = prioridadeSelecionada
                        tarefa.data = dataSelecionada
                        navController.popBackStack() // Voltar para a tela anterior
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                Text(text = "Salvar")
            }
        }
    }
}




