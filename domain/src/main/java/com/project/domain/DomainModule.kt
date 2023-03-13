package com.project.domain

import com.project.data.db.AppDatabase
import com.project.data.repository.UserRepository
import com.project.domain.interactor.UserInteractor
import com.project.domain.mapper.UserEntityMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun provideUserRepository(database: AppDatabase): UserRepository {
        return UserRepository(database.userDao())
    }

    @Provides
    @Singleton
    fun provideUserEntityMapper(): UserEntityMapper {
        return UserEntityMapper()
    }

    @Provides
    @Singleton
    fun provideUserInteractor(userRepository: UserRepository, mapper: UserEntityMapper): UserInteractor {
        return UserInteractor(userRepository, mapper)
    }
}