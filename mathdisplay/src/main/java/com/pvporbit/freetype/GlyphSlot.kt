package com.pvporbit.freetype

import com.pvporbit.freetype.FreeTypeConstants.FT_Render_Mode

class GlyphSlot(pointer: Long) : NativeWrapper(pointer) {
    val bitmap: Bitmap?
        get() {
            val bitmap = FreeType.FT_GlyphSlot_Get_bitmap(pointer)
            if (bitmap == 0L) return null
            return Bitmap(bitmap)
        }

    val linearHoriAdvance: Long
        get() = FreeType.FT_GlyphSlot_Get_linearHoriAdvance(pointer)

    val linearVertAdvance: Long
        get() = FreeType.FT_GlyphSlot_Get_linearVertAdvance(pointer)

    val advance: Advance?
        get() = FreeType.FT_GlyphSlot_Get_advance(pointer)

    val format: Int
        get() = FreeType.FT_GlyphSlot_Get_format(pointer)

    val bitmapLeft: Int
        get() = FreeType.FT_GlyphSlot_Get_bitmap_left(pointer)

    val bitmapTop: Int
        get() = FreeType.FT_GlyphSlot_Get_bitmap_top(pointer)

    val metrics: GlyphMetrics?
        get() {
            val metrics = FreeType.FT_GlyphSlot_Get_metrics(pointer)
            if (metrics == 0L) return null
            return GlyphMetrics(metrics)
        }

    fun renderGlyph(renderMode: FT_Render_Mode): Boolean {
        return FreeType.FT_Render_Glyph(pointer, renderMode.ordinal)
    }

    class Advance(val x: Long, val y: Long) {
        override fun toString(): String {
            return "($x,$y)"
        }
    }
}