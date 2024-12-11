package com.tugas.data.data.repositori

import com.tugas.data.data.entity.Mahasiswa

interface RepositoriMhs {
    suspend fun insertMhs(mahasiswa: Mahasiswa)
}