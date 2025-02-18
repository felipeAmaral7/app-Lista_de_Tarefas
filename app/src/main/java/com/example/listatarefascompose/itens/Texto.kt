package com.example.listatarefascompose.itens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun mostrarTextoTitulo(texto : String, fontSize: Int ){
    Text(
        texto,
        fontSize = fontSize.sp,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Italic,
        modifier = Modifier
            .padding(bottom = 10.dp)
            .padding(start = 8.dp)
    )
}

@Composable
fun mostrarTextoDescricao(texto : String, fontSize: Int ){
    Text(
        texto,
        fontSize = fontSize.sp,
        modifier = Modifier
            .padding(bottom = 10.dp)
            .padding(start = 8.dp)
    )
}
@Composable
fun mostrarTextoPrioridade(prio: String){
    Text(
        prio,
        fontSize = 19.sp,
        modifier = Modifier
            .padding(start = 8.dp)
    )
}