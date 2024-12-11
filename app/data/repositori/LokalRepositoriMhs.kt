package com.tugas.questdata.data.repositori

import com.tugas.questdata.data.dao.MahasiswaDao
import com.tugas.questdata.data.entity.Mahasiswa

class LokalRepositoriMhs(
    private val mahasiswaDao: MahasiswaDao
) : RepositoriMhs {
    override suspend fun insertMhs(mahasiswa: Mahasiswa) {
        mahasiswaDao.insertMahasiswa(mahasiswa)
    }
}