package com.nicos.navigation.navigation.navigation_3

import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey

class NavigationState(
    val backStacks: NavBackStack<NavKey>
) {
    val stacksInUse: NavBackStack<NavKey>
        get() = backStacks
}