package com.company;

import javax.swing.*;
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

            int playerInput = sc.nextInt();

            int[] playerNumber = {0,1,2};
            char[] playerSymbol = {'o','x','z'};


            playerActive = setPlayerInput(playFieldEmptySlot, playerActive, playerInput, playerNumber, playerSymbol);

            printPlayField(playField);

            hasWinnerHorizontal(playerActive, playerSymbol, playFieldEmptySlot);

            if (hasWinnerHorizontal(playerActive, playerSymbol, playFieldEmptySlot)) {
                System.out.println("Winner");
            }





        }


    }
    private static  boolean hasWinner() {
            return false;
    }

    private static boolean hasWinnerHorizontal(int playerActive, char[] playerSymbol, char playFieldEmptySlot) {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLUMNS; c++) {
                if (playField[c][r] == playerSymbol[playerActive]) {
                    for (int c2 = c; c2 < c + 4; c2++) {
                        if (playField[c2][r] == playFieldEmptySlot) {
                            break;
                        }
                        else if (playField[c2][r] == playerSymbol[playerActive] && c2 == c + 3) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private static int setPlayerInput(char playFieldEmptySlot, int playerActive, int userInput, int[] playerNumber, char[] playerSymbol) {
        for (int i = 5; i>=0; i -= 1) {
            if (playField[userInput][i] == playFieldEmptySlot) {
                playField[userInput][i] = playerSymbol[playerActive];
                if (playerActive < playerNumber.length-1) {
                    playerActive++;
                    break;
                } else {
                    playerActive = 0;
                    break;
                }
            }
        }
        return playerActive;
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
