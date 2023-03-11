package com.example.myfantasticbeasts



import androidx.room.*


@Dao
interface AnimalDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert (animals: Animals)


    @Query("Select * from animal_table order by id ASC")
    fun getAlphabetizedAnimals(): kotlinx.coroutines.flow.Flow<List<Animals>>

    @Delete
    suspend fun delete(animals: Animals)
    @Update
    suspend fun update(animals: Animals)
}