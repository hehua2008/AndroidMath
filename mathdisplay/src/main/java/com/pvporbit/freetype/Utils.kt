package com.pvporbit.freetype

import java.io.BufferedInputStream
import java.io.File
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.IOException
import java.nio.ByteBuffer

object Utils {
    @Throws(IOException::class, FileNotFoundException::class)
    fun loadFileToByteArray(filepath: String): ByteArray {
        val file = File(filepath)
        val size = file.length().toInt()
        val bytes = ByteArray(size)
        val buf = BufferedInputStream(FileInputStream(file))
        buf.read(bytes, 0, bytes.size)
        buf.close()
        return bytes
    }

    /* Buffer helpers */
    external fun newBuffer(size: Int): ByteBuffer?

    external fun fillBuffer(bytes: ByteArray?, buffer: ByteBuffer?, length: Int)

    external fun deleteBuffer(buffer: ByteBuffer?)

    open class Pointer(var pointer: Long)
}