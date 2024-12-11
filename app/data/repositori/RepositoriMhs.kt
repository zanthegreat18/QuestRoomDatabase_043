package com.tugas.questdata.data.repositori

import com.tugas.questdata.data.entity.Mahasiswa

interface RepositoriMhs {
    suspend fun insertMhs(mahasiswa: Mahasiswa)
}