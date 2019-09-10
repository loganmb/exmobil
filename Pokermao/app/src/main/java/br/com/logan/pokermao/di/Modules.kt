package br.com.logan.pokermao.di

import br.com.logan.pokermao.api.AuthInterceptor
import br.com.logan.pokermao.api.PokemonService
import br.com.logan.pokermao.repository.PokemonRepository
import br.com.logan.pokermao.repository.PokemonRepositoryImpl
import br.com.logan.pokermao.view.splash.SplashViewModel
import java.util.concurrent.TimeUnit

private fun createNetWorkClinte(okHttpClient: OkHttpCliente): Retrofit{
    return Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("https://pokedexdx.herokuapp.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

}

private fun createOkHttpClientAuth(authInterceptor: Interceptor): OkHttpClient{
    val builder = OkHtttpClient.Builder()
        .addInterceptor(authInterceptor)
        .addNetworkInterceptor(StetholInterceptor())
        .connectTimeout(30,TimeUnit.SECONDS)
        .readTimeout(30,TimeUnit.SECONDS)
        .writeTimeout(30,TimeUnit.SECONDS)
    return builder.build()
}

val viewModelModule= module{
    viewModel{SplashViewModel(get())}
}

val repositoryModule = module{
    single<PokemonRepository>{PokemonRepositoryImpl(get())}
}

val networkModule = module{
    single<Interceptor>{AuthInterceptor()}
    single{ createNetWorkClinte(get()).create(PokemonService::class.java)}
    single{ createOkHttpClientAuth(get())}
}
