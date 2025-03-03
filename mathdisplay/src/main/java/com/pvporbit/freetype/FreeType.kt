package com.pvporbit.freetype

import java.nio.ByteBuffer

object FreeType {
    /* FreeType functions */
    external fun FT_Init_FreeType(): Long

    // ---- Library
    external fun FT_Done_FreeType(library: Long): Boolean

    external fun FT_Library_Version(library: Long): LibraryVersion? // [major, minor, patch]

    //	public static native long           FT_Open_Face(long library, FT_Open_Args args, long faceIndex); // Nope.
    //	public static native long           FT_New_Face(long library, String filepathname, long faceIndex); // Please use 'FT_New_Memory_Face' or preferable 'library.newFace(path)'
    external fun FT_New_Memory_Face(library: Long, data: ByteBuffer?, length: Int, faceIndex: Long): Long

    // -- For getting math table
    /*
	  Uses FT_Load_Sfnt_Table with Tag fixed to MATH
	  data is preallocated and must be large enough to hold entire math table


     Example of stub generation
	 imac-3:mathdisplaylib greg$ javah -v -cp build/intermediates/classes/debug -d src/main/cpp/ com.pvporbit.freetype.FreeType


	 */
    external fun FT_Load_Math_Table(face: Long, data: ByteBuffer?, length: Int): Boolean


    // ---- Face
    external fun FT_Face_Get_ascender(face: Long): Int

    external fun FT_Face_Get_descender(face: Long): Int

    external fun FT_Face_Get_face_flags(face: Long): Long

    external fun FT_Face_Get_face_index(face: Long): Int

    external fun FT_Face_Get_family_name(face: Long): String?

    external fun FT_Face_Get_heigth(face: Long): Int

    external fun FT_Face_Get_max_advance_height(face: Long): Int

    external fun FT_Face_Get_max_advance_width(face: Long): Int

    external fun FT_Face_Get_num_faces(face: Long): Int

    external fun FT_Face_Get_num_glyphs(face: Long): Int

    external fun FT_Face_Get_style_flags(face: Long): Long

    external fun FT_Face_Get_style_name(face: Long): String?

    external fun FT_Face_Get_underline_position(face: Long): Int

    external fun FT_Face_Get_underline_thickness(face: Long): Int

    external fun FT_Face_Get_units_per_EM(face: Long): Int

    external fun FT_Face_Get_glyph(face: Long): Long /* Pointer to FT_GlyphSlot */

    external fun FT_Face_Get_size(face: Long): Long /* Pointer to FT_Size */

    external fun FT_Get_Track_Kerning(face: Long, point_size: Long, degree: Int): Long

    external fun FT_Face_Get_Kerning(face: Long, left: Char, right: Char, mode: Int): Kerning?

    external fun FT_Done_Face(face: Long): Boolean

    external fun FT_Reference_Face(face: Long): Boolean

    external fun FT_HAS_KERNING(face: Long): Boolean

    external fun FT_Get_Postscript_Name(face: Long): String?

    external fun FT_Select_Charmap(face: Long, encoding: Int): Boolean

    external fun FT_Set_Charmap(face: Long, charmap: Long): Boolean

    external fun FT_Face_CheckTrueTypePatents(face: Long): Boolean

    external fun FT_Face_SetUnpatentedHinting(face: Long, value: Boolean): Boolean

    external fun FT_Get_First_Char(face: Long): IntArray? // [charcode, glyphIndex]

    external fun FT_Get_Next_Char(face: Long, charcode: Long): Int

    external fun FT_Get_Char_Index(face: Long, code: Int): Int

    external fun FT_Get_Name_Index(face: Long, name: String?): Int

    external fun FT_Get_Glyph_Name(face: Long, glyphIndex: Int): String?

    external fun FT_Get_FSType_Flags(face: Long): Short

    external fun FT_Select_Size(face: Long, strikeIndex: Int): Boolean

    external fun FT_Load_Char(face: Long, c: Char, flags: Int): Boolean

    //	public static native boolean FT_Attach_File              (long face, String filepathname); // Nope.
    //	public static native boolean FT_Attach_Stream            (long face, FT_Open_Args parameters); // Nope.
    //	public static native boolean FT_Set_Transform            (long face, FT_Matrix* matrix, FT_Vector* delta);
    external fun FT_Request_Size(face: Long, sizeRequest: SizeRequest?): Boolean

    external fun FT_Set_Pixel_Sizes(face: Long, width: Float, height: Float): Boolean

    external fun FT_Load_Glyph(face: Long, glyphIndex: Int, loadFlags: Int): Boolean

