package com.example.tetris.models

import android.graphics.Point
import com.example.tetris.AppPreferences
import com.example.tetris.constants.CellConstants
import com.example.tetris.constants.FieldConstants
import com.example.tetris.helpers.array2dOfByte

class AppModel {
    var score: Int = 0
    private var preferences: AppPreferences? = null

    var currentBlock: Block? = null
    var currentState: String = Statuses.AWAITING_START.name
    private var field: Array<ByteArray> = array2dOfByte(
        FieldConstants.ROW_COUNT.value,
        FieldConstants.COLUMN_COUNT.value
    )

    fun isGameActive(): Boolean {
        return currentState == Statuses.ACTIVE.name
    }

    fun isGameAwaiting(): Boolean {
        return currentState == Statuses.AWAITING_START.name
    }

    fun isGameOver(): Boolean {
        return currentState == Statuses.OVER.name
    }

    private fun boostScore() {
        score += 10;
        if (score > preferences?.getHighScore() as Int) {
            preferences?.saveHighScore(score)
        }
    }

    private fun generateNextBlock(){
        currentBlock = Block.createBlock()
    }
    private fun validTransaction(position: Point, shape: Array<ByteArray>): Boolean{
        return if(position.y < 0 || position.x < 0) {false}
        else if(position.y + shape.size > FieldConstants.ROW_COUNT.value) {false}
        else if(position.x + shape[0].size > FieldConstants.COLUMN_COUNT.value) {false}
        else {
            for(i in shape.indices){
                for(j in 0 until shape[i].size){
                    val x = position.x + j
                    val y = position.y + i
                    if(shape[i][j] != CellConstants.EMPTY.value &&
                        field[x][y] != CellConstants.EMPTY.value){
                        return false
                    }
                }
            }
            true
        }

    }
    fun setPreferences(preferences: AppPreferences?) {
        this.preferences = preferences
    }

    fun getCellStatus(row: Int, column: Int): Byte? {
        return field[row][column]
    }

    private fun setCellStatus(row: Int, column: Int, status: Byte?) {
        if (status != null) {
            field[row][column] = status
        }
    }

    enum class Statuses {
        AWAITING_START,
        ACTIVE,
        OVER;
    }

    enum class Motions {
        LEFT,
        RIGHT,
        DOWN,
        ROTATE;
    }

}