package com.example.nayap7.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.nayap7.data.entity.Mahasiswa
import kotlinx.coroutines.flow.Flow

@Dao
interface MahasiswaDao {
    //fungsi get all data
    @Query("select * from mahasiswa")
    fun getAllMahasiswa() : Flow<List<Mahasiswa>>

    @Insert
    suspend fun insertMahasiswa(
        mahasiswa: Mahasiswa
    )

    abstract fun getMahasiswa(nim: String): Flow<Mahasiswa>
    abstract fun updateMahasiswa(mahasiswa: Mahasiswa)
    abstract fun deleteMahasiswa(mahasiswa: Mahasiswa)
}