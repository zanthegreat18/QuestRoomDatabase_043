package com.tugas.data.data.dependeciesInjection

import android.content.Context
import com.tugas.data.data.database.KrsDatabase
import com.tugas.data.data.repositori.LokalRepositoriMhs
import com.tugas.data.data.repositori.RepositoriMhs

interface InterfaceContainerApp {
    val repositoriMhs: RepositoriMhs
}

class ContainerApp(private val context: Context) : InterfaceContainerApp {
    override val repositoriMhs: RepositoriMhs by lazy {
        LokalRepositoriMhs(KrsDatabase.getDatabase(context).mahasiswaDao())
    }
}