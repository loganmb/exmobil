package br.com.fiap.roomwordsample.di

import androidx.room.Room
import br.com.fiap.roomwordsample.WordListAdapter
import br.com.fiap.roomwordsample.WordViewModel
import br.com.fiap.roomwordsample.dao.WordRoomDatabase
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dbModule = module {
    single {
        Room.databaseBuilder(
            get(),
            WordRoomDatabase::class.java,
            "Word_database"
        ).build()
    }

    single {get<WordRoomDatabase>().wordDao()}
}

val uiModule = module {
    factory {WordListAdapter(get())}
}

val viewModelModule = module {
    viewModel {WordViewModel(get())}
}