package com.example.creation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.creation.navigation.Routes

@Composable
fun RoleSelectionScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Pilih Peran anda", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(20.dp))

        // Button untuk Peneliti
        Button(onClick = { navController.navigate(Routes.LoginPeneliti) }) {
            Text("Peneliti")
        }
        Spacer(modifier = Modifier.height(10.dp))

        // Button untuk Data Engineer
        Button(onClick = { navController.navigate(Routes.LoginDataEngineer) }) {
            Text("Data Engineer")
        }
        Spacer(modifier = Modifier.height(10.dp))

        // Button untuk Manajer Proyek
        Button(onClick = { navController.navigate(Routes.LoginManajerProyek) }) {
            Text("Manajer Proyek")
        }
    }
}
