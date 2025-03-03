package com.pvporbit.freetype

class CharMap(pointer: Long) : NativeWrapper(pointer) {
    fun getIndex(): Int {
        return FreeType.FT_Get_Charmap_Index(pointer)
    }
}