package com.main.weatherx.core.data

import android.Manifest

sealed class Permission(vararg val permission: String) {

    object Location : Permission(
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION
    )
}
