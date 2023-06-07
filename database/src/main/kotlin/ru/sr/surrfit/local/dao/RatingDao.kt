package ru.sr.surrfit.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.sr.surrfit.local.entity.RatingEntity

@Dao
interface RatingDao {
    @Query("SELECT*FROM rating ORDER BY stepCount ")
    fun getAllSortedByStep(): List<RatingEntity>

    @Query("SELECT*FROM rating ORDER BY id ")
    fun getAllSortedById(): List<RatingEntity>

    @Query("SELECT*FROM rating ORDER BY name ")
    fun getAllSortedByName(): List<RatingEntity>

    @Query("SELECT*FROM rating ORDER BY mode ")
    fun getAllSortedByMode(): List<RatingEntity>

    @Query("SELECT*FROM rating ORDER BY email ")
    fun getAllSortedByEmail(): List<RatingEntity>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(ratingListEntity: List<RatingEntity>)

    @Query("DELETE FROM rating")
    fun deleteAll()
}
