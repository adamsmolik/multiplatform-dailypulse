package com.adamsmolik.dailypulse.core.ui.arch

import kotlinx.coroutines.CoroutineScope

expect open class BaseViewModel() {
    val scope: CoroutineScope
}
