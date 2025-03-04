package com.pvporbit.freetype

class Vector(pointer: Long) : NativeWrapper(pointer) {
    val x: Int
        get() = FreeType.FT_Vector_Get_x(pointer)

    val y: Int
        get() = FreeType.FT_Vector_Get_y(pointer)

    override fun toString(): String {
        return "($x,$y)"
    }
}