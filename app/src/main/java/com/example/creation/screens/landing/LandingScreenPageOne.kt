package com.example.creation.screens.landing

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.creation.R
import com.example.creation.navigation.Screen

@Composable
fun LandingScreen(navController: NavController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFF5F9FF)
    ) {
        Row(modifier = Modifier.fillMaxSize()) {
            // Kiri: Logo & branding
            LandingLeftColumn(modifier = Modifier.weight(1f))

            // Kanan: Judul & deskripsi
            LandingRightColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(32.dp),
                navController = navController
            )
        }
    }
}

@Composable
private fun LandingLeftColumn(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxHeight()
            .padding(48.dp),
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
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF0070D2)
        )

        Text(
            text = "Intelligence Creation",
            fontSize = 16.sp,
            color = Color.Gray
        )
    }
}

@Composable
private fun LandingRightColumn(modifier: Modifier = Modifier, navController: NavController) {
    Column(
        modifier = modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Intelligence Creation",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Proyek: Pengembangan aplikasi pengelolaan perancangan dan pengujian perangkat lunak",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Aplikasi ini digunakan untuk mengelola pengembangan perangkat lunak sehingga memenuhi standar pengembangan yang telah ditetapkan. Adapun kemampuan aplikasi ini sebagai berikut:",
            fontSize = 16.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(16.dp))

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
            Text(text = it, fontSize = 14.sp, color = Color.Black, modifier = Modifier.padding(vertical = 2.dp))
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { navController.navigate(Screen.Login.route) },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0070D2))
        ) {
            Text("Masuk ke Aplikasi", color = Color.White)
        }
    }
}
