package com.example.tetsideaplatform.di

import android.content.Context
import com.example.tetsideaplatform.data.ItemRepository
import com.example.tetsideaplatform.data.ItemRepositoryImpl
import com.example.tetsideaplatform.data.db.LocalDatabase
import com.example.tetsideaplatform.data.db.ItemDao
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface AppModule {


    @Binds
    fun bindItemRepository(authImpl: ItemRepositoryImpl): ItemRepository

    companion object {

        @Provides
        fun providesDatabase(@ApplicationContext context: Context): LocalDatabase {
            return LocalDatabase.getInstance(context)
        }

        @Provides
        fun providesItemDAO(database: LocalDatabase): ItemDao {
            return database.itemDao()
        }
    }

}