package br.com.logan.pokermao.repository

import br.com.logan.pokermao.model.Pokemon

interface PokemonRepository{
    fun checkHealth(
        onComplete:() -> Unit,
        onError:(Throwable?) -> Unit
    )

    fun getPokemons(
        size: Int,
        sort: String,
        onComplete: (List<Pokemon>?) -> Unit,
        onError: (Throwable?) -> Unit
    )
}