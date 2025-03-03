package com.pvporbit.freetype

import java.nio.ByteBuffer

class Bitmap(pointer: Long) : NativeWrapper(pointer) {
    val width: Int
        get() = FreeType.FT_Bitmap_Get_width(pointer)

    val rows: Int
        get() = FreeType.FT_Bitmap_Get_rows(pointer)

    val pitch: Int
        get() = FreeType.FT_Bitmap_Get_pitch(pointer)

    val numGrays: Short
        get() = FreeType.FT_Bitmap_Get_num_grays(pointer)

    val paletteMode: Char
        get() = FreeType.FT_Bitmap_Get_palette_mode(pointer)

    val pixelMode: Char
        get() = FreeType.FT_Bitmap_Get_pixel_mode(pointer)

    val buffer: ByteBuffer?
        get() = FreeType.FT_Bitmap_Get_buffer(pointer)
}