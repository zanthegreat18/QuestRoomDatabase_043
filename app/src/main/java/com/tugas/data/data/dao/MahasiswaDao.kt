package com.tugas.data.data.dao

import androidx.room.Dao
import androidx.room.Insert
import com.tugas.data.data.entity.Mahasiswa


@Dao
interface MahasiswaDao {
    @Insert
    suspend fun insertMahasiswa(mahasiswa: Mahasiswa)
}