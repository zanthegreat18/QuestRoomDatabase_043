package com.tugas.data

import android.app.Application
import com.tugas.data.data.dependeciesInjection.ContainerApp

class KrsApp : Application() {
    lateinit var containerApp: ContainerApp  //fungsinya untuk menyimpan intance
    override fun onCreate() {
        super.onCreate()
        containerApp = ContainerApp(this) //membuat intance ContainerApp
        //intance adalah object yang di buat dari kelas
    }
}