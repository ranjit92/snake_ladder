package com.lld;

import com.lld.Service.Game;
import com.lld.model.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class Driver {
    public static void main(String[] args) {

        BufferedReader br = null;
        InputStream in = null;
        Game game = new Game();
        game.resetDefault();

        in = System.in;
        br = new BufferedReader(new InputStreamReader(in));
        String line = null;
        while (true) {
            try {
                if ((line = br.readLine()) != null) {
                    Integer num = getNumeric(line);
                    if (num != null) {
                        for (int i = 0; i < num; i++) {
                            line = br.readLine();
                            String[] inline = line.split(" ");
                            game.setCell(getNumeric(inline[0]), false, true, getNumeric(inline[1]));
                        }

                    }
                    line = br.readLine();
                    num = getNumeric(line);
                    if (num != null) {
                        for (int i = 0; i < num; i++) {
                            line = br.readLine();
                            String[] inline = line.split(" ");
                            game.setCell(getNumeric(inline[0]), true, false, getNumeric(inline[1]));
                        }
                    }
                    line = br.readLine();
                    num = getNumeric(line);
                    Player[] players = new Player[2];
                    for (int i = 0; i < num; i++) {
                        line = br.readLine();
                        players[i] = new Player(line);
                    }
                    game.setPlayer(players);
                }
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        game.startGame();
    }

    public static Integer getNumeric(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException ex) {
            return null;
        }
    }
}
