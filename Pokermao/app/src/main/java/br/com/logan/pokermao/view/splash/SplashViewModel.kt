package br.com.logan.pokermao.view.splash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.logan.pokermao.repository.PokemonRepository

class SplashViewModel (val pokemonRepository: PokemonRepository) : ViewModel(){
    val messageError: MutableLiveData<String> = MutableLiveData()

    fun checkHealth(){
        pokemonRepository.checkHealth(
            onComplete = {
                messageError.value = ""
            },
            onError = {
                messageError.value = it?.message
            }
        )
    }

}