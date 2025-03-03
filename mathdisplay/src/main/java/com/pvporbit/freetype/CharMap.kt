package com.pvporbit.freetype

class CharMap(pointer: Long) : Utils.Pointer(pointer) {
    companion object {
        fun getCharmapIndex(charmap: CharMap): Int {
            return FreeType.FT_Get_Charmap_Index(charmap.pointer)
        }
    }
}