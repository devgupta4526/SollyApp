package com.underground.solly.di

import com.underground.solly.data.repository.SessionRepositoryImpl
import com.underground.solly.data.repository.SubjectRepositoryImpl
import com.underground.solly.data.repository.TaskRepositoryImpl
import com.underground.solly.domain.repository.SessionRepository
import com.underground.solly.domain.repository.SubjectRepository
import com.underground.solly.domain.repository.TaskRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindSubjectRepository(
        impl: SubjectRepositoryImpl
    ): SubjectRepository

    @Singleton
    @Binds
    abstract fun bindTaskRepository(
        impl: TaskRepositoryImpl
    ): TaskRepository

    @Singleton
    @Binds
    abstract fun bindSessionRepository(
        impl: SessionRepositoryImpl
    ): SessionRepository
}