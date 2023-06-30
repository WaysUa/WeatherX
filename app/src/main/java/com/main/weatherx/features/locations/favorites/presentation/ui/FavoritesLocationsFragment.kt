package com.main.weatherx.features.locations.favorites.presentation.ui

import android.os.Bundle
import android.view.View
import com.main.notelink.core.data.BaseFragment
import com.main.weatherx.databinding.FragmentFavoritesLocationBinding
import com.main.weatherx.features.locations.favorites.presentation.viewmodel.FavoritesLocationsViewModel

class FavoritesLocationsFragment : BaseFragment<FavoritesLocationsViewModel>() {
    override val viewModelClass = FavoritesLocationsViewModel::class.java
    override val binding by lazy { FragmentFavoritesLocationBinding.inflate(layoutInflater) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
