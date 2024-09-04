package com.example.tetsideaplatform.di

import android.content.Context
import androidx.room.Room
import com.example.tetsideaplatform.data.AppDataBase
import com.example.tetsideaplatform.data.ItemDao
import com.example.tetsideaplatform.data.ItemMapper
import com.example.tetsideaplatform.data.ItemRepositoryImpl
import com.example.tetsideaplatform.domain.ItemRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    @Provides
    @Singleton
    fun provideAppDataBase(@ApplicationContext context: Context):AppDataBase =
        Room.databaseBuilder(context, AppDataBase::class.java,"data.db")
            .fallbackToDestructiveMigration()
            .build()



    @Provides
    fun provideItemDao(appDataBase: AppDataBase): ItemDao = appDataBase.itemDao()


    @Provides
    fun provideItemRepositoryImpl(itemDao: ItemDao): ItemRepositoryImpl = ItemRepositoryImpl(itemDao, mapper = ItemMapper())

    @Provides
    fun provideItemRepository(itemDao: ItemDao): ItemRepository = ItemRepositoryImpl(itemDao, mapper = ItemMapper())
}