package com.tugas.data.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tugas.data.ui.view.mahasiswa.DestinasiInsert
import com.tugas.data.ui.view.mahasiswa.HomeMhsView
import com.tugas.data.ui.view.mahasiswa.InsertMhsView

@Composable
fun PengelolaHalaman(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
){
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route
    )
    {
        composable(
            route = DestinasiHome.route
        ){
            HomeMhsView(
                onDetailClick = { nim ->
                    navController.navigate("${DestinasiDetail.route}/$nim")
                    println("PengelolaHalaman: nim = $nim")
                },
                onAddMhs = {
                    navController.navigate(DestinasiInsert.route)
                },
                modifier = modifier)
        }
        composable(
            route = DestinasiInsert.route
        ){
            InsertMhsView(onBack = {
                navController.popBackStack()
            },
                onNavigate = {
                    navController.popBackStack()
                },
                modifier = modifier)
        }
        composable(
            DestinasiDetail.routeWithArg,
            arguments = listOf(
                navArgument(DestinasiDetail.NIM){
                    type = NavType.StringType
                }
            )
        ){