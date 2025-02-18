package com.example.listatarefascompose.view
import com.example.listatarefascompose.Tarefa
import com.example.listatarefascompose.repository.TarefasRepository

fun adicionarTarefa(tarefa: Tarefa) {
    TarefasRepository.listaTarefas.add(tarefa)
}

fun excluirTarefa(id: Int) {
    TarefasRepository.listaTarefas.removeIf { it.id == id }

    TarefasRepository.listaTarefas.forEach{ tarefa ->
        if (tarefa.id == id){
            tarefa.concluida = true
        }
    }
}

fun marcarConcluida(id: Int) {
    TarefasRepository.listaTarefas.forEach{ tarefa ->
        if (tarefa.id == id) {
            if (tarefa.concluida) {
                tarefa.concluida = false
            } else {
                tarefa.concluida = true
            }
        }
    }
}