package com.example.myfantasticbeasts


import androidx.lifecycle.*
import kotlinx.coroutines.launch

class AnimalViewModel(private  val repository: AnimalRepository): ViewModel(){

     private val allAnimals: LiveData<List<Animals>> = repository.allAnimals.asLiveData()



//    init {
//         val dao = AnimalDatabase.getDatabase(application).getAnimalDao()
//         repository= AnimalRepository(dao)
//         allAnimals = repository.allAnimals
//     }

    fun insert(animals: Animals)= viewModelScope.launch {
        repository.insert(animals)
    }
    fun delete(animals: Animals)= viewModelScope.launch {
        repository.delete(animals)
    }
}
class AnimalViewModelFactory(private val repository: AnimalRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AnimalViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AnimalViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}