package com.pvporbit.freetype

class GlyphSlot(pointer: Long) : NativeWrapper(pointer) {
    val bitmap: Bitmap
        get() = Bitmap(FreeType.FT_GlyphSlot_Get_bitmap(pointer))

    val linearHoriAdvance: Long
        get() = FreeType.FT_GlyphSlot_Get_linearHoriAdvance(pointer)

    val linearVertAdvance: Long
        get() = FreeType.FT_GlyphSlot_Get_linearVertAdvance(pointer)

    val advance: Vector
        get() = Vector(FreeType.FT_GlyphSlot_Get_advance(pointer))

    val format: Int
        get() = FreeType.FT_GlyphSlot_Get_format(pointer)

    val bitmapLeft: Int
        get() = FreeType.FT_GlyphSlot_Get_bitmap_left(pointer)

    val bitmapTop: Int
        get() = FreeType.FT_GlyphSlot_Get_bitmap_top(pointer)

    val metrics: GlyphMetrics
        get() = GlyphMetrics(FreeType.FT_GlyphSlot_Get_metrics(pointer))

    fun renderGlyph(renderMode: RenderMode): Boolean {
        return FreeType.FT_Render_Glyph(pointer, renderMode.ordinal)
    }
}