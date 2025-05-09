package com.example.creation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.creation.navigation.Routes
import androidx.compose.foundation.Image
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import com.example.creation.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.TextStyle
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

@Composable
fun ProfilPenelitiScreen(navController: NavController) {
    var nama by remember { mutableStateOf("Aiko") }
    var email by remember { mutableStateOf("aiko@gmail.com") }
    var gender by remember { mutableStateOf("Perempuan") }
    var phone by remember { mutableStateOf("081546195474") }
    var alamat by remember {
        mutableStateOf("Jl. Ruhul Rahayu, RT 30 No 31 Kecamatan Balikpapan Selatan, Kota Balikpapan, Provinsi Kalimantan Timur")
    }
    var job by remember { mutableStateOf("Data Engineer") }

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Header
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
            }
            Text("Foto Profil", fontSize = 20.sp)
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Foto profil
        Image(
            painter = painterResource(id = R.drawable.icon), // Ganti sesuai nama file kamu
            contentDescription = "Foto Profil",
            modifier = Modifier
                .size(75.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Tombol upload & kamera
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(
                onClick = { /* Upload */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF90CAF9))
            ) {
                Text("Upload dari File")
            }
            Button(
                onClick = { /* Kamera */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF90CAF9))
            ) {
                Text("Ambil dari Kamera")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Form input
        OutlinedTextField(
            value = nama,
            onValueChange = { nama = it },
            label = { Text("Nama", color = Color(0xFF6200EE)) },
            textStyle = TextStyle(color = Color.Black),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email", color = Color(0xFF6200EE)) },
            textStyle = TextStyle(color = Color.Black),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = gender,
            onValueChange = { gender = it },
            label = { Text("Jenis Kelamin", color = Color(0xFF6200EE)) },
            textStyle = TextStyle(color = Color.Black),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = phone,
            onValueChange = { phone = it },
            label = { Text("Nomor HP", color = Color(0xFF6200EE)) },
            textStyle = TextStyle(color = Color.Black),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = alamat,
            onValueChange = { alamat = it },
            label = { Text("Alamat", color = Color(0xFF6200EE)) },
            textStyle = TextStyle(color = Color.Black),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = job,
            onValueChange = { job = it },
            label = { Text("Job", color = Color(0xFF6200EE)) },
            textStyle = TextStyle(color = Color.Black),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Tombol Simpan
        Button(
            onClick = { /* Simpan */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))
        ) {
            Text("Simpan", color = Color.White, fontSize = 18.sp)
        }
    }
}
