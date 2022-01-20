package com.droidli.cryptoapp.di

import android.app.Application
import com.droidli.cryptoapp.data.database.AppDatabase
import com.droidli.cryptoapp.data.database.CoinInfoDao
import com.droidli.cryptoapp.data.network.ApiFactory
import com.droidli.cryptoapp.data.network.ApiService
import com.droidli.cryptoapp.data.repository.CoinRepositoryImpl
import com.droidli.cryptoapp.domain.CoinRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindCoinRepository(impl: CoinRepositoryImpl): CoinRepository

    companion object {

        @Provides
        @ApplicationScope
        fun provideCoinInfoDao(
            application: Application
        ): CoinInfoDao {
            return AppDatabase.getInstance(application).coinPriceInfoDao()
        }

        @Provides
        @ApplicationScope
        fun providesApiService(): ApiService {
            return ApiFactory.apiService
        }
    }
}