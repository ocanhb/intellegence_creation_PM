package com.example.creation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import androidx.compose.ui.Alignment
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import com.example.creation.R
import com.example.creation.navigation.Routes


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardPenelitiScreen(navController: NavController) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                DrawerPeneliti(navController)
            }
        },
        drawerState = drawerState
    ) {
        Scaffold(
            modifier = Modifier.background(Color.White), // Background putih pada Scaffold
            topBar = {
                TopAppBar(
                    title = { Text("Peneliti") },
                    navigationIcon = {
                        IconButton(onClick = {
                            coroutineScope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(Icons.Filled.Menu, contentDescription = "Menu")
                        }
                    },
                    actions = {
                        IconButton(onClick = {
                            navController.navigate("profil_peneliti")
                        }) {
                            Icon(Icons.Filled.Person, contentDescription = "Profile")
                        }
                    }
                )
            }
        ) { padding ->
            // Gunakan Modifier di dalam konten untuk mengatur background putih pada bagian konten
            DashboardPenelitiContent(
                modifier = Modifier
                    .padding(padding)
                    .background(Color.White) // Background putih pada konten dashboard
            )
        }
    }
}

@Composable
fun DrawerPeneliti(navController: NavController) {
    val activeRoute = remember { mutableStateOf("dashboard_peneliti") }

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(Color.White)
            .padding(16.dp)
    ) {
        // Logo dan Nama Aplikasi
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo), // Ganti sesuai nama file logo
                contentDescription = "Logo",
                modifier = Modifier
                    .size(40.dp)
                    .padding(end = 8.dp)
            )
            Text("COLLABORAML", fontSize = 20.sp)
        }

        // Nama dan Status
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Default.Person, contentDescription = "User", tint = Color.Gray)
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text("Ocan", fontSize = 16.sp)
                Text("Online", fontSize = 12.sp, color = Color.Gray)
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        val menuItems = listOf(
            "Dashboard" to "dashboard_peneliti",
            "Dataset" to "dataset_screen",
            "Evaluasi Model" to "evaluasi_model",
            "Refining Model" to "refining_model",
            "Training Model" to "training_model"
        )

        menuItems.forEach { (label, route) ->
            val isActive = activeRoute.value == route
            val backgroundColor = if (isActive) Color(0xFF007BFF) else Color.Transparent
            val textColor = if (isActive) Color.White else Color.Black

            Text(
                text = label,
                color = textColor,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(backgroundColor, shape = MaterialTheme.shapes.small)
                    .padding(vertical = 10.dp, horizontal = 8.dp)
                    .clickable {
                        activeRoute.value = route
                        navController.navigate(route)
                    }
            )
        }

        Spacer(modifier = Modifier.weight(1f)) // Biar Logout di bawah
        Text(
            "Logout",
            color = Color.Red,
            modifier = Modifier
                .padding(vertical = 16.dp)
                .clickable {navController.navigate(Routes.LoginPeneliti) }
        )
    }
}


@Composable
fun DashboardPenelitiContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.White) // Background putih pada konten
    ) {
        // Teks "Peneliti" dengan ukuran font yang lebih besar dan warna kontras
        Text(
            text = "Peneliti",
            fontSize = 20.sp, // Menambah ukuran font
            color = Color.Black, // Memberi warna teks hitam
            modifier = Modifier.padding(top = 0.dp) // Memberi sedikit spasi di atas
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Tombol Dataset & Evaluasi
        Row(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = { /* Navigasi ke Dataset */ },
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            ) {
                Text(text = "Dataset")
            }

            Button(
                onClick = { /* Navigasi ke Evaluasi */ },
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp)
            ) {
                Text(text = "Evaluasi Model")
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Tombol Refining & Training
        Row(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = { /* Navigasi ke Refining */ },
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            ) {
                Text(text = "Refining Model")
            }

            Button(
                onClick = { /* Navigasi ke Training */ },
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp)
            ) {
                Text(text = "Training Model")
            }
        }
    }
}
