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

        //getActivePlayer
        //fill
        int playerActive = 0;

        while (true) {

            int playerInput = sc.nextInt();

            int[] playerNumber = {0,1};
            char[] playerSymbol = {'o','x'};


            setPlayerInput(playFieldEmptySlot, playerActive, playerInput, playerSymbol);

            printPlayField(playField);

            if (hasWinner(playerActive, playerSymbol)) {
                System.out.println("Winner");
                System.exit(0);
            }

            playerActive = iteratePlayerActive(playerActive, playerNumber);


        }


    }

    private static int iteratePlayerActive(int playerActive, int[] playerNumber) {
        if (playerActive < playerNumber.length - 1) {
            playerActive++;
        } else {
            playerActive = 0;
        }
        return playerActive;
    }

    private static boolean hasWinner(int playerActive, char[] playerSymbol) {
        return hasWinnerHorizontal(playerActive, playerSymbol) || hasWinnerVertical(playerActive, playerSymbol) || hasWinnerDiagonal(playerActive, playerSymbol);
    }

    private static boolean hasWinnerDiagonal(int playerActive, char[] playerSymbol) {
        for (int r = 0; r < ROWS-3; r++) {
            for (int c = 0; c < COLUMNS-3; c++) {
                if (playField[c][r] == playerSymbol[playerActive]) {
                    for (int c2 = c; c2 < c + 4; c2++) {
                        for (int r2 = r; r2 < r +4; r2++) {
                            if (playField[c2][r2] != playerSymbol[playerActive] && r2 == r + 3) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return  false;
    }

    private static boolean hasWinnerVertical(int playerActive, char[] playerSymbol) {
        for (int c = 0; c < COLUMNS; c++) {
            for (int r = 0; r < ROWS-3; r++) {
                if (playField[c][r] == playerSymbol[playerActive]) {
                    for (int r2 = r; r2 < r + 4; r2++) {
                        if (playField[c][r2] != playerSymbol[playerActive]) {
                            break;
                        } else if (playField[c][r2] == playerSymbol[playerActive] && r2 == r + 3)
                            return true;
                    }
                }
            }
        }
        return false;
    }


    private static boolean hasWinnerHorizontal(int playerActive, char[] playerSymbol) {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLUMNS-3; c++) {
                if (playField[c][r] == playerSymbol[playerActive]) {
                    for (int c2 = c; c2 < c + 4; c2++) {
                        if (playField[c2][r] != playerSymbol[playerActive]) { // BUG must be != playerSymbol
                            break;
                        } else if (playField[c2][r] == playerSymbol[playerActive] && c2 == c + 3) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private static void setPlayerInput(char playFieldEmptySlot, int playerActive, int userInput, char[] playerSymbol) {
        for (int i = 5; i>=0; i -= 1) {
            if (playField[userInput][i] == playFieldEmptySlot) {
                playField[userInput][i] = playerSymbol[playerActive];
                break;
            }
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
