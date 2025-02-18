package com.example.listatarefascompose.view.model

import androidx.lifecycle.ViewModel
import com.example.listatarefascompose.Tarefa
import com.example.listatarefascompose.repository.TarefasRepository

class TarefaViewModel : ViewModel() {
    // Apenas armazenando o ID da tarefa
    var tarefaId: Int? = null

    // Função para definir o ID da tarefa
    fun setTarefaId(id: Int) {
        tarefaId = id
    }

    // Função para obter a tarefa com base no ID (consulta manual)
    fun getTarefaById(): Tarefa? {
        //retorna a tarefa com base no ID
        return TarefasRepository.listaTarefas.find { it.id == tarefaId }
    }
}





