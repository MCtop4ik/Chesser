package com.example.chesser;

import static java.lang.Math.abs;

import java.util.Arrays;
import java.util.Locale;

class Desk {
    String[][] boardArray = {
            {"r", "n", "b", "q", "k", "b", "n", "r"},
            {"p", "p", "p", "p", "p", "p", "p", "p"},
            {"", "", "", "", "", "", "", ""},
            {"", "", "", "", "", "", "", ""},
            {"", "", "", "", "", "", "", ""},
            {"", "", "", "", "", "", "", ""},
            {"P", "P", "P", "P", "P", "P", "P", "P"},
            {"R", "N", "B", "Q", "K", "B", "N", "R"},
            {""}};

    public static int queue;
    public void move(int i, int j, int last_i, int last_j, String taken_piece){
        boardArray[i][j] = taken_piece;
        boardArray[last_i][last_j] = "";
    }

    public void makeMove(){
        int last_i = TestSurfaceView.last_i;
        int i = TestSurfaceView.saved_i;
        int last_j = TestSurfaceView.last_j;
        int j = TestSurfaceView.saved_j;
        String taken_piece = boardArray[last_i][last_j];
        int color;
        if (queue == 0)
            color = -1;
        else
            color = 1;
        if (taken_piece.toLowerCase(Locale.ROOT).equals("p")
                && checkPawn(last_i, last_j, i, j, color)){
            boardArray[i][j] = taken_piece;
            if (i == 0 && color == 1){
                boardArray[i][j] = "Q";
            }else if(i == 7 && color == -1){
                boardArray[i][j] = "q";
            }
            boardArray[last_i][last_j] = "";
            queue -= color;
        }

        if (taken_piece.toLowerCase(Locale.ROOT).equals("n") && checkKnight(last_i, last_j, i, j, color)){
            if (Character.isLowerCase(boardArray[i][j].charAt(0)) && queue == 1) {
                move(i, j, last_i, last_j, taken_piece);
                queue -= color;
            }else if(Character.isUpperCase(boardArray[i][j].charAt(0)) && queue == 0){
                move(i, j, last_i, last_j, taken_piece);
                queue -= color;
            }
        }
        if (taken_piece.toLowerCase(Locale.ROOT).equals("b") && checkBishop(last_i, last_j, i, j, color)){
            move(i, j, last_i, last_j, taken_piece);
            queue -= color;
        }
        if (taken_piece.toLowerCase(Locale.ROOT).equals("r") && checkRook(last_i, last_j, i, j, color)){
            move(i, j, last_i, last_j,taken_piece);
            queue -= color;
        }
        if (taken_piece.toLowerCase(Locale.ROOT).equals("q") && checkQueen(last_i, last_j, i, j, color)){
            move(i, j, last_i, last_j, taken_piece);
            queue -= color;
        }
    }

    public boolean eats(int i, int j, int color) {
        if (color > 0)
            return (boardArray[i][j].length() == 0) || Character.isLowerCase(boardArray[i][j].charAt(0));
        else
            return (boardArray[i][j].length() == 0) || Character.isUpperCase(boardArray[i][j].charAt(0));
    }

    public boolean eatsEverything(int i, int j) {
        return boardArray[i][j].length() != 0;
    }

    public boolean checkKnight(int last_i, int last_j, int i, int j, int color) {
        int dx = abs(i - last_i);
        int dy = abs(j - last_j);
        return (((dx == 1 && dy == 2) || (dx == 2 && dy == 1)) && eats(i, j, color));
    }

    public boolean checkKing(int last_i, int last_j, int i, int j, int color) {
        return (abs(last_i - i) <= 1 && abs(last_j - j) <= 1) && eats(i, j, color);
    }

