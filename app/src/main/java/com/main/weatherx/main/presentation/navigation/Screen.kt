package com.main.weatherx.main.presentation.navigation

import com.main.notelink.core.data.BaseFragment

sealed class Screen {

    abstract fun fragment(): Class<out BaseFragment<*>>

//    object Numbers : Screen() {
//        override fun fragment(): Class<out BaseFragment<*>> = NumbersFragment::class.java
//    }
}
