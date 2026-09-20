package com.example.eventia.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.eventia.ui.screens.HomeScreen
import com.example.eventia.ui.screens.SectionScreen

private object Routes {
    const val HOME = "home"
    const val EVENTOS = "eventos"
    const val LUGARES = "lugares"
    const val PARTICIPANTES = "participantes"
    const val INSCRIPCIONES = "inscripciones"
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.HOME
    ) {
        composable(Routes.HOME) {
            HomeScreen(
                onEventosClick = {
                    navController.navigate(Routes.EVENTOS)
                },
                onLugaresClick = {
                    navController.navigate(Routes.LUGARES)
                },
                onParticipantesClick = {
                    navController.navigate(Routes.PARTICIPANTES)
                },
                onInscripcionesClick = {
                    navController.navigate(Routes.INSCRIPCIONES)
                }
            )
        }

        composable(Routes.EVENTOS) {
            SectionScreen(
                title = "Eventos",
                description = "Crea, consulta y administra tus eventos.",
                onBackClick = { navController.popBackStack() }
            )
        }

        composable(Routes.LUGARES) {
            SectionScreen(
                title = "Lugares",
                description = "Administra espacios, ubicaciones y capacidades.",
                onBackClick = { navController.popBackStack() }
            )
        }

        composable(Routes.PARTICIPANTES) {
            SectionScreen(
                title = "Participantes",
                description = "Registra y consulta a las personas participantes.",
                onBackClick = { navController.popBackStack() }
            )
        }

        composable(Routes.INSCRIPCIONES) {
            SectionScreen(
                title = "Inscripciones",
                description = "Controla las inscripciones y el cupo disponible.",
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}