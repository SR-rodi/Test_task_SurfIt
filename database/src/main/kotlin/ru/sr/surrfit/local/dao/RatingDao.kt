package ru.sr.surrfit.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.sr.surrfit.local.entity.RatingEntity

@Dao
interface RatingDao {
    @Query("SELECT*FROM rating")
    fun getAll(): Flow<RatingEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(gameListEntity: RatingEntity)

    @Query("DELETE FROM rating")
    fun deleteAll()
}
