package com.example.chesser;

import java.util.Locale;

public class NotationHelper {

    static int numberOfMove = 1;
    static String pgn = "";
    String take = "";

    public static String getCoordinate(int a, int j){
        int g = 8 - j;
        switch (a) {
            case(0):
                return "a" + g;
            case(1):
                return "b" + g;
            case(2):
                return "c" + g;
            case(3):
                return "d" + g;
            case(4):
                return "e" + g;
            case(5):
                return "f" + g;
            case(6):
                return "g" + g;
            case(7):
                return "h" + g;

            default:
                return "";
        }

    }


    public String getLetter(int a){
        switch (a) {
            case(0):
                return "a";
            case(1):
                return "b";
            case(2):
                return "c";
            case(3):
                return "d";
            case(4):
                return "e";
            case(5):
                return "f";
            case(6):
                return "g";
            case(7):
                return "h";
            default:
                return "";
        }

    }

    public void makeNotationPawn(int j, int i, int last_j, int color){
        take = "";
        if (!Desk.latestPiece.equals(""))take = "x";
        if (take.equals("x")){
            if (color == -1){
                pgn += getLetter(last_j) + "x" + getCoordinate(j, i) + " ";
                numberOfMove += 1;
            }else{
                pgn += numberOfMove + ". " + getLetter(last_j) + "x" + getCoordinate(j, i) + " ";
            }
        }else{
            if (color == -1){
                pgn += getCoordinate(j, i) + " ";
                numberOfMove += 1;
            }else{
                pgn += numberOfMove + ". " + getCoordinate(j, i) + " ";
            }
        }
    }

    /*иди ты нахрен продажная журналюшка со своими провокационными вопросами*/
    public void makeNotation(int j, int i, String letter){
        take = "";
        if (!Desk.latestPiece.equals(""))take = "x";
        if (Character.isLowerCase(letter.charAt(0))){
            pgn += letter.toUpperCase(Locale.ROOT) + take + getCoordinate(j, i) + " ";
            numberOfMove += 1;
        }else{
            pgn += numberOfMove + ". " + letter + take + getCoordinate(j, i) + " ";
        }
    }
}