    external fun FT_Set_Char_Size(
        face: Long,
        char_width: Int,
        char_height: Int,
        horz_resolution: Int,
        vert_resolution: Int
    ): Boolean

    // ---- Size
    external fun FT_Size_Get_metrics(size: Long): Long /* Pointer to SizeMetrics */

    // ---- Size Metrics
    external fun FT_Size_Metrics_Get_ascender(sizeMetrics: Long): Int

    external fun FT_Size_Metrics_Get_descender(sizeMetrics: Long): Int

    external fun FT_Size_Metrics_Get_height(sizeMetrics: Long): Int

    external fun FT_Size_Metrics_Get_max_advance(sizeMetrics: Long): Int

    external fun FT_Size_Metrics_Get_x_ppem(sizeMetrics: Long): Int

    external fun FT_Size_Metrics_Get_x_scale(sizeMetrics: Long): Int

    external fun FT_Size_Metrics_Get_y_ppem(sizeMetrics: Long): Int

    external fun FT_Size_Metrics_Get_y_scale(sizeMetrics: Long): Int

    // ---- GlyphSlot
    external fun FT_GlyphSlot_Get_linearHoriAdvance(glyphSlot: Long): Long

    external fun FT_GlyphSlot_Get_linearVertAdvance(glyphSlot: Long): Long

    external fun FT_GlyphSlot_Get_advance(glyphSlot: Long): GlyphSlot.Advance?

    external fun FT_GlyphSlot_Get_format(glyphSlot: Long): Int

    external fun FT_GlyphSlot_Get_bitmap_left(glyphSlot: Long): Int

    external fun FT_GlyphSlot_Get_bitmap_top(glyphSlot: Long): Int

    external fun FT_GlyphSlot_Get_bitmap(glyphSlot: Long): Long /* Pointer to Bitmap */

    external fun FT_GlyphSlot_Get_metrics(glyphSlot: Long): Long /* Pointer to GlyphMetrics */

    //	public static native long     FT_Get_Glyph                      (long glyphSlot); /* Pointer to Glyph */
    //	public static native SubGlyph FT_Get_SubGlyph_Info				(long glyphSlot, int subIndex);
    external fun FT_Render_Glyph(glyphSlot: Long, renderMode: Int): Boolean

    // ---- GlyphMetrics
    external fun FT_Glyph_Metrics_Get_width(glyphMetrics: Long): Int

    external fun FT_Glyph_Metrics_Get_height(glyphMetrics: Long): Int

    external fun FT_Glyph_Metrics_Get_horiAdvance(glyphMetrics: Long): Int

    external fun FT_Glyph_Metrics_Get_vertAdvance(glyphMetrics: Long): Int

    external fun FT_Glyph_Metrics_Get_horiBearingX(glyphMetrics: Long): Int

    external fun FT_Glyph_Metrics_Get_horiBearingY(glyphMetrics: Long): Int

    external fun FT_Glyph_Metrics_Get_vertBearingX(glyphMetrics: Long): Int

    external fun FT_Glyph_Metrics_Get_vertBearingY(glyphMetrics: Long): Int

    // ---- Bitmap
    external fun FT_Bitmap_Get_width(bitmap: Long): Int

    external fun FT_Bitmap_Get_rows(bitmap: Long): Int

    external fun FT_Bitmap_Get_pitch(bitmap: Long): Int

    external fun FT_Bitmap_Get_num_grays(bitmap: Long): Short

    external fun FT_Bitmap_Get_palette_mode(bitmap: Long): Char

    external fun FT_Bitmap_Get_pixel_mode(bitmap: Long): Char

    external fun FT_Bitmap_Get_buffer(bitmap: Long): ByteBuffer?

    // ---- Charmap
    external fun FT_Get_Charmap_Index(charmap: Long): Int

    // ---- Glyph
    // TODO
    /* Java Object functions */
    fun newLibrary(): Library? {
        val library = FT_Init_FreeType()
        if (library == 0L) return null
        return Library(library)
    }

    /* --------------------- */
    init { // Load library
        try {
            System.loadLibrary("freetype-jni")
            /*
			if (System.getProperty("os.name").toLowerCase().indexOf("win") >= 0) {
				int bits = 86;
				if (System.getProperty("os.arch").contains("64"))
					bits = 64;
				System.loadLibrary("freetype26MT_x" + bits);
			} else
				throw new Exception("Operating system not supported.");
				*/
        } catch (e: UnsatisfiedLinkError) {
            System.err.println("Can't find the native file for FreeType-jni.")
            throw e
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}