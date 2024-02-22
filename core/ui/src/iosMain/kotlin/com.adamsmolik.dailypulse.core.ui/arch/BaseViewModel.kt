package com.adamsmolik.dailypulse.core.ui.arch

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel

actual open class BaseViewModel {

    actual val scope: CoroutineScope = MainScope()

    fun clear() {
        scope.cancel()
    }
}
