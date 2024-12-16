package com.tugas.data.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.tugas.data.ui.view.mahasiswa.DestinasiInsert
import com.tugas.data.ui.view.mahasiswa.DetailMhsView
import com.tugas.data.ui.view.mahasiswa.HomeMhsView
import com.tugas.data.ui.view.mahasiswa.InsertMhsView
import com.tugas.data.ui.view.mahasiswa.UpdateMhsView

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
            val nim = it.arguments?.getString(DestinasiDetail.NIM)
            nim?.let { nim ->
                DetailMhsView(
                    onBack = {
                        navController.popBackStack()
                    },
                    onEditClick = {
                        navController.navigate("${DestinasiUpdate.route}/$it")
                    },
                    modifier = modifier,
                    onDeleteClick = {
                        navController.popBackStack()
                    }
                )
            }
        }
        composable(
            DestinasiUpdate.routeWithArg,
            arguments = listOf(
                navArgument(DestinasiUpdate.NIM){
                    type = NavType.StringType
                }
            )
        ){
            UpdateMhsView(
                onBack = {
                    navController.popBackStack()
                },
                onNavigate = {
                    navController.popBackStack()
                },
                modifier = modifier
            )
        }
    }
}