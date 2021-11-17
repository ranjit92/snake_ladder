package com.lld.Service;

import com.lld.model.Board;
import com.lld.model.Cell;
import com.lld.model.Moves;
import com.lld.model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
    private Player[] players;
    private Board board;
    private Player currPlayer;
    private List<Moves> listMoves;

    public Game() {
        this.board = new Board();
        this.players = new Player[2];
        this.listMoves = new ArrayList<>();
    }

    public void setPlayer(Player[] players) {
        this.players = players;
    }

    public void setCell(Integer cellId, boolean isLadderTail, boolean isSnackHead, Integer dest) {
        Cell cell = new Cell(cellId, isLadderTail, isSnackHead, dest);
        board.setCell(cell);
    }

    public void resetDefault() {
        board.setDefault();
    }

    public void startGame() {

        while (true) {
            if (currPlayer == null) {
                currPlayer = players[0];
            } else if (currPlayer.equals(players[0])) {
                currPlayer = players[1];
            } else {
                currPlayer = players[0];
            }
            Cell currCell = currPlayer.getPlayerCurrentCell();

            int diceRolled = getRandomDice();
            Integer newDist = currCell.getId().get() + diceRolled;

            Cell actualDestCell = getActualDistCell(newDist, currCell);

            Moves moves = new Moves(currCell, actualDestCell, currPlayer);
            listMoves.add(moves);

            currPlayer.setPlayerCurrentCell(actualDestCell);
            print(currPlayer.getName(), diceRolled, currCell.getId().get(), actualDestCell.getId().get());
            if (actualDestCell.getId().get() == 100) {
                System.out.println(currPlayer.getName() + " won the game :)");
                return;
            }
        }
    }

    private Integer getRandomDice() {
        return ThreadLocalRandom.current().nextInt(1, 6 + 1);
    }

    public void print(String name, Integer diceRolled, Integer from, Integer to) {
        System.out.println(String.format("%s rolled a %s and moved from %s to %s", name, diceRolled, from, to));
    }

    public Cell getActualDistCell(Integer distCell, Cell currCell) {
        Cell result = currCell;
        if (distCell <= 100) {
            result = board.getCell(distCell);
        }

        if (result.isLadderTail() || result.isSnackHead()) {
            Integer actualDest = result.getDest();
            result = board.getCell(actualDest);
        }
        return result;
    }
}
