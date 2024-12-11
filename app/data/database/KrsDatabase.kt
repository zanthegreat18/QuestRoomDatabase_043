package com.tugas.questdata.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tugas.questdata.data.dao.MahasiswaDao
import com.tugas.questdata.data.entity.Mahasiswa

//mendefinisikan databse dengan label mahasiswa
@Database(entities = [Mahasiswa::class], version = 1, exportSchema = false)
abstract class KrsDatabase : RoomDatabase() {

    //mendefinisikan fungsi untuk mengakses data mahasiswa
    abstract fun mahasiswaDao(): MahasiswaDao

    companion object {
        @Volatile //memastikan bahwa nilai INSTANCE selalu diperbarui atau selalu sama
        private var Instance: KrsDatabase? = null

        fun getDatabase(context: Context): KrsDatabase {
            return (Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    KrsDatabase::class.java, //class database
                    "krsDatabase" //nama database
                )
                    .build().also { Instance = it }
            })
        }
    }
}