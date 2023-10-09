package com.example.tummocandroidassignment.ui.domain.usecase.saveonboarding

import com.example.tummocandroidassignment.ui.data.repository.Repository

class SaveOnBoardingUseCase(
    private val repository: Repository
) {

    suspend operator fun invoke(isCompleted: Boolean) {
        repository.saveOnBoardingState(isCompleted = isCompleted)
    }

}