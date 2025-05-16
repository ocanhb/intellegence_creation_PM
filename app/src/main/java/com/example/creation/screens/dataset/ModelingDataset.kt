package com.example.creation.screens.dataset

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.creation.R
import com.example.creation.navigation.Screen
import kotlinx.coroutines.launch

data class DatasetItem(
    val objective: String,
    val target: String,
    val category: String,
    val status: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModelingDatasetScreen(navController: NavController) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val datasetList = listOf(
        DatasetItem("Prediksi Harga Rumah", "Harga", "Regresi", "Success"),
        DatasetItem("Training Titanic", "Survival", "Klasifikasi", "On Going"),
        DatasetItem("Prediksi Cuaca", "Cuaca", "Forecasting", "Success"),
        DatasetItem("Deteksi Status Tiket", "Status", "Klasifikasi", "Success"),
        DatasetItem("Estimasi Deadline Proyek", "Task", "Regresi", "On Going"),
        DatasetItem("Prediksi Penjualan", "Penjualan", "Regresi", "Success"),
        DatasetItem("Analisis Review Produk", "Review", "Klasifikasi", "Failed"),
        DatasetItem("Deteksi Email Spam", "Spam", "Klasifikasi", "Success"),
        DatasetItem("Evaluasi Kepuasan Pengguna", "Kepuasan", "Regresi", "On Going"),
        DatasetItem("Segmentasi Pengunjung Web", "Click", "Clustering", "Pending"),
        DatasetItem("Prediksi Kehadiran Karyawan", "Absen", "Forecasting", "Deployed")
    )

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(drawerContainerColor = Color.White) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.logo),
                            contentDescription = "Logo",
                            modifier = Modifier.size(40.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("COLLABORAML", color = Color(0xFF2196F3), fontSize = 18.sp)
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Person, contentDescription = "User")
                        Spacer(modifier = Modifier.width(8.dp))
                        Column {
                            Text("Ocan", color = Color.Black)
                            Text("Online", fontSize = 12.sp, color = Color.Gray)
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    NavigationDrawerItem(
                        label = { Text("Dashboard", color = Color.Black) },
                        selected = false,
                        onClick = { navController.navigate(Screen.Dashboard.route) }
                    )
                    NavigationDrawerItem(
                        label = { Text("Modeling Dataset", color = Color.Black) },
                        selected = true,
                        onClick = { /* udah di sini, bisa dihapus atau dikasih fungsi reload */ }
                    )
                    NavigationDrawerItem(
                        label = { Text("Request Dataset", color = Color.Black) },
                        selected = false,
                        onClick = { navController.navigate(Screen.RequestDataset.route) }
                    )
                    NavigationDrawerItem(
                        label = { Text("History", color = Color.Black) },
                        selected = false,
                        onClick = { navController.navigate(Screen.History.route) }
                    )

                    Spacer(modifier = Modifier.height(16.dp))
                    Text("Logout", color = Color.Red, modifier = Modifier.padding(8.dp))
                }
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(id = R.drawable.logo),
                                contentDescription = "Logo",
                                modifier = Modifier.size(28.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("COLLABORAML", color = Color(0xFF2196F3), fontSize = 16.sp)
                        }
                    },
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    },
                    actions = {
                        IconButton(onClick = { /* Profile Action */ }) {
                            Icon(Icons.Default.Person, contentDescription = "Profile")
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.DarkGray)
                )
            },
            containerColor = Color(0xFF121212)
        ) { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Text("Daftar Model Dataset", fontSize = 20.sp, fontWeight = androidx.compose.ui.text.font.FontWeight.Bold, color = Color.White)
                Spacer(modifier = Modifier.height(16.dp))

                datasetList.forEachIndexed { index, item ->
                    androidx.compose.material3.Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp),
                        shape = androidx.compose.foundation.shape.RoundedCornerShape(12.dp),
                        elevation = androidx.compose.material3.CardDefaults.cardElevation(4.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text("#${index + 1}. ${item.objective}", fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)

                            Spacer(modifier = Modifier.height(8.dp))

                            Text("🎯 Target: ${item.target}")
                            Text("📂 Category: ${item.category}")
                            Text(
                                "📊 Status: ${item.status}",
                                color = when (item.status) {
                                    "Success" -> Color(0xFF4CAF50)
                                    "On Going" -> Color(0xFFFFC107)
                                    "Failed" -> Color(0xFFF44336)
                                    "Pending" -> Color.Gray
                                    "Deployed" -> Color(0xFF3F51B5)
                                    else -> Color.Black
                                }
                            )

                            Spacer(modifier = Modifier.height(12.dp))

                            Row(
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Button(
                                    onClick = { /* TODO: View */ },
                                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3)),
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Text("View", color = Color.White)
                                }
                                Button(
                                    onClick = { /* TODO: Edit */ },
                                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFC107)),
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Text("Edit", color = Color.Black)
                                }
                                Button(
                                    onClick = { /* TODO: Delete */ },
                                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF44336)),
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Text("Delete", color = Color.White)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
