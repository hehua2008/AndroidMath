package com.pvporbit.freetype

class Size(pointer: Long) : NativeWrapper(pointer) {
    val metrics: SizeMetrics
        get() = SizeMetrics(FreeType.FT_Size_Get_metrics(pointer))
}