package com.example.eventia.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eventia.ui.theme.EventiaTheme

private val EventiaPurple = Color(0xFF6750A4)
private val EventiaLightPurple = Color(0xFFEADDFF)
private val EventiaBackground = Color(0xFFF9F7FC)

@Composable
fun HomeScreen(
    onEventosClick: () -> Unit = {},
    onLugaresClick: () -> Unit = {},
    onParticipantesClick: () -> Unit = {},
    onInscripcionesClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape),
                color = EventiaPurple
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(
                        text = "E",
                        color = Color.White,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Column(modifier = Modifier.padding(start = 14.dp)) {
                Text(
                    text = "Eventia",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = EventiaPurple
                )
                Text(
                    text = "Organiza tus eventos fácilmente",
                    color = Color.Gray
                )
            }
        }

        Spacer(modifier = Modifier.height(28.dp))

        Card(
            colors = CardDefaults.cardColors(
                containerColor = EventiaLightPurple
            ),
            shape = RoundedCornerShape(20.dp)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(
                    text = "Panel de administración",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Gestiona eventos, lugares, participantes e inscripciones desde un solo lugar.",
                    lineHeight = 22.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(28.dp))

        Text(
            text = "¿Qué deseas administrar?",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            MenuCard(
                modifier = Modifier.weight(1f),
                symbol = "EV",
                title = "Eventos",
                description = "Crear y consultar",
                onClick = onEventosClick
            )

            MenuCard(
                modifier = Modifier.weight(1f),
                symbol = "LU",
                title = "Lugares",
                description = "Espacios y cupos",
                onClick = onLugaresClick
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            MenuCard(
                modifier = Modifier.weight(1f),
                symbol = "PA",
                title = "Participantes",
                description = "Personas registradas",
                onClick = onParticipantesClick
            )

            MenuCard(
                modifier = Modifier.weight(1f),
                symbol = "IN",
                title = "Inscripciones",
                description = "Control de asistencia",
                onClick = onInscripcionesClick
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Los datos se guardarán en el dispositivo para que puedas consultarlos incluso sin conexión.",
            modifier = Modifier.fillMaxWidth(),
            color = Color.Gray,
            textAlign = TextAlign.Center,
            fontSize = 13.sp
        )
    }
}

@Composable
private fun MenuCard(
    modifier: Modifier = Modifier,
    symbol: String,
    title: String,
    description: String,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .height(150.dp)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = EventiaBackground
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Surface(
                modifier = Modifier.size(46.dp),
                shape = CircleShape,
                color = EventiaLightPurple
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(
                        text = symbol,
                        color = EventiaPurple,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Text(
                text = description,
                color = Color.Gray,
                fontSize = 12.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    EventiaTheme {
        HomeScreen()
    }
}