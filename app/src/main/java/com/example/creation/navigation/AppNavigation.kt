package com.example.creation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.creation.screens.Profile.ProfileScreen
import com.example.creation.screens.auth.LoginScreen
import com.example.creation.screens.auth.OtpSuccessScreen
import com.example.creation.screens.auth.OtpVerificationScreen
import com.example.creation.screens.auth.RegisterScreen
import com.example.creation.screens.dashboard.DashboardScreen
import com.example.creation.screens.dataset.ModelingDatasetScreen
import com.example.creation.screens.history.HistoryScreen
import com.example.creation.screens.landing.LandingScreenPageOne
import com.example.creation.screens.landing.LandingScreenPageTwo
import com.example.creation.screens.request.RequestDatasetScreen

sealed class Screen(val route: String) {
    data object LandingOne : Screen("landing_one")
    data object LandingTwo : Screen("landing_two")
    data object Login : Screen("login")
    data object Register : Screen("register")
    data object OtpVerification : Screen("otp_verification")
    data object OtpSuccess : Screen("otp_success")
    data object Dashboard : Screen("dashboard")
    data object Profile : Screen("profile")
    data object DatasetList : Screen("dataset_list")
    data object RequestDataset : Screen("request_dataset")
    data object History : Screen("history")
}

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.LandingOne.route) {
        composable(Screen.LandingOne.route) { LandingScreenPageOne(navController) }
        composable(Screen.LandingTwo.route) { LandingScreenPageTwo(navController) }
        composable(Screen.Login.route) { LoginScreen(navController) }
        composable(Screen.Register.route) { RegisterScreen(navController) }
        composable(Screen.OtpVerification.route) { OtpVerificationScreen(navController) }
        composable(Screen.OtpSuccess.route) { OtpSuccessScreen(navController) }
        composable(Screen.Dashboard.route) { DashboardScreen(navController) }
        composable(Screen.Profile.route) { ProfileScreen(navController) }
        composable(Screen.DatasetList.route) { ModelingDatasetScreen(navController) }
        composable(Screen.RequestDataset.route) { RequestDatasetScreen(navController) }
        composable(Screen.History.route) { HistoryScreen(navController) }
    }
}
