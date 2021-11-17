package com.lld.model;

import java.util.Optional;

public class Cell {
    private Integer cellId;

    private boolean isLadderTail;
    private boolean isSnackHead;
    private Integer dest;

    public Cell(Integer cellId, boolean isLadderTail, boolean isSnackHead, Integer dest) {
        this.cellId = cellId;
        this.isLadderTail = isLadderTail;
        this.isSnackHead = isSnackHead;
        this.dest = dest;
    }

    public boolean isLadderTail(){
        return this.isLadderTail;
    }
    public boolean isSnackHead(){
        return this.isSnackHead;
    }

    public Integer getDest(){
        return this.dest;
    }

    public Optional<Integer> getId(){
        return Optional.ofNullable(this.cellId);
    }

    @Override
    public String toString() {
        return "Cell{" +
                "cellId=" + cellId +
                ", isLadderTail=" + isLadderTail +
                ", isSnackHead=" + isSnackHead +
                ", dest=" + dest +
                '}';
    }

}
