package com.example.listatarefascompose.ui.theme

import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val red_desabilitado = Color(0xFF808080) // Vermelho desabilitado
val red_habilitado = Color(0xFFF44336) // Vermelho habilitado
val green_desabilitado = Color(0xFF808080) // Verde desabilitado
val green_habilitado = Color(0xFF4CAF50) // Verde habilitado
val yellow_desabilitado = Color(0xFF808080) // Amarelo desabilitado
val yellow_habilitado = Color(0xFFFFEB3B) // Amarelo habilitado
val blue_desabilitado = Color(0xFF808080)
val blue_habilitado = Color(0xFF1232C2)

fun getColor(prioridade: Int) : Color{
    var cor: Color
    if(prioridade == 1)
        cor = red_habilitado
    else if(prioridade == 2)
        cor = yellow_habilitado
    else if(prioridade == 3)
        cor = green_habilitado
    else if(prioridade == 4)
        cor = blue_habilitado
    else
        cor = Color(0xFF808080)
    return cor
}