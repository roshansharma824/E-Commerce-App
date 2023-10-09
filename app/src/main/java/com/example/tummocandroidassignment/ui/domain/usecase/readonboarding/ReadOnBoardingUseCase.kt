package com.example.tummocandroidassignment.ui.domain.usecase.readonboarding

import com.example.tummocandroidassignment.ui.data.repository.Repository
import kotlinx.coroutines.flow.Flow

class ReadOnBoardingUseCase(private val repository: Repository) {

    operator fun invoke(): Flow<Boolean> = repository.readOnBoardingState()

}