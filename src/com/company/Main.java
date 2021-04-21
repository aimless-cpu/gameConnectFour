package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static final int ROWS = 6;
    public static final int COLUMNS = 7;
    static char[][] playField = new char[COLUMNS][ROWS];

    public static void main(String[] args) {runGame();}
    public static void runGame() {

        char playFieldEmptySlot = '*';
        fillPlayField(playFieldEmptySlot);

        //boolean isPlayer1 = true;

        while (true) {

            int userInput = sc.nextInt();

        }


    }

    private static void fillPlayField(char playFieldFiller) {
        for (char[] i : playField) {
            Arrays.fill(i, playFieldFiller);
        }
    }
}
