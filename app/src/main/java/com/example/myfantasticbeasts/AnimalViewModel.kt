package com.example.myfantasticbeasts

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch

class AnimalViewModel(application: Application): AndroidViewModel(application){
     private val allAnimals: LiveData<List<Animals>>
     private val repository: AnimalRepository

     init {
         val dao = AnimalDatabase.getDatabase(application).getAnimalDao()
         repository= AnimalRepository(dao)
         allAnimals = repository.allAnimals
     }

    fun insert(animals: Animals)= viewModelScope.launch {
        repository.insert(animals)
    }
    fun delete(animals: Animals)= viewModelScope.launch {
        repository.delete(animals)
    }
}
//class WordViewModelFactory(private val repository: AnimalRepository) : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(AnimalViewModel::class.java)) {
//            @Suppress("UNCHECKED_CAST")
//            return AnimalViewModel(repository) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//}