package com.pvporbit.freetype

object FreeTypeConstants {
    /* FT_LOAD_* (Load Char flags) */
    const val FT_LOAD_DEFAULT: Int = 0x0
    const val FT_LOAD_NO_SCALE: Int = (1 shl 0)
    const val FT_LOAD_NO_HINTING: Int = (1 shl 1)
    const val FT_LOAD_RENDER: Int = (1 shl 2)
    const val FT_LOAD_NO_BITMAP: Int = (1 shl 3)
    const val FT_LOAD_VERTICAL_LAYOUT: Int = (1 shl 4)
    const val FT_LOAD_FORCE_AUTOHINT: Int = (1 shl 5)
    const val FT_LOAD_CROP_BITMAP: Int = (1 shl 6)
    const val FT_LOAD_PEDANTIC: Int = (1 shl 7)
    const val FT_LOAD_IGNORE_GLOBAL_ADVANCE_WIDTH: Int = (1 shl 9)
    const val FT_LOAD_NO_RECURSE: Int = (1 shl 10)
    const val FT_LOAD_IGNORE_TRANSFORM: Int = (1 shl 11)
    const val FT_LOAD_MONOCHROME: Int = (1 shl 12)
    const val FT_LOAD_LINEAR_DESIGN: Int = (1 shl 13)
    const val FT_LOAD_NO_AUTOHINT: Int = (1 shl 15)
    const val FT_LOAD_COLOR: Int = (1 shl 20)
    const val FT_LOAD_COMPUTE_METRICS: Int = (1 shl 21)

    /* FT_FSTYPE_* (FSType flags)*/
    const val FT_FSTYPE_INSTALLABLE_EMBEDDING: Int = 0x0000
    const val FT_FSTYPE_RESTRICTED_LICENSE_EMBEDDING: Int = 0x0002
    const val FT_FSTYPE_PREVIEW_AND_PRINT_EMBEDDING: Int = 0x0004
    const val FT_FSTYPE_EDITABLE_EMBEDDING: Int = 0x0008
    const val FT_FSTYPE_NO_SUBSETTING: Int = 0x0100
    const val FT_FSTYPE_BITMAP_EMBEDDING_ONLY: Int = 0x0200

    /* FT_Encoding */
    const val FT_ENCODING_NONE: Int = 0x0
    const val FT_ENCODING_MS_SYMBOL: Int = 1937337698 // s y m b
    const val FT_ENCODING_UNICODE: Int = 1970170211 // u n i c
    const val FT_ENCODING_SJIS: Int = 1936353651 // s j i s
    const val FT_ENCODING_GB2312: Int = 1734484000 // g b
    const val FT_ENCODING_BIG5: Int = 1651074869 // b i g 5
    const val FT_ENCODING_WANSUNG: Int = 2002873971 // w a n s
    const val FT_ENCODING_JOHAB: Int = 1785686113 // j o h a
    const val FT_ENCODING_ADOBE_STANDARD: Int = 1094995778 // A D O B
    const val FT_ENCODING_ADOBE_EXPERT: Int = 1094992453 // A D B E
    const val FT_ENCODING_ADOBE_CUSTOM: Int = 1094992451 // A D B C
    const val FT_ENCODING_ADOBE_LATIN_1: Int = 1818326065 // l a t 1
    const val FT_ENCODING_OLD_LATIN_2: Int = 1818326066 // l a t 2
    const val FT_ENCODING_APPLE_ROMAN: Int = 1634889070 // a r m n

    enum class FT_Render_Mode {
        FT_RENDER_MODE_NORMAL,
        FT_RENDER_MODE_LIGHT,
        FT_RENDER_MODE_MONO,
        FT_RENDER_MODE_LCD,
        FT_RENDER_MODE_LCD_V,

        FT_RENDER_MODE_MAX
    }

    enum class FT_Size_Request_Type {
        FT_SIZE_REQUEST_TYPE_NOMINAL,
        FT_SIZE_REQUEST_TYPE_REAL_DIM,
        FT_SIZE_REQUEST_TYPE_BBOX,
        FT_SIZE_REQUEST_TYPE_CELL,
        FT_SIZE_REQUEST_TYPE_SCALES,

        FT_SIZE_REQUEST_TYPE_MAX
    }


    enum class FT_Kerning_Mode {
        FT_KERNING_DEFAULT,
        FT_KERNING_UNFITTED,
        FT_KERNING_UNSCALED
    }
}