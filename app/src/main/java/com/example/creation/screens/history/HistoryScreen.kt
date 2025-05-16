package com.example.creation.screens.history

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
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
import kotlinx.coroutines.launch


data class HistoryItem(
    val id: String,
    val objective: String,
    val from: String,
    val target: String,
    val features: String,
    val dataType: String,
    val category: String,
    val accuracy: String,
    val start: String,
    val end: String,
    val deployment: String
)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryScreen(navController: NavController) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val allItems = listOf(
        HistoryItem("01", "Prediksi Harga Rumah", "Engineering", "Harga", "Luas, Lokasi", "JSON", "Regresi", "92%", "01/01", "04/01", "Deployed"),
        HistoryItem("02", "Analisis Kelangsungan Hidup", "Dataset", "Survival", "Umur, Gender", "CSV", "Klasifikasi", "87%", "02/01", "06/01", "Pending"),
        HistoryItem("03", "Prediksi Cuaca Harian", "Implementation", "Cuaca", "Suhu, Tekanan", "Excel", "Forecasting", "78%", "05/01", "08/01", "Deployed"),
        HistoryItem("04", "Analisis Penumpang Titanic", "Dataset", "Status", "Fare, Cabin", "CSV", "Klasifikasi", "90%", "06/01", "08/01", "Deployed"),
        HistoryItem("05", "Task Estimation", "Project Mgmt", "Task", "Deadline, Status", "Manual", "Regresi", "88%", "07/01", "10/01", "On Going"),
        HistoryItem("06", "Prediksi Penjualan Produk", "Business", "Penjualan", "Umur, Produk", "Excel", "Regresi", "85%", "11/01", "13/01", "Success"),
        HistoryItem("07", "Klasifikasi Review Pelanggan", "AI Lab", "Review", "Kata Kunci", "CSV", "Klasifikasi", "91%", "12/01", "15/01", "Failed"),
        HistoryItem("08", "Deteksi Email Spam", "Dataset", "Spam", "Email, Kata", "TXT", "Klasifikasi", "89%", "14/01", "18/01", "Success"),
        HistoryItem("09", "Kepuasan Pelanggan", "Research", "Kepuasan", "Nilai, Komentar", "Form", "Regresi", "86%", "16/01", "19/01", "On Going"),
        HistoryItem("10", "Click Prediction", "Team X", "Click", "Halaman, Waktu", "CSV", "Clustering", "80%", "18/01", "20/01", "Pending"),
        HistoryItem("11", "Forecast Kehadiran", "Prototype", "Absen", "Jam, Lokasi", "XLSX", "Forecasting", "83%", "19/01", "22/01", "Deployed")
    )

    var searchText by remember { mutableStateOf("") }
    var selectedFilter by remember { mutableStateOf("All") }
    var expanded by remember { mutableStateOf(false) }
    val statusOptions = listOf("All", "Deployed", "Pending", "Success", "Failed", "On Going")

    val filteredItems = allItems.filter {
        it.objective.contains(searchText, ignoreCase = true) &&
                (selectedFilter == "All" || it.deployment == selectedFilter)
    }

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
                        selected = false,
                        onClick = { navController.navigate(Screen.DatasetList.route) }
                    )
                    NavigationDrawerItem(
                        label = { Text("Request Dataset", color = Color.Black) },
                        selected = false,
                        onClick = { navController.navigate(Screen.RequestDataset.route) }
                    )
                    NavigationDrawerItem(
                        label = { Text("History", color = Color.Black) },
                        selected = true,
                        onClick = { navController.navigate(Screen.History.route) }
                    )

                    Spacer(modifier = Modifier.height(16.dp))
                    Text("Logout", color = Color.Red)
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
                        IconButton(onClick = { }) {
                            Icon(Icons.Default.Person, contentDescription = "Profile")
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.DarkGray)
                )
            },
            containerColor = Color(0xFFF5F5F5)
        ) { padding ->
            Column(modifier = Modifier.padding(padding).padding(16.dp)) {
                Text(
                    "Riwayat Model dan Deployment",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 8.dp)
                )


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    OutlinedTextField(
                        value = searchText,
                        onValueChange = { searchText = it },
                        label = { Text("Cari Objective") },
                        leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                        modifier = Modifier.weight(1f)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Box(modifier = Modifier.wrapContentSize()) {
                        OutlinedButton(onClick = { expanded = true }) {
                            Text(selectedFilter)
                            Icon(Icons.Filled.ArrowDropDown, contentDescription = null)
                        }
                        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                            statusOptions.forEach { option ->
                                DropdownMenuItem(
                                    text = { Text(option) },
                                    onClick = {
                                        selectedFilter = option
                                        expanded = false
                                    }
                                )
                            }
                        }
                    }
                }

                LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(filteredItems) { item ->
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            elevation = CardDefaults.cardElevation(2.dp)
                        ) {
                            Column(modifier = Modifier.padding(12.dp)) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text("${item.id}. ${item.objective}", fontWeight = FontWeight.Bold)
                                    Text(item.deployment, color = Color.Blue)
                                }

                                Spacer(modifier = Modifier.height(4.dp))
                                Text("From: ${item.from}")
                                Text("Target: ${item.target}")
                                Text("Features: ${item.features}")
                                Text("Jenis Data: ${item.dataType}")
                                Text("Category: ${item.category}")
                                Text("Accuracy: ${item.accuracy}")
                                Text("Start: ${item.start} | End: ${item.end}")

                                Spacer(modifier = Modifier.height(8.dp))
                                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                    Button(
                                        onClick = { /* TODO: Export to PDF */ },
                                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00BFFF))
                                    ) {
                                        Text("PDF")
                                    }
                                    Button(
                                        onClick = { /* TODO: Print */ },
                                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF32CD32))
                                    ) {
                                        Text("Print")
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}