    public boolean checkBishop(int last_i, int last_j, int i, int j, int color) {
        if ((abs(i - last_i) == abs(j - last_j)) && eats(i, j, color))
            if (i > last_i)
                if (j > last_j)
                    for (int i5 = 1; i5 < j - last_j; i5++)
                        if (eatsEverything(last_i + i5, last_j + i5))
                            return false;
                        else
                            for (int i2 = 1; i2 < last_j - j; i2++)
                                if (eatsEverything(last_i + i5, last_j - i5))
                                    return false;
                                else if (j > last_j)
                                    for (int i3 = 1; i3 < j - last_j; i3++)
                                        if (eatsEverything(last_i - i5, last_j + i5))
                                            return false;
                                        else
                                            for (int i4 = 1; i4 < last_j - j; i4++)
                                                if (eatsEverything(last_i - i4, last_j - i4))
                                                    return false;
        return true;
    }

    public boolean checkPawn(int last_i, int last_j, int i, int j, int color) {
        for (String[] strings : boardArray) {
            System.out.println(Arrays.toString(strings));
        }
        if (last_i == i + (2 * color) && (last_i == 1 || last_i == 6 * color) && boardArray[i][last_j].equals("") && last_j == j) {
            return true;
        } else if (last_i == i + color && boardArray[i][last_j].equals("") && last_j == j) {
            return true;
        } else return last_i == i + color && (j == last_j + 1 || j == last_j - 1)
                && eats(i, j, color) && !boardArray[i][j].equals("");
    }

    public boolean checkRook(int last_i, int last_j, int i, int j, int color) {
        if (((i == last_i) || (j == last_j)) && eats(i, j, color)) {
            if (i == last_i) {
                if (j > last_j) {
                    for (int k = 1; k < j - last_j; k++) {
                        if (eatsEverything(i, last_j + k)) {
                            return false;
                        }
                    }
                } else {
                    for (int k = 1; k < last_j - j; k++) {
                        if (eatsEverything(i, j + k)) {
                            return false;
                        }
                    }
                }
            } else {
                if (i > last_i) {
                    for (int k = 1; k < i - last_i; k++) {
                        if (eatsEverything(last_i + k, j)) {
                            return false;
                        }
                    }
                } else {
                    for (int k = 1; k < last_i - i; k++) {
                        if (eatsEverything(i + k, j)) {
                            return false;
                        }
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean checkQueen(int last_i, int last_j, int i, int j, int color){
        if(((abs(i - last_i) == abs(j - last_j)) || ((i == last_i) || (j == last_j))) && eats(i, j, color)){
            if (i == last_i){
                if (j > last_j){
                    for (int k = 1; k < j-last_j; k++){
                        if (eatsEverything(i, last_j + k)){
                            return false;
                        }
                    }
                }else{
                    for (int k = 1; k < last_j-j; k++){
                        if (eatsEverything(i, j + k)){
                            return false;
                        }
                    }
                }
            }
            if (j == last_j){
                if (i > last_i){
                    for (int k = 1; k < i-last_i; k++){
                        if (eatsEverything(last_i + k, j)){
                            return false;
                        }
                    }
                }else{
                    for (int k = 1; k < last_i-i; k++){
                        if (eatsEverything(i + k, j)){
                            return false;
                        }
                    }
                }
            }
            if(i > last_i){
                if(j > last_j){
                    for (int k = 1; k < j-last_j; k++){
                        if (eatsEverything(last_i + k, last_j + k)){
                            return false;
                        }
                    }
                }else{
                    for (int k = 1; k < last_j - j; k++){
                        if (eatsEverything(last_i + k, last_j - k)){
                            return false;
                        }
                    }
                }
            }else{
                if(j > last_j){
                    for (int k = 1; k < j - last_j; k++){
                        if (eatsEverything(last_i - k, last_j + k)){
                            return false;
                        }
                    }
                }else{
                    for (int k = 1; k < last_j - j; k++){
                        if (eatsEverything(last_i - k, last_j - k)){
                            return false;
                        }
                    }
                }
            }
            return true;
        }else{
            return false;
        }
    }

}
