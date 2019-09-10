package br.com.logan.pokermao

import android.app.Application
import br.com.logan.pokermao.di.networkModule
import br.com.logan.pokermao.di.repositoryModule
import br.com.logan.pokermao.di.viewModelModule

class MyApplication  : Application(){
    override fun onCreate() {
        super.onCreate()
        //Start stetho
        Stetho.initializeWithDefaults(this)
        //start Koin
        startKoin{
            androidLogger()
            androidContext(this@MyApplication)
            modules(
                listOf(
                    viewModelModule,
                    networkModule,
                    repositoryModule
                )
            )
        }
    }
}