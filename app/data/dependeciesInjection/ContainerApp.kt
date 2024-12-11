package com.tugas.questdata.data.dependeciesInjection

import android.content.Context
import com.tugas.questdata.data.database.KrsDatabase
import com.tugas.questdata.data.repositori.LokalRepositoriMhs
import com.tugas.questdata.data.repositori.RepositoriMhs

interface InterfaceContainerApp {
    val repositoriMhs: RepositoriMhs
}

class ContainerApp(private val context: Context) : InterfaceContainerApp {
    override val repositoriMhs: RepositoriMhs by lazy {
        LokalRepositoriMhs(KrsDatabase.getDatabase(context).mahasiswaDao())
    }
}