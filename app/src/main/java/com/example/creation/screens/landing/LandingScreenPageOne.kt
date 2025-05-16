package com.example.creation.screens.landing

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.creation.R
import kotlinx.coroutines.delay

@Composable
fun LandingScreenPageOne(navController: NavController) {
    LaunchedEffect(Unit) {
        delay(2000) // tunggu 2 detik lalu lanjut ke halaman dua
        navController.navigate("landing_two") {
            popUpTo("landing_one") { inclusive = true } // hapus landing_one dari backstack
        }
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFEAF0F9) // warna latar biru muda
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo Collaboraml",
                modifier = Modifier.size(150.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "COLLABORAML",
                style = MaterialTheme.typography.headlineLarge,
                color = Color(0xFF0070D2) // warna biru untuk teks
            )
        }
    }
}
