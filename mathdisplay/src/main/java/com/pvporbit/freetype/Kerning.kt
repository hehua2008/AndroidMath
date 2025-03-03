package com.pvporbit.freetype

class Kerning(val horizontalKerning: Int, val verticalKerning: Int) {
    override fun toString(): String {
        return "Kerning(" + horizontalKerning + ", " + verticalKerning + ")"
    }
}