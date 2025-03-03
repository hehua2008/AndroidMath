package com.pvporbit.freetype

/**
 * @author hehua2008
 * @date 2025/3/3
 */
abstract class NativeWrapper(val pointer: Long) {
    final override fun hashCode(): Int {
        return pointer.hashCode()
    }

    final override fun equals(other: Any?): Boolean {
        other ?: return false
        if (this::class !== other::class) return false
        return pointer == (other as NativeWrapper).pointer
    }
}
