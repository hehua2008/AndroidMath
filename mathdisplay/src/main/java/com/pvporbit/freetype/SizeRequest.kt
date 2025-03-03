package com.pvporbit.freetype

class SizeRequest(
    var type: SizeRequestType,
    var width: Long,
    var height: Long,
    var horiResolution: Int,
    var vertResolution: Int
) {
    fun getTypeInt(): Int = type.ordinal
}