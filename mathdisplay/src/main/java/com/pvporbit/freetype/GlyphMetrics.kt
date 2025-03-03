package com.pvporbit.freetype

class GlyphMetrics(pointer: Long) : Utils.Pointer(pointer) {
    val width: Int
        get() = FreeType.FT_Glyph_Metrics_Get_width(pointer)

    val height: Int
        get() = FreeType.FT_Glyph_Metrics_Get_height(pointer)

    val horiAdvance: Int
        get() = FreeType.FT_Glyph_Metrics_Get_horiAdvance(pointer)

    val vertAdvance: Int
        get() = FreeType.FT_Glyph_Metrics_Get_vertAdvance(pointer)

    val horiBearingX: Int
        get() = FreeType.FT_Glyph_Metrics_Get_horiBearingX(pointer)

    val horiBearingY: Int
        get() = FreeType.FT_Glyph_Metrics_Get_horiBearingY(pointer)

    val vertBearingX: Int
        get() = FreeType.FT_Glyph_Metrics_Get_vertBearingX(pointer)

    val vertBearingY: Int
        get() = FreeType.FT_Glyph_Metrics_Get_vertBearingY(pointer)
}