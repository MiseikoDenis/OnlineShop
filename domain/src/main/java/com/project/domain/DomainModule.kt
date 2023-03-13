package com.project.domain

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {
    // ... провайдеры зависимостей
}