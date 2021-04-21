package com.company;

import java.util.Arrays;

public class Main {
    public static final int ROWS = 6;
    public static final int COLUMNS = 7;
    static char[][] playField = new char[COLUMNS][ROWS];

    public static void main(String[] args) {runGame();}
    public static void runGame() {

        char playFieldFiller = '*';
        fillPlayField(playFieldFiller);


    }

    private static void fillPlayField(char playFieldFiller) {
        for (char[] i : playField) {
            Arrays.fill(i, playFieldFiller);
        }
    }
}
