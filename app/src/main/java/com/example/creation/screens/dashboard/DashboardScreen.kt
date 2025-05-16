package com.example.creation.screens.dashboard

import android.annotation.SuppressLint
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.creation.R
import com.example.creation.navigation.Screen
import com.patrykandpatrick.vico.compose.chart.Chart
import com.patrykandpatrick.vico.compose.chart.column.columnChart
import com.patrykandpatrick.vico.core.component.shape.LineComponent
import com.patrykandpatrick.vico.core.entry.ChartEntryModelProducer
import com.patrykandpatrick.vico.core.entry.entryOf
import kotlinx.coroutines.launch

@SuppressLint("RememberReturnType")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navController: NavController) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val modelProducer = remember {
        ChartEntryModelProducer(
            listOf(
                entryOf(0f, 6f),  // Success
                entryOf(1f, 2f),  // Failed
                entryOf(2f, 3f)   // On Going
            )
        )
    }

    val chartColors = listOf(
        Color(0xFF4CAF50), // Green
        Color(0xFFF44336), // Red
        Color(0xFFFFC107)  // Orange
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
                        selected = true,
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
                        selected = false,
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
            containerColor = Color(0xFF121212)
        ) { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Text("Dashboard", color = Color.White, fontSize = 20.sp)
                Spacer(modifier = Modifier.height(8.dp))

                // CARD: Model Status
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Model Status", color = Color.Black, fontSize = 18.sp)
                        Spacer(modifier = Modifier.height(8.dp))

                        Chart(
                            chart = columnChart(
                                columns = chartColors.map { color ->
                                    LineComponent(color = color.toArgb())
                                }
                            ),
                            chartModelProducer = modelProducer,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(250.dp) // Dibuat lebih tinggi
                        )

                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            Text("Success", color = chartColors[0])
                            Text("Failed", color = chartColors[1])
                            Text("On Going", color = chartColors[2])
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // CARD: Aktivitas Terbaru
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Aktivitas Terbaru", color = Color.Black, fontSize = 18.sp)
                        Spacer(modifier = Modifier.height(8.dp))

                        // Header
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                        ) {
                            Text("Judul", modifier = Modifier.weight(0.5f), color = Color.Gray, fontSize = 13.sp)
                            Text("Kategori", modifier = Modifier.weight(0.25f), color = Color.Gray, fontSize = 13.sp)
                            Text("Status", modifier = Modifier.weight(0.25f), color = Color.Gray, fontSize = 13.sp)
                        }

                        Spacer(modifier = Modifier.height(4.dp))

                        val aktivitas = listOf(
                            Triple("Prediksi Harga Rumah", "Regresi", "Success"),
                            Triple("Training Titanic", "Klasifikasi", "On Going"),
                            Triple("Prediksi Cuaca", "Forecasting", "Success"),
                            Triple("Train.csv (Dataset)", "Klasifikasi", "Failed"),
                            Triple("Project Management Task", "Regresi", "On Going")
                        )

                        aktivitas.forEach { (judul, kategori, status) ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 4.dp)
                            ) {
                                Text(judul, modifier = Modifier.weight(0.5f), color = Color.Black, fontSize = 13.sp)
                                Text(kategori, modifier = Modifier.weight(0.25f), color = Color.DarkGray, fontSize = 13.sp)
                                Text(
                                    text = status,
                                    modifier = Modifier.weight(0.25f),
                                    color = when (status) {
                                        "Success" -> chartColors[0]
                                        "Failed" -> chartColors[1]
                                        "On Going" -> chartColors[2]
                                        else -> Color.Black
                                    },
                                    fontSize = 13.sp
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
