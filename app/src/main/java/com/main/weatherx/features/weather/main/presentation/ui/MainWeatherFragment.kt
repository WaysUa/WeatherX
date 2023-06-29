package com.main.weatherx.features.weather.main.presentation.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.view.View
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.main.notelink.core.data.BaseFragment
import com.main.weatherx.core.data.Permission
import com.main.weatherx.databinding.FragmentMainWeatherBinding
import com.main.weatherx.features.weather.main.data.entities.Coordinates
import com.main.weatherx.features.weather.main.presentation.viewmodel.MainGeoViewModel
import com.permissionx.guolindev.PermissionX

class MainWeatherFragment : BaseFragment<MainGeoViewModel.Base>() {

    override val viewModelClass = MainGeoViewModel.Base::class.java
    override val binding by lazy { FragmentMainWeatherBinding.inflate(layoutInflater) }

    private val permissionManager = PermissionX.init(this)
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    private val locationRequest = LocationRequest.Builder(Long.MAX_VALUE)
        .setPriority(Priority.PRIORITY_HIGH_ACCURACY)
        .build()

    private val locationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult) {
            val latestLocation = locationResult.lastLocation
            if (latestLocation != null) {
                viewModel.fetchGeoData(
                    coordinates = Coordinates(
                        lat = latestLocation.latitude,
                        lon = latestLocation.longitude
                    )
                )
            }
        }
    }

    @SuppressLint("MissingPermission")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())

        permissionManager.permissions(
            Permission.Location.permission.toList()
        ).request { allGranted, _, _ ->
            if (allGranted) {
                fusedLocationClient.requestLocationUpdates(
                    locationRequest,
                    locationCallback,
                    Looper.getMainLooper()
                )
            }
        }

        viewModel.observeGeoData(this) {
            // todo remove log
            Log.d("MyLog", "GeoData: $it")
        }

        viewModel.observeError(this) {
            // todo remove log
            Log.d("MyLog", "Error: $it")
        }

        viewModel.observeProgress(this) {
            // todo remove log
            Log.d("MyLog", "Progress: $it")
        }
    }
}
