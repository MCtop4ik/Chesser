package com.example.chesser;

import static java.lang.Math.abs;

import java.util.ArrayList;
import java.util.Locale;

class Desk {
    boolean whiteUnderCheck = false;
    boolean blackUnderCheck = false;

    boolean WRCL = true;
    boolean WRCS = true;
    boolean BRCL = true;
    boolean BRCS = true;

    static String[][] boardArray = {
            {"r", "n", "b", "q", "k", "b", "n", "r"},
            {"p", "p", "p", "p", "p", "p", "p", "p"},
            {"", "", "", "", "", "", "", ""},
            {"", "", "", "", "", "", "", ""},
            {"", "", "", "", "", "", "", ""},
            {"", "", "", "", "", "", "", ""},
            {"P", "P", "P", "P", "P", "P", "P", "P"},
            {"R", "N", "B", "Q", "K", "B", "N", "R"},
            {""}};

    static String latestPiece = "";
    public static int color = 1;


    public void convertFen(String fen){
        fen = fen.replace("1", " ");
        fen = fen.replace("2", "  ");
        fen = fen.replace("3", "   ");
        fen = fen.replace("4", "    ");
        fen = fen.replace("5", "     ");
        fen = fen.replace("6", "      ");
        fen = fen.replace("7", "       ");
        fen = fen.replace("8", "        ");
        fen = fen.replace("/", "");
        int countToEight = -1;
        int j = 0;
        for (int i = 0; i < 63; i++){
            if (countToEight == 7){
                j += 1;
                countToEight = 0;
            }else{
                countToEight += 1;
            }
            if (!String.valueOf(fen.charAt(i)).equals(" ")){
                boardArray[j][countToEight] = String.valueOf(fen.charAt(i));}else{
                boardArray[j][countToEight] = "";
            }
        }
    }

