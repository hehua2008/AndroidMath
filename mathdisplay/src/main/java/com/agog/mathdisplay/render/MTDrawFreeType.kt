package com.agog.mathdisplay.render

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import com.agog.mathdisplay.parse.MathDisplayException
import com.pvporbit.freetype.FreeTypeConstants
import java.nio.ByteBuffer

class MTDrawFreeType(val mathfont: MTFontMathTable) {

    fun drawGlyph(canvas: Canvas, p: Paint, gid: Int, x: Float, y: Float) {
        val face = mathfont.checkFontSize()

        /* load glyph image into the slot and render (erase previous one) */
        if (gid != 0 && !face.loadGlyph(gid, FreeTypeConstants.FT_LOAD_RENDER)) {
            val gslot = face.glyphSlot!!
            val plainbitmap = gslot.bitmap
            if (plainbitmap != null) {
                if (plainbitmap.width == 0 || plainbitmap.rows == 0) {
                    if (gid != 1 && gid != 33) {
                        throw MathDisplayException("missing glyph slot $gid.")
                    }
                } else {
                    val bitmap = Bitmap.createBitmap(plainbitmap.width, plainbitmap.rows, Bitmap.Config.ALPHA_8)
                    bitmap.copyPixelsFromBuffer(ByteBuffer.wrap(plainbitmap.buffer!!))
                    val metrics = gslot.metrics!!
                    val offx = metrics.horiBearingX / 64.0f  // 26.6 fixed point integer from freetype
                    val offy = metrics.horiBearingY / 64.0f
                    canvas.drawBitmap(bitmap, x + offx, y - offy, p)
                }
            }
        }
    }
    //val enclosing = BoundingBox()

    /*
    val numGrays: Short
        get() = FreeType.FT_Bitmap_Get_num_grays(pointer)

    val paletteMode: Char
        get() = FreeType.FT_Bitmap_Get_palette_mode(pointer)

    val pixelMode: Char
        get() = FreeType.FT_Bitmap_Get_pixel_mode(pointer)
        */
}