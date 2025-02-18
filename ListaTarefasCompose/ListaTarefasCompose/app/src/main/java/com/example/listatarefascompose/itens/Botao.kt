package com.example.listatarefascompose.itens

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun Botao( // falta colocar em salvar tarefa
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    texto: String,
)

{
    Button(
        onClick,
        modifier,
    ) {
        Text(text = texto, fontWeight = FontWeight.Bold, fontSize = 18.sp)
    }
}