package com.example.creation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.creation.screens.*

@Composable
fun AppNavigation() {
    val navController: NavHostController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.Splash) {
        composable(Routes.Splash) { SplashScreen(navController) }
        composable(Routes.Roles) { RoleSelectionScreen(navController) }

        composable(Routes.LoginPeneliti) { LoginPenelitiScreen(navController) }
        composable(Routes.LoginDataEngineer) { LogindataenginnerScreen(navController) }
        composable(Routes.LoginManajerProyek) { LoginManajerProyek(navController) }

        composable(Routes.RegisterPeneliti) { RegisterPenelitiScreen(navController) }
        composable(Routes.RegisterDataEngineer) { RegisterDataEnginner(navController) }
        composable(Routes.RegisterManajerProyek) { RegisterManajerProyek(navController) }

        composable(Routes.RegisterVerifikasiEmailPeneliti) { VerifikasiEmailScreenPeneliti(navController) }
        composable(Routes.RegisterVerifikasiEmailDataEngineer) { VerifikasiEmailScreenDataEngineer(navController) }
        composable(Routes.RegisterVerifikasiEmailManajerProyek) { VerifikasiEmailScreenManajerProyek(navController) }

        composable(Routes.SelamatBergabungPeneliti) { SelamatBergabungPeneliti(navController) }
        composable(Routes.SelamatBergabungDataEngineer) { SelamatBergabungDataEngineer(navController) }
        composable(Routes.SelamatBergabungManajerProyek) { SelamatBergabungManajerProyek(navController) }

        composable(Routes.DashboardPeneliti) { DashboardPenelitiScreen(navController) }
        composable(Routes.ProfilPeneliti) { ProfilPenelitiScreen(navController) }
        composable(Routes.DashboardPenelitiContent) { DashboardPenelitiContent(navController) }

    }
}
