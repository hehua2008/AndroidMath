cmake_minimum_required(VERSION 3.4.1)

add_library( # Sets the name of the library.
             main

             # Sets the library as a shared library.
             SHARED

             # Provides a relative path to your source file(s).
             # Associated headers in the same location as their source
             # file are automatically included.
             freetype_jni.cpp
             )

target_include_directories(main PUBLIC "freetype/include")

target_link_libraries(main ${CMAKE_SOURCE_DIR}/libfreetype.a)

target_link_libraries(main log android)
