package com.pvporbit.freetype

class Size(pointer: Long) : NativeWrapper(pointer) {
    val metrics: SizeMetrics?
        get() {
            val sizeMetrics = FreeType.FT_Size_Get_metrics(pointer)
            if (sizeMetrics <= 0) return null
            return SizeMetrics(sizeMetrics)
        }
}