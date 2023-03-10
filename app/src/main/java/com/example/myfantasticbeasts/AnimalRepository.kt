package com.example.myfantasticbeasts

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow

class AnimalRepository (private val animalDao: AnimalDao){

    val allAnimals: Flow<List<Animals>> = animalDao.getAlphabetizedAnimals()
    suspend fun insert(animals: Animals){
        animalDao.insert(animals)
    }
    suspend fun delete(animals: Animals){
        animalDao.delete(animals)
    }
    suspend fun update(animals: Animals){
        animalDao.update(animals)
    }
}