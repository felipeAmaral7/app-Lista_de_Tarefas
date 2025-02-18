package com.example.listatarefascompose

//definicao dos atributos de uma tarefa
data class Tarefa(
    val id: Int,
    var titulo: String,
    var descricao: String,
    var data: String,
    var prioridade: Int,
    var concluida: Boolean = false
)
