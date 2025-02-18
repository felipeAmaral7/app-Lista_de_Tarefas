package com.example.listatarefascompose.view

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.listatarefascompose.itens.mostrarBotaoPrioridade
import com.example.listatarefascompose.itens.mostrarTextoTitulo
import com.example.listatarefascompose.itens.mostrarTextoDescricao
import com.example.listatarefascompose.itens.mostrarTextoPrioridade
import com.example.listatarefascompose.repository.TarefasRepository
import com.example.listatarefascompose.ui.theme.getColor
import com.example.listatarefascompose.view.model.TarefaViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaItens(
    navController: NavController,
    viewModelParametro: TarefaViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(text = "Lista de Tarefas", fontSize = 30.sp)
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("salvarItem") }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) {
        //coluna que mostra as tarefas que foram colocadas no repository
        Column(
            modifier = Modifier
                .padding(16.dp, 130.dp)
                .verticalScroll(rememberScrollState())) {       //pra ficar com scroll
            TarefasRepository.listaTarefas
                .sortedBy { it.prioridade }                     //ordena por ordem de prioridade
                .forEach { tarefa ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                ){
                    //texto que sera mostrado caso haja alguma data
                    Text(
                        tarefa.data,
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(end = 8.dp),
                        fontSize = 20.sp,
                        color = MaterialTheme.colorScheme.primary
                    )

                    //coluna que estao os dados "titulo", "descricao", "prioridade", "Editar",
                    // "Excluir" e "Marcar como concluida"
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                    ){
                        //adiciona o titulo da tarefa
                        mostrarTextoTitulo(tarefa.titulo, 25)

                        //adiciona a descricao que esta na tarefa
                        mostrarTextoDescricao(tarefa.descricao, 20)

                        var cor = getColor(tarefa.prioridade)   //chama a fun de Color para pegar a cor da prioridade
                        //linha de prioridade
                        Row {
                            mostrarTextoPrioridade("Prioridade: ")
                            mostrarBotaoPrioridade(cor)
                        }
                        //linha dos campos "editarItem", "Excluir" e "concluida"
                        Row {
                            TextButton(onClick = {
                                viewModelParametro.setTarefaId(tarefa.id)
                                navController.navigate("editarItem") }) {   //redireciona para a tela editarItem
                                Text("Editar", fontSize = 15.sp)
                            }

                            //textButton para excluir a tarefa
                            TextButton(onClick = {
                                excluirTarefa(tarefa.id)
                                navController.navigate("listaItens")    //apenas para atualizar a tela
                            }) {
                                Text("Excluir", fontSize = 15.sp)
                            }

                            //textButton para marcar como concluido ou desmarcar como concluido
                            TextButton(onClick = {
                                marcarConcluida(tarefa.id)
                                navController.navigate("listaItens")    //apenas para atualizar a tela
                            }) {
                                Text(getConcluido(tarefa.concluida), fontSize = 14.sp)
                            }

                            Column (modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 20.dp),
                                horizontalAlignment = Alignment.End
                            ){
                                iconConcluido(tarefa.concluida)
                            }
                        }
                        Divider()
                    }
                }
            }
        }
    }
}

fun getConcluido(concluido : Boolean) : String {
    //uma logica simples para saber o estado de conclusao
    var text : String
    if(concluido){
        text = "Descarcar como concluida"
    }
    else{
        text = "Marcar como concluida"
    }
    return text
}

@Composable
fun iconConcluido(concluido: Boolean){
    if(concluido) {
        Icon(
            modifier = Modifier
                .size(30.dp)
                .border(BorderStroke(3.dp, MaterialTheme.colorScheme.primary)),
            imageVector = Icons.Default.Check,
            contentDescription = "Marcar concluido"
        )
    }
}