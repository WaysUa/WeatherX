package com.main.weatherx.features.locations.favorites.sl

import com.main.weatherx.core.sl.Core
import com.main.weatherx.core.sl.Module
import com.main.weatherx.features.locations.favorites.presentation.viewmodel.FavoritesLocationsViewModel

class FavoritesLocationsModule(
    private val core: Core
) : Module<FavoritesLocationsViewModel> {
    override fun viewModel(): FavoritesLocationsViewModel {
        return FavoritesLocationsViewModel()
    }
}