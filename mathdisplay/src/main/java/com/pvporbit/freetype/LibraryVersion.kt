package com.pvporbit.freetype

/**
 * This is a simple class wich contains the version information about FreeType.
 * Example: 2.6.0
 */
class LibraryVersion(
    val major: Int,
    val minor: Int,
    val patch: Int
) {
    override fun toString(): String {
        return "$major.$minor.$patch"
    }
}