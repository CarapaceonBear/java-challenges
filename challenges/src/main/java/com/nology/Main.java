package com.nology;

public class Main {

    public static void main(String[] args) {

        int[][] emptyGame = {{-1,-1,-1},
                             {-1,-1,-1},
                             {-1,-1,-1}};
        int[][] midGame =  {{ 1,-1, 0},
                            { 0, 0, 1},
                            { 1,-1,-1}};
        int[][] noughtsWin = {{ 1,-1, 0},
                              { 0, 0, 0},
                              { 1,-1, 1}};
        int[][] crossWin = {{ 1,-1, 0},
                            { 1, 0,-1},
                            { 1, 0,-1}};
        int[][] drawGame = {{ 1, 0, 0},
                            { 0, 0, 1},
                            { 1, 1, 0}};

        System.out.println(getWinningPlayer(emptyGame));
        System.out.println(getWinningPlayer(midGame));
        System.out.println(getWinningPlayer(noughtsWin));
        System.out.println(getWinningPlayer(crossWin));
        System.out.println(getWinningPlayer(drawGame));
    }

    public static int getWinningPlayer(int[][] game) {
        int winner = -1;
        for (int player = 0; player < 2; player++) {
            for (int[] row : game) {
                if ((row[0] == player) && (row[1] == player) && (row[2] == player)) {
                    winner = player;
                    break;
                }
            }
            for (int i = 0; i < 3; i++) {
                if ((game[0][i] == player) && (game[1][i] == player) && (game[2][i] == player)) {
                    winner = player;
                    break;
                }
            }
            if (game[1][1] == player) {
                if (((game[0][0] == player) && (game[2][2] == player)) || ((game[0][2] == player) && (game[2][0] == player))) {
                    winner = player;
                    break;
                }
            }
        }
        return winner;
    }
}
