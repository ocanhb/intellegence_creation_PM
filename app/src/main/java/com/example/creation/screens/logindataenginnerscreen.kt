package com.example.creation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
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

@Composable
fun LogindataenginnerScreen(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Logo di atas
        Image(
            painter = painterResource(id = R.drawable.icon),
            contentDescription = "Login Data Engineer",
            modifier = Modifier
                .size(200.dp) // Sesuaikan ukuran
                .padding(bottom = 16.dp)
        )

        Text("Login Data Engineer", style = MaterialTheme.typography.headlineSmall)

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Kata sandi") },
            leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(onClick = { /* Aksi login */ }, modifier = Modifier.fillMaxWidth()) {
            Text("Masuk")
        }

        Button(onClick = { navController.navigate(Routes.RegisterPeneliti)}, modifier = Modifier.fillMaxWidth()) {
            Text("register")
        }
    }
}
