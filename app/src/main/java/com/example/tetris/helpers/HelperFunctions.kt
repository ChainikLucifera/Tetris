package com.example.tetris.helpers

import com.example.tetris.models.Shape

fun array2dOfByte(sizeOuter: Int, sizeInner: Int): Array<ByteArray> =
    Array(sizeOuter) { ByteArray(sizeInner)
    }

