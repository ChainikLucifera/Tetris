package com.example.tetris.models

import com.example.tetris.helpers.array2dOfByte

class Frame(private val width: Int) {
    val data: ArrayList<ByteArray> = ArrayList()

    /**
     * Добавляет строку в фигуру
     * @param byteStr Строка, где каждый символ ('0' или '1') определяет
     * @return this цепочки вызовов
     */
    fun addRow(byteStr: String): Frame{
        val row = ByteArray(byteStr.length)

        for(index in byteStr.indices){
            row[index] = byteStr[index].toString().toByte()
        }

        data.add(row)
        return this
    }
    fun as2dByteArray(): Array<ByteArray>{
        val bytes = array2dOfByte(data.size,width)
        return data.toArray(bytes)
    }
}