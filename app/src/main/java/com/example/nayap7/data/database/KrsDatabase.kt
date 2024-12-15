package com.example.nayap7.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.nayap7.data.dao.MahasiswaDao
import com.example.nayap7.data.entity.Mahasiswa

//// mendifiniskan db denan tbal mhs
@Database(entities = [Mahasiswa::class], version = 1, exportSchema = false)
abstract class KrsDatabase: RoomDatabase() {

    // mendifinisikan fungsi untuk mengakses data mhs
    abstract fun mahasiswaDao(): MahasiswaDao  //fungsinya ngambil dari data class mhs

    companion object{
        @Volatile //memastikan bahwa nilai variabel instance selau sama di semua thread
        private var Instance: KrsDatabase? = null

        fun getDatabase(context: Context): KrsDatabase{
            return (Instance ?: synchronized(this){
                Room.databaseBuilder(
                    context,
                    KrsDatabase::class.java,
                    "KrsDatabase"
                )
                    .build().also { Instance = it}
            })

        }
    }
}