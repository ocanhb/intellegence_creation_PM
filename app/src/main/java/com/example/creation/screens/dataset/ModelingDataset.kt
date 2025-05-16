package com.example.creation.screens.dataset

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

data class DatasetItem(val id: Int, val name: String)

@Composable
fun DatasetListScreen(navController: NavController) {
    val datasetList = remember {
        listOf(
            DatasetItem(1, "Dataset Kendaraan"),
            DatasetItem(2, "Dataset Cuaca"),
            DatasetItem(3, "Dataset Transaksi")
        )
    }

    var selectedItem by remember { mutableStateOf<DatasetItem?>(null) }
    var showViewDialog by remember { mutableStateOf(false) }
    var showEditDialog by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(modifier = Modifier.padding(24.dp)) {
            Text(
                text = "Model Dataset",
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(datasetList) { item ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surfaceVariant
                        )
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(item.name)

                            Row {
                                TextButton(onClick = {
                                    selectedItem = item
                                    showViewDialog = true
                                }) {
                                    Text("View")
                                }

                                TextButton(onClick = {
                                    selectedItem = item
                                    showEditDialog = true
                                }) {
                                    Text("Edit")
                                }
                            }
                        }
                    }
                }
            }
        }

        // Dialog View
        if (showViewDialog && selectedItem != null) {
            ViewDatasetDialog(item = selectedItem!!) {
                showViewDialog = false
            }
        }

        // Dialog Edit
        if (showEditDialog && selectedItem != null) {
            EditDatasetDialog(item = selectedItem!!) {
                showEditDialog = false
            }
        }
    }
}
