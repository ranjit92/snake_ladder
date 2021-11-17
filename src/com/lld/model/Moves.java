package com.lld.model;

public class Moves {
    private Cell from;
    private Cell to;
    private Player player;


    public Moves(final Cell from, final Cell to, final Player player) {
        this.from = from;
        this.to = to;
        this.player = player;
    }

    public Cell getFrom() {
        return from;
    }

    public Cell getTo() {
        return to;
    }

    public Player getPlayer() {
        return player;
    }
}
