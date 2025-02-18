package com.example.listatarefascompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.listatarefascompose.ui.theme.ListaTarefasComposeTheme
import com.example.listatarefascompose.view.ListaItens
import com.example.listatarefascompose.view.SalvarItem
import com.example.listatarefascompose.view.SalverItem

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListaTarefasComposeTheme { // Cria um NavController para gerenciar a navegação entre as telas

                val navController = rememberNavController() // Define o NavHost, que gerencia as rotas e as telas correspondentes

                NavHost(navController = navController, startDestination = "listaItens"){

                    // Define a rota "listaItens" e a tela correspondente (ListaItens)

                    composable( route = "listaItens"){
                        ListaItens(navController) // Chama a função Composable ListaItens
                    }

                    // Define a rota "salvarItem" e a tela correspondente (SalvarItens)

                    composable(route = "salvarItem"){
                        SalvarItem(navController) // Chama a função Composable SalvarItens) Item(navController)// Chama a função Composable SalvarItens
                    }
                }
            }
        }
    }
}
