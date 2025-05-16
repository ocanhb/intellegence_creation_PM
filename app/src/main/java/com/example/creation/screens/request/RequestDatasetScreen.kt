package com.example.creation.screens.request

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.creation.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RequestDatasetScreen(navController: NavController) {
    var problemName by remember { mutableStateOf("") }
    var predictionTarget by remember { mutableStateOf("") }
    var features by remember { mutableStateOf("") }
    var objective by remember { mutableStateOf("") }
    var refiningStrategy by remember { mutableStateOf("") }

    val datasetTypes = listOf("Regresi", "Klasifikasi")
    var selectedDatasetType by remember { mutableStateOf(datasetTypes[0]) }

    val trainingStatuses = listOf("Belum Dilatih", "Sudah Dilatih")
    var selectedTrainingStatus by remember { mutableStateOf(trainingStatuses[0]) }

    val refiningStatuses = listOf("Belum", "Sudah")
    var selectedRefiningStatus by remember { mutableStateOf(refiningStatuses[0]) }

    val categories = listOf("Teknikal", "Non-Teknikal")
    var selectedCategory by remember { mutableStateOf(categories[0]) }

    var startDate by remember { mutableStateOf("") }
    var endDate by remember { mutableStateOf("") }

    var selectedFileName by remember { mutableStateOf("Choose File (.csv)") }

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
                    IconButton(onClick = {
                        navController.navigateUp()
                    }) {
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
        }
    )

    { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text("Request Dataset", fontSize = 20.sp, fontWeight = FontWeight.Bold)

            OutlinedTextField(
                value = problemName,
                onValueChange = { problemName = it },
                label = { Text("Problem Name") },
                placeholder = { Text("Contoh: Prediksi Harga Rumah") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = predictionTarget,
                onValueChange = { predictionTarget = it },
                label = { Text("Prediction Target") },
                placeholder = { Text("Contoh: Harga") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = features,
                onValueChange = { features = it },
                label = { Text("Features") },
                placeholder = { Text("Contoh: Luas, Lokasi") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = objective,
                onValueChange = { objective = it },
                label = { Text("Objective") },
                placeholder = { Text("Contoh: Prediksi berdasarkan lokasi") },
                modifier = Modifier.fillMaxWidth()
            )

            DropdownSelector(
                label = "Dataset Type",
                options = datasetTypes,
                selectedOption = selectedDatasetType,
                onOptionSelected = { selectedDatasetType = it }
            )

            DropdownSelector(
                label = "Training Status",
                options = trainingStatuses,
                selectedOption = selectedTrainingStatus,
                onOptionSelected = { selectedTrainingStatus = it }
            )

            OutlinedTextField(
                value = refiningStrategy,
                onValueChange = { refiningStrategy = it },
                label = { Text("Refining Strategy") },
                modifier = Modifier.fillMaxWidth()
            )

            DropdownSelector(
                label = "Refining Status",
                options = refiningStatuses,
                selectedOption = selectedRefiningStatus,
                onOptionSelected = { selectedRefiningStatus = it }
            )

            DropdownSelector(
                label = "Category",
                options = categories,
                selectedOption = selectedCategory,
                onOptionSelected = { selectedCategory = it }
            )

            OutlinedTextField(
                value = startDate,
                onValueChange = { startDate = it },
                label = { Text("Start Date") },
                placeholder = { Text("dd/mm/yyyy") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = endDate,
                onValueChange = { endDate = it },
                label = { Text("End Date") },
                placeholder = { Text("dd/mm/yyyy") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = "Univariate, Multivariate, Feature Engineering",
                onValueChange = {},
                label = { Text("Aktivitas Pemrosesan Data") },
                readOnly = true,
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = { selectedFileName = "dataset.csv" },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(selectedFileName)
            }

            Button(
                onClick = { /* TODO: Submit logic */ },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Submit")
            }
        }
    }
}

@Composable
fun DropdownSelector(
    label: String,
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Column {
        OutlinedTextField(
            value = selectedOption,
            onValueChange = {},
            readOnly = true,
            label = { Text(label) },
            trailingIcon = {
                IconButton(onClick = { expanded = !expanded }) {
                    Icon(
                        imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                        contentDescription = null
                    )
                }
            },
            modifier = Modifier.fillMaxWidth()
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        onOptionSelected(option)
                        expanded = false
                    }
                )
            }
        }
    }
}
