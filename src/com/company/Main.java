package com.company;

import java.sql.SQLOutput;
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

        //getActivePlayer
        //fill
        int playerActive = 0;

        while (true) {

            int userInput = sc.nextInt();

            int[] playerNumber = {0,1};
            char[] playerSymbol = {'o','x'};



            for (int i = 5; i>=0; i -= 1) {
                if (playField[userInput][i] == playFieldEmptySlot) {
                    playField[userInput][i] = playerSymbol[playerActive];
                    if (playerActive<playerNumber.length) {
                        playerActive++;
                    } else {
                        playerActive=0;
                    }
                }
            }

            printPlayField(playField);





        }


    }

    private static void fillPlayField(char playFieldFiller) {
        for (char[] i : playField) {
            Arrays.fill(i, playFieldFiller);
        }
    }

    private static void printPlayField(char[][] playField) {
        for (int j = 0; j<ROWS; j++) {
            for (int i = 0; i<COLUMNS; i++) {
                System.out.print(playField[i][j]);
            }
            System.out.println();
        }
    }


}
