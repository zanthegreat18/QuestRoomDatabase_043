package com.tugas.questdata.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mahasiswa")
data class Mahasiswa(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nim: String,
    val nama: String,
    val alamat: String,
    val jeniskelamin: String,
    val kelas: String,
    val angkatan: String
)
