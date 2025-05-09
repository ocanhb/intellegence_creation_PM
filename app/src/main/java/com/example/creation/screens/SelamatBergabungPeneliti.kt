package com.example.creation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.creation.navigation.Routes

@Composable
fun SelamatBergabungPeneliti(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.Default.CheckCircle,
            contentDescription = "Success Icon",
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .size(80.dp)
                .padding(bottom = 24.dp)
        )

        Text(
            text = "Selamat Bergabung\nPeneliti CollaboraML!",
            textAlign = TextAlign.Center,
            fontSize = 22.sp,
            lineHeight = 28.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "Akun Anda telah berhasil diverifikasi.\nSilakan login untuk mulai bekerja sama.",
            textAlign = TextAlign.Center,
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        Button(
            onClick = { navController.navigate(Routes.LoginPeneliti) },
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text("LOGIN")
        }
    }
}
