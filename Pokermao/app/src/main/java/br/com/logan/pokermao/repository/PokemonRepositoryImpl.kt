package br.com.logan.pokermao.repository

import android.telecom.Call
import br.com.logan.pokermao.api.PokemonService
import br.com.logan.pokermao.model.HeathResponse
import br.com.logan.pokermao.model.Pokemon
import kotlinx.android.synthetic.*
import javax.security.auth.callback.Callback

class PokemonRepositoryImpl(val pokemonService: PokemonService) : PokemonRepository{

    override fun checkHealth(onComplete: () -> Unit, onError: (Throwable?) -> Unit) {
        pokemonService.checkHealth()
            .enqueue(object : Callback<HeathResponse>{
                override fun onFailure(call: Call<HeathResponse>, t: Throwable){
                    onError(t)
                }

                override fun onResponse(call: Call<HeathResponse>,response : Response<HealtResponse>){
                    onComplete()
                }
            })
    }


    override fun getPokemons(
        size: Int, sort: String,
        onComplete: (List<Pokemon>?) -> Unit,
        onError: (Throwable?) -> Unit
    ) {
        pokemonService.getPokemons(size, sort)
            .enqueue(object : Callback<PokemonResponse> {
                override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {
                    onError(t)
                }
                override fun onResponse(call: Call<PokemonResponse>, response:
                Response<PokemonResponse>) {
                    if (response.isSuccessful) {
                        onComplete(response.body()?.content)
                    } else {
                        onError(Throwable("Não foi possível carregar os Pokémons"))
                    }
                }
            })
    }

}