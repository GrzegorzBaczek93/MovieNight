package com.baczek.movienight.domain.usecase

import com.baczek.movienight.domain.repository.AssetRepository
import javax.inject.Inject

class GetAssetUseCase @Inject constructor(
    private val assetRepository: AssetRepository
) {
    suspend operator fun invoke(id: String) = assetRepository.getAsset(id)
}