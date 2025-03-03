package com.pvporbit.freetype

import java.nio.ByteBuffer

/**
 * A handle to a given typographic face object. A face object models a given typeface, in a given style.
 */
class Face : NativeWrapper {
    private var data: ByteBuffer? = null // Save to delete later

    constructor(pointer: Long) : super(pointer)

    constructor(pointer: Long, data: ByteBuffer?) : super(pointer) {
        this.data = data
    }

    fun delete(): Boolean {
        if (data != null) Utils.deleteBuffer(data)
        return FreeType.FT_Done_Face(pointer)
    }

    fun loadMathTable(): MTFreeTypeMathTable {
        // Temporary buffer size of font.
        val buffer = Utils.newBuffer(data!!.remaining())
        val fm = MTFreeTypeMathTable(pointer, buffer!!)
        Utils.deleteBuffer(buffer)
        return fm
    }


    val ascender: Int
        get() = FreeType.FT_Face_Get_ascender(pointer)

    val descender: Int
        get() = FreeType.FT_Face_Get_descender(pointer)

    val faceFlags: Long
        get() = FreeType.FT_Face_Get_face_flags(pointer)

    val faceIndex: Int
        get() = FreeType.FT_Face_Get_face_index(pointer)

    val familyName: String?
        get() = FreeType.FT_Face_Get_family_name(pointer)

    val height: Int
        get() = FreeType.FT_Face_Get_heigth(pointer)

    val maxAdvanceHeight: Int
        get() = FreeType.FT_Face_Get_max_advance_height(pointer)

    val maxAdvanceWidth: Int
        get() = FreeType.FT_Face_Get_max_advance_width(pointer)

    val numFaces: Int
        get() = FreeType.FT_Face_Get_num_faces(pointer)

    val numGlyphs: Int
        get() = FreeType.FT_Face_Get_num_glyphs(pointer)

    val styleFlags: Long
        get() = FreeType.FT_Face_Get_style_flags(pointer)

    val styleName: String?
        get() = FreeType.FT_Face_Get_style_name(pointer)

    val underlinePosition: Int
        get() = FreeType.FT_Face_Get_underline_position(pointer)

    val underlineThickness: Int
        get() = FreeType.FT_Face_Get_underline_thickness(pointer)

    val unitsPerEM: Int
        get() = FreeType.FT_Face_Get_units_per_EM(pointer)

    fun getCharIndex(code: Int): Int {
        return FreeType.FT_Get_Char_Index(pointer, code)
    }

    fun hasKerning(): Boolean {
        return FreeType.FT_HAS_KERNING(pointer)
    }

    fun selectSize(strikeIndex: Int): Boolean {
        return FreeType.FT_Select_Size(pointer, strikeIndex)
    }

    fun setCharSize(char_width: Int, char_height: Int, horz_resolution: Int, vert_resolution: Int): Boolean {
        return FreeType.FT_Set_Char_Size(pointer, char_width, char_height, horz_resolution, vert_resolution)
    }

    fun loadGlyph(glyphIndex: Int, flags: Int): Boolean {
        return FreeType.FT_Load_Glyph(pointer, glyphIndex, flags)
    }

    fun loadChar(c: Char, flags: Int): Boolean {
        return FreeType.FT_Load_Char(pointer, c, flags)
    }

    fun getKerning(left: Char, right: Char): Kerning? {
        return getKerning(left, right, KerningMode.FT_KERNING_DEFAULT)
    }

    fun getKerning(left: Char, right: Char, mode: KerningMode): Kerning? {
        val ptr = FreeType.FT_Face_Get_Kerning(pointer, left, right, mode.ordinal)
        return if (ptr == 0L) null else Vector(ptr).let { Kerning(it.x, it.y) }
    }

    fun setPixelSizes(width: Float, height: Float): Boolean {
        return FreeType.FT_Set_Pixel_Sizes(pointer, width, height)
    }

    val glyphSlot: GlyphSlot?
        get() {
            val glyph = FreeType.FT_Face_Get_glyph(pointer)
            if (glyph == 0L) return null
            return GlyphSlot(glyph)
        }

    val size: Size?
        get() {
            val size = FreeType.FT_Face_Get_size(pointer)
            if (size == 0L) return null
            return Size(size)
        }

    fun checkTrueTypePatents(): Boolean {
        return FreeType.FT_Face_CheckTrueTypePatents(pointer)
    }

    fun setUnpatentedHinting(newValue: Boolean): Boolean {
        return FreeType.FT_Face_SetUnpatentedHinting(pointer, newValue)
    }

    fun referenceFace(): Boolean {
        return FreeType.FT_Reference_Face(pointer)
    }

    fun requestSize(sr: SizeRequest): Boolean {
        return FreeType.FT_Request_Size(pointer, sr)
    }

    val firstChar: IntArray?
        get() = FreeType.FT_Get_First_Char(pointer)

    val firstCharAsCharcode: Int
        get() = firstChar!![0]

    val firstCharAsGlyphIndex: Int
        get() = firstChar!![1]

    fun getNextChar(charcode: Long): Int { // I will not create getNextCharAsCharcode to do charcode++.
        return FreeType.FT_Get_Next_Char(pointer, charcode)
    }

    fun getGlyphIndexByName(name: String?): Int {
        return FreeType.FT_Get_Name_Index(pointer, name)
    }

    fun getTrackKerning(point_size: Int, degree: Int): Long {
        return FreeType.FT_Get_Track_Kerning(pointer, point_size.toLong(), degree)
    }

    fun getGlyphName(glyphIndex: Int): String? {
        return FreeType.FT_Get_Glyph_Name(pointer, glyphIndex)
    }

    val postscriptName: String?
        get() = FreeType.FT_Get_Postscript_Name(pointer)

    fun selectCharmap(encoding: Int): Boolean {
        return FreeType.FT_Select_Charmap(pointer, encoding)
    }

    fun setCharmap(charmap: CharMap): Boolean {
        return FreeType.FT_Set_Charmap(pointer, charmap.pointer)
    }

    val fSTypeFlags: Short
        get() = FreeType.FT_Get_FSType_Flags(pointer)
}