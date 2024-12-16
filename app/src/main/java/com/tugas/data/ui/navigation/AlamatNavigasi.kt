package com.tugas.data.ui.navigation

interface AlamatNavigasi {
    val route: String
}

object DestinasiHome : AlamatNavigasi {
    override val route: String = "home"
}

object DestinasiDetail : AlamatNavigasi {
    override val route: String = "detail"
    const val NIM = "nim"
    val routeWithArg = "$route/{$NIM}"
}

object DestinasiUpdate : AlamatNavigasi {
    override val route: String = "update"
    const val NIM = "nim"
    val routeWithArg = "$route/{$NIM}"

}