package com.lld.model;

public class Board {

    private Cell[] cells;

    public Board(){
        cells = new Cell[101];
    }

    public Cell getCell(Integer cellId){
        if(cellId < 0 && cellId > 100){
            throw new RuntimeException("Invalid Cell");
        }
        return cells[cellId];
    }
    public void setCell(Cell cell){
        if(cell.getId().isPresent())
            cells[cell.getId().get()] = cell;
    }
    public void setDefault(){
        for(int i=0; i <= 100; i++){
             this.cells[i] = new Cell(i, false,false, 0);
        }
    }
}
