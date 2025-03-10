package com.pvporbit.freetype

import java.io.IOException
import java.nio.ByteBuffer
import java.nio.ByteOrder

/**
 * Each library is completely independent from the others; it is the root of a set of objects like fonts, faces, sizes, etc.
 */
class Library(pointer: Long) : NativeWrapper(pointer) {
    /**
     * Destroy the library object and all of it's childrens, including faces, sizes, etc.
     */
    fun delete(): Boolean {
        return FreeType.FT_Done_FreeType(pointer)
    }

    /**
     * Create a new Face object from file<br></br>
     * It will return null in case of error.
     */
    fun newFace(file: String, faceIndex: Int): Face? {
        try {
            return newFace(Utils.loadFileToByteArray(file), faceIndex)
        } catch (e: IOException) {
            return null
        }
    }

    /**
     * Create a new Face object from a byte[]<br></br>
     * It will return null in case of error.
     */
    fun newFace(bytes: ByteArray, faceIndex: Int): Face? {
        val buffer = Utils.newBuffer(bytes.size)
        buffer!!.order(ByteOrder.nativeOrder())
        buffer.limit(buffer.position() + bytes.size)
        Utils.fillBuffer(bytes, buffer, bytes.size)
        return newFace(buffer, faceIndex)
    }

    /**
     * Create a new Face object from a ByteBuffer.<br></br>
     * It will return null in case of error.<br></br>
     * Take care that the ByteByffer must be a direct buffer created with Utils.newBuffer and filled with Utils.fillBuffer.
     */
    fun newFace(buffer: ByteBuffer, faceIndex: Int): Face? {
        val face = FreeType.FT_New_Memory_Face(pointer, buffer, buffer.remaining(), faceIndex.toLong())
        if (face == 0L) {
            Utils.deleteBuffer(buffer)
            return null
        }
        return Face(face, buffer)
    }

    val version: LibraryVersion
        /**
         * Returns a LibraryVersion object containing the information about the version of FreeType
         */
        get() = FreeType.FT_Library_Version(pointer)
}