    public String makeFEN(String[][] arr){
        String fen = "";
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j].equals("")){
                    count += 1;
                    if (count == 9){
                        fen = fen.concat(String.valueOf(count-1));
                        count = 1;
                    }
                }else{
                    if (count != 0){
                        fen = fen.concat(String.valueOf(count));
                    }
                    fen = fen.concat(arr[i][j]);
                    count = 0;
                }

            }
        }
        return fen;
    }

    public void printBoard() {
        for (String[] line : boardArray) {
            for (String i : line)
                if (i.length() == 0)
                    System.out.print("  ");
                else
                    System.out.print(i + " ");
            System.out.println();
        }
    }

    public void move(int last_i, int last_j, int i, int j) {
        latestPiece = boardArray[i][j];
        boardArray[i][j] = boardArray[last_i][last_j];
        boardArray[last_i][last_j] = "";
    }

    public void makeMove(int last_i, int last_j, int i, int j) {
        NotationHelper nh = new NotationHelper();
        String taken_piece = boardArray[last_i][last_j];
        correctMoves();
        if (taken_piece.toLowerCase(Locale.ROOT).equals("p")
                && checkPawn(last_i, last_j, i, j, color)) {
            if (Character.isLowerCase(boardArray[last_i][last_j].charAt(0)) && color == -1) {
                move(last_i, last_j, i, j);
                if (i == 7) {
                    boardArray[i][j] = "Q";
                }else{
                    nh.makeNotationPawn(j, i, last_j, -1);
                }
                color = -color;
            } else if (Character.isUpperCase(boardArray[last_i][last_j].charAt(0)) && color == 1) {
                move(last_i, last_j, i, j);
                if (i == 0) {
                    boardArray[i][j] = "q";
                }else{
                    nh.makeNotationPawn(j, i, last_j, 1);
                }
                color = -color;
            }
        }

        if (taken_piece.toLowerCase(Locale.ROOT).equals("n") && checkKnight(last_i, last_j, i, j, color)) {
            if (Character.isLowerCase(boardArray[last_i][last_j].charAt(0)) && color == -1) {
                move(last_i, last_j, i, j);
                nh.makeNotation(j, i, "n");
                color = -color;
            } else if (Character.isUpperCase(boardArray[last_i][last_j].charAt(0)) && color == 1) {
                move(last_i, last_j, i, j);
                nh.makeNotation(j, i, "N");
                color = -color;
            }
        }
        if (taken_piece.toLowerCase(Locale.ROOT).equals("b") && checkBishop(last_i, last_j, i, j, color)) {
            if (Character.isLowerCase(boardArray[last_i][last_j].charAt(0)) && color == -1) {
                move(last_i, last_j, i, j);
                nh.makeNotation(j, i, "b");
                color = -color;
            } else if (Character.isUpperCase(boardArray[last_i][last_j].charAt(0)) && color == 1) {
                move(last_i, last_j, i, j);
                nh.makeNotation(j, i, "B");
                color = -color;
            }
        }
        if (taken_piece.toLowerCase(Locale.ROOT).equals("r") && checkRook(last_i, last_j, i, j, color)) {
            if (Character.isLowerCase(boardArray[last_i][last_j].charAt(0)) && color == -1) {
                move(last_i, last_j, i, j);
                nh.makeNotation(j, i, "r");
                color = -color;
            } else if (Character.isUpperCase(boardArray[last_i][last_j].charAt(0)) && color == 1) {
                move(last_i, last_j, i, j);
                nh.makeNotation(j, i, "R");
                color = -color;
            }
            if (color == 1){
                WRCL = false;
                WRCS = false;
            }else{
                BRCL = false;
                BRCS = false;
            }
        }
        if (taken_piece.toLowerCase(Locale.ROOT).equals("q") && checkQueen(last_i, last_j, i, j, color)) {
            if (Character.isLowerCase(boardArray[last_i][last_j].charAt(0)) && color == -1) {
                move(last_i, last_j, i, j);
                nh.makeNotation(j, i, "q");
                color = -color;
            } else if (Character.isUpperCase(boardArray[last_i][last_j].charAt(0)) && color == 1) {
                move(last_i, last_j, i, j);
                nh.makeNotation(j, i, "Q");
                color = -color;
            }
        }
        if (taken_piece.toLowerCase(Locale.ROOT).equals("k") && checkKing(last_i, last_j, i, j, color)) {
            if (Character.isLowerCase(boardArray[last_i][last_j].charAt(0)) && color == -1) {
                move(last_i, last_j, i, j);
                nh.makeNotation(j, i, "k");
                color = -color;
            } else if (Character.isUpperCase(boardArray[last_i][last_j].charAt(0)) && color == 1) {
                move(last_i, last_j, i, j);
                nh.makeNotation(j, i, "K");
                color = -color;
            }
        }else if(last_i == 7 && last_j == 4 && i == 7 && j == 6 &&
                color == 1 && boardArray[7][4].equals("K") && boardArray[7][7].equals("R")
                && boardArray[7][5].equals("") && boardArray[7][6].equals("") && WRCS){
            boardArray[7][4] = "";
            boardArray[7][7] = "";
            boardArray[7][5] = "R";
            boardArray[7][6] = "K";
            NotationHelper.pgn += NotationHelper.numberOfMove + ". O-O ";
            castleRights(color);
            color = -color;
        }else if(last_i == 7 && last_j == 4 && i == 7 && j == 2 &&
                color == 1 && boardArray[7][4].equals("K") && boardArray[7][0].equals("R")
                && boardArray[7][3].equals("") && boardArray[7][2].equals("") && WRCL
                && boardArray[7][1].equals("")){
            boardArray[7][0] = "";
            boardArray[7][4] = "";
            boardArray[7][3] = "R";
            boardArray[7][2] = "K";
            NotationHelper.pgn += NotationHelper.numberOfMove + ". O-O-O ";
            castleRights(color);
            color = -color;
        }else if(last_i == 0 && last_j == 4 && i == 0 && j == 6 &&
                color == -1 && boardArray[0][4].equals("k") && boardArray[0][7].equals("r")
                && boardArray[0][5].equals("") && boardArray[0][6].equals("") && BRCS){
            boardArray[0][4] = "";
            boardArray[0][7] = "";
            boardArray[0][5] = "r";
            boardArray[0][6] = "k";
            NotationHelper.pgn += "O-O ";
            castleRights(color);
            color = -color;
        }else if(last_i == 0 && last_j == 4 && i == 0 && j == 2 &&
                color == -1 && boardArray[0][4].equals("k") && boardArray[0][0].equals("r")
                && boardArray[0][2].equals("") && boardArray[0][3].equals("")
                && boardArray[0][1].equals("") && BRCL){
            boardArray[0][0] = "";
            boardArray[0][4] = "";
            boardArray[0][3] = "r";
            boardArray[0][2] = "k";
            NotationHelper.pgn += "O-O-O ";
            castleRights(color);
            color = -color;
        }
    }

    public void castleRights(int color){
        if (color == 1){
            WRCL = false;
            WRCS = false;
        }else{
            BRCL = false;
            BRCS = false;
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
        if ((abs(i - last_i) == abs(j - last_j)) && eats(i, j, color)) {
            if (i > last_i) {
                if (j > last_j) {
                    for (int i5 = 1; i5 < j - last_j; i5++) {
                        if (eatsEverything(last_i + i5, last_j + i5)) {
                            return false;
                        }
                    }
                } else {
                    for (int i2 = 1; i2 < last_j - j; i2++) {
                        if (eatsEverything(last_i + i2, last_j - i2)) {
                            return false;
                        }
                    }
                }
            } else {
                if (j > last_j) {
                    for (int i3 = 1; i3 < j - last_j; i3++) {
                        if (eatsEverything(last_i - i3, last_j + i3)) {
                            return false;
                        }
                    }

                } else {
                    for (int i4 = 1; i4 < last_j - j; i4++) {
                        if (eatsEverything(last_i - i4, last_j - i4)) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    public boolean checkPawn(int last_i, int last_j, int i, int j, int color) {
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

    public boolean checkQueen(int last_i, int last_j, int i, int j, int color) {
        if (((abs(i - last_i) == abs(j - last_j)) || ((i == last_i) || (j == last_j))) && eats(i, j, color)) {
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
            }
            if (j == last_j) {
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
            if (i > last_i) {
                if (j > last_j) {
                    for (int k = 1; k < j - last_j; k++) {
                        if (eatsEverything(last_i + k, last_j + k)) {
                            return false;
                        }
                    }
                } else {
                    for (int k = 1; k < last_j - j; k++) {
                        if (eatsEverything(last_i + k, last_j - k)) {
                            return false;
                        }
                    }
                }
            } else {
                if (j > last_j) {
                    for (int k = 1; k < j - last_j; k++) {
                        if (eatsEverything(last_i - k, last_j + k)) {
                            return false;
                        }
                    }
                } else {
                    for (int k = 1; k < last_j - j; k++) {
                        if (eatsEverything(last_i - k, last_j - k)) {
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

    public void checkable(int l, int k){
        if (boardArray[l][k].toLowerCase().equals("k")){
            if (color == 1){
                System.out.println("check from white");
                whiteUnderCheck = true;
                NotationHelper.pgn += "+";
            }
            else{
                System.out.println("check from black");
                NotationHelper.pgn += "+";
                blackUnderCheck = true;}
        }
    }

    public ArrayList<Move> correctMoves() {
        ArrayList<Move> movesArray = new ArrayList<Move>();
        for (int m = 0; m < 8; m++)
            for (int n = 0; n < 8; n++) {
                if (boardArray[m][n].length() == 0)
                    continue;
                char s = boardArray[m][n].charAt(0);
                if (Character.isLowerCase(s) && color < 0 ||
                        Character.isUpperCase(s) && color > 0) {
                    String sl = boardArray[m][n].toLowerCase();
                    for (int k = 0; k < 8; k++)
                        for (int l = 0; l < 8; l++) {
                            if (sl.equals("p") && checkPawn(m, n, l, k, color)){
                                if (n != k)
                                    checkable(l, k);
                                movesArray.add(new Move(m, n, l, k));}
                            if (sl.equals("b") && checkBishop(m, n, l, k, color)){
                                checkable(l, k);
                                movesArray.add(new Move(m, n, l, k));}
                            if (sl.equals("n") && checkKnight(m, n, l, k, color)){
                                checkable(l, k);
                                movesArray.add(new Move(m, n, l, k));}
                            if (sl.equals("r") && checkRook(m, n, l, k, color)){
                                checkable(l, k);
                                movesArray.add(new Move(m, n, l, k));}
                            if (sl.equals("q") && checkQueen(m, n, l, k, color)){
                                checkable(l, k);
                                movesArray.add(new Move(m, n, l, k));}
                            if (sl.equals("k") && checkKing(m, n, l, k, color)){
                                checkable(l, k);
                                movesArray.add(new Move(m, n, l, k));}
                        }
                }
            }
        return movesArray;
    }
}