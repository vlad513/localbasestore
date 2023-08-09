package com.vladv.testlocalbase.di

import androidx.room.Room
import com.vladv.data.repository.RepositoryFirestoreImpl
import com.vladv.data.storage.Dao
import com.vladv.data.storage.Database
import com.vladv.domain.repository.RepositoryGet
import com.vladv.data.repository.RepositoryGetImpl
import com.vladv.domain.repository.RepositoryFirestore
import com.vladv.domain.repository.RepositorySave
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val dataModule = module {
    // Room Database instance
    single<Database> {
        Room.databaseBuilder(
            androidApplication(), Database::class.java, "database"
        ).build()
    }
    single<Dao> {
        val database = get<Database>()
        database.getRunDao()
    }
    single<RepositoryGet> {
        RepositoryGetImpl(dao = get())
    }
    single<RepositorySave> {
        com.vladv.data.repository.RepositorySaveImpl(dao = get())
    }
    single<RepositoryFirestore> {
        RepositoryFirestoreImpl()
    }
}