package com.example.listatarefascompose.repository
import com.example.listatarefascompose.Tarefa

//repositorio de todas as tarefas, podem ser acessadas por todas as classes
object TarefasRepository {
    var listaTarefas = mutableListOf<Tarefa>()

    private var proximoId = 0

    fun gerarIdSequencial(): Int {
        return proximoId++
    }
}