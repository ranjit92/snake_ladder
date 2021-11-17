package com.lld.model;

public class Player {
    private final String name;
    private Cell playerCurrentCell;

    public Player(final String name){
        this.name = name;
        this.playerCurrentCell = new Cell(0,false,false,0);
    }

    public String getName(){
        return this.name;
    }

    public void setPlayerCurrentCell(Cell cell){
        this.playerCurrentCell = cell;
    }
    public Cell getPlayerCurrentCell(){
        return this.playerCurrentCell;
    }


    @Override
    public boolean equals(Object obj){
        if(this ==  obj) return true;
        if(obj == null || obj.getClass() != this.getClass()) return false;

        Player pl = (Player)obj;

        if(pl.getName().equals(this.getName())){
            return true;
        }
        return false;
    }

}
