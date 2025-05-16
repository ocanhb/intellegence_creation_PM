package com.example.creation.screens.landing

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.creation.navigation.Screen

@Composable
fun LandingScreenPageTwo(navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFEAF0F9) // warna latar biru muda
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Intelligence Creation",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Proyek: Pengembangan aplikasi pengelolaan perancangan dan pengujian perangkat lunak",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Aplikasi ini digunakan untuk mengelola pengembangan perangkat lunak sehingga memenuhi standar pengembangan yang telah ditetapkan. Adapun kemampuan aplikasi ini sebagai berikut:",
                fontSize = 12.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(12.dp))

            val tugasList = listOf(
                "1. Merekam hasil problem framing dan model perangkat lunak dalam model Input, Proses, Output.",
                "2. Merekam pendefinisian model dataset yang perlu dibangun.",
                "3. Merekam hasil aktivitas pemrosesan data, termasuk analisis univariat/multivariat dan rekayasa fitur.",
                "4. Merekam perencanaan model cerdas dan perencanaan refining model.",
                "5. Merekam hasil pelatihan dan pengujian model.",
                "6. Merekam hasil refining model.",
                "7. Merekam materi komunikasi teknikal.",
                "8. Merekam materi komunikasi dengan pihak manajemen."
            )
            tugasList.forEach {
                Text(text = it, fontSize = 12.sp, color = Color.Black, modifier = Modifier.padding(vertical = 1.dp))
            }
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = { navController.navigate(Screen.Login.route) },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0070D2))
            ) {
                Text("Masuk ke Aplikasi", color = Color.White)
            }
        }
    }
}
