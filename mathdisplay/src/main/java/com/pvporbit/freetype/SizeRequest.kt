package com.pvporbit.freetype

import com.pvporbit.freetype.FreeTypeConstants.FT_Size_Request_Type

class SizeRequest(
    type: FT_Size_Request_Type,
    var width: Long,
    var height: Long,
    var horiResolution: Int,
    var vertResolution: Int
) {
    private var type: Int

    init {
        this.type = type.ordinal
    }

    fun getType(): FT_Size_Request_Type {
        return FT_Size_Request_Type.entries[type]
    }

    fun setType(type: FT_Size_Request_Type) {
        this.type = type.ordinal
    }

    fun setWidth(width: Int) {
        this.width = width.toLong()
    }

    fun setHeight(height: Int) {
        this.height = height.toLong()
    }
}