package com.baczek.movienight.domain.usecase

import com.baczek.movienight.domain.repository.CountryAndServiceRepository
import javax.inject.Inject

class GetCountriesUseCase @Inject constructor(
    private val countryAndServiceRepository: CountryAndServiceRepository,
) {
    suspend operator fun invoke() = countryAndServiceRepository.getCountries()
}