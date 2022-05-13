package com.example.chesser;
import static java.lang.Math.abs;

class Desk {
    static String[][] twoDimArray = {
            {"r", "n", "b", "q", "k", "b", "n", "r"},
            {"p", "p", "p", "p", "p", "p", "p", "p"},
            {"", "", "", "", "", "", "", ""},
            {"", "", "", "", "", "", "", ""},
            {"", "", "", "", "", "", "", ""},
            {"", "", "", "", "", "", "", ""},
            {"P", "P", "P", "P", "P", "P", "P", "P"},
            {"R", "N", "B", "Q", "K", "B", "N", "R"},
            {""}};

    public boolean eats(int i, int j, int color){
        if (color > 0)
            return (twoDimArray[i][j].length() == 0) || Character.isLowerCase(twoDimArray[i][j].charAt(0));
        else
            return (twoDimArray[i][j].length() == 0) || Character.isUpperCase(twoDimArray[i][j].charAt(0));
    }
    //
//    public boolean isCheck(){
//        return true
//    }
//
    public void correctMoves(int color) {
        if(color > 0){
            for(int m = 0; m < 8; m++)
                for (int n = 0; n < 8; n++)
                    for (int k = 0; k < 8; k++)
                        for (int l = 0; l < 8; l++)
                            if (twoDimArray[m][n].equals("N") && checkKnight(m, n, k, l, 1))
                                System.out.println(m + " " + n + " -> " + k + " " +l);
        }
        else
            for(int m = 0; m < 8; m++)
                for (int n = 0; n < 8; n++)
                    for (int k = 0; k < 8; k++)
                        for (int l = 0; l < 8; l++)
                            if (twoDimArray[m][n].equals("n") && checkKnight(m, n, k, l, -1))
                                System.out.println(m + " " + n + " -> " + k + " " +l);



    }
    public boolean checkKnight(int last_i, int last_j, int i, int j, int color){
        int dx = abs(i - last_i);
        int dy = abs(j - last_j);
        return (((dx == 1 && dy == 2) || (dx == 2 && dy == 1)) && eats(i, j, color));
    }

}
