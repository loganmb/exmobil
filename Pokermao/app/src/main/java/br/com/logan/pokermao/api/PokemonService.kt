package br.com.logan.pokermao.api

import android.telecom.Call
import br.com.logan.pokermao.model.PokemonResponse

interface PokemonService{
    @GET("/api/pokemon/health")
    fun checkHealth(): Call<HealthResponse>

    @GET("/api/pokemon")
    fun getPokemons(
        @Query("size") size: Int,
        @Query("sort") sort: String
    ): Call<PokemonResponse>
}