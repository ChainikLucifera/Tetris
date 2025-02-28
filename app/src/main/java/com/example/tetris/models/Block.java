package com.example.tetris.models;

import android.graphics.Point;

import com.example.tetris.constants.FieldConstants;

public class Block {

    private final int shapeIndex;
    private int frameNumber;
    private final BlockColor color;
    private Point position;

    private Block(int shapeIndex, BlockColor color){
           this.frameNumber = 0;
           this.shapeIndex = shapeIndex;
           this.color = color;
           this.position = new Point(FieldConstants.COLUMN_COUNT.getValue()/2, 0);
    }
    public enum BlockColor{

    }
}
