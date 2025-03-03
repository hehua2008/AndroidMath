package com.pvporbit.freetype

class SizeMetrics(pointer: Long) : NativeWrapper(pointer) {
    val ascender: Int
        get() = FreeType.FT_Size_Metrics_Get_ascender(pointer)

    val descender: Int
        get() = FreeType.FT_Size_Metrics_Get_descender(pointer)

    val height: Int
        get() = FreeType.FT_Size_Metrics_Get_height(pointer)

    val maxAdvance: Int
        get() = FreeType.FT_Size_Metrics_Get_max_advance(pointer)

    val xppem: Int
        get() = FreeType.FT_Size_Metrics_Get_x_ppem(pointer)

    val yppem: Int
        get() = FreeType.FT_Size_Metrics_Get_y_ppem(pointer)

    val xScale: Int
        get() = FreeType.FT_Size_Metrics_Get_x_scale(pointer)

    val yScale: Int
        get() = FreeType.FT_Size_Metrics_Get_y_scale(pointer)
}