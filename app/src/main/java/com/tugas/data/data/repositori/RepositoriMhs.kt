package com.tugas.data.data.repositori

import com.tugas.data.data.entity.Mahasiswa
import kotlinx.coroutines.flow.Flow

interface RepositoriMhs {
    suspend fun insertMhs(mahasiswa: Mahasiswa)
    suspend fun deleteMhs(mahasiswa: Mahasiswa)
    suspend fun updateMhs(mahasiswa: Mahasiswa)
    fun getAllMhs(): Flow<List<Mahasiswa>>
    fun getMhs(nim: String): Flow<Mahasiswa>
}