package com.example.creation.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController

@Composable
fun DashboardPenelitiContent(navController: NavController) {
    var drawerOpen by remember { mutableStateOf(false) }}