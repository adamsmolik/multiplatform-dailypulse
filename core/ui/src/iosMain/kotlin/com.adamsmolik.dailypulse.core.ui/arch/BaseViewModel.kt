package com.adamsmolik.dailypulse.core.ui.arch

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.cancel

actual open class BaseViewModel {

    actual val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)

    fun clear() {
        scope.cancel()
    }
}
