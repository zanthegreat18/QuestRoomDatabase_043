package com.tugas.data.data.repositori

import com.tugas.data.data.dao.MahasiswaDao
import com.tugas.data.data.entity.Mahasiswa

class LokalRepositoriMhs(
    private val mahasiswaDao: MahasiswaDao
) : RepositoriMhs {
    override suspend fun insertMhs(mahasiswa: Mahasiswa) {
        mahasiswaDao.insertMahasiswa(mahasiswa)
    }
}