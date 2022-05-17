package com.example.chesser;
import static java.lang.Math.abs;

import java.util.Arrays;

class Desk {
    String[][] boardArray = TestSurfaceView.twoDimArray;
    
    public boolean eats(int i, int j, int color){
        if (color > 0)
            return (boardArray[i][j].length() == 0) || Character.isLowerCase(boardArray[i][j].charAt(0));
        else
            return (boardArray[i][j].length() == 0) || Character.isUpperCase(boardArray[i][j].charAt(0));
    }

    public boolean eatsEverything(int i, int j){
            return boardArray[i][j].length() != 0;
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
                            if (boardArray[m][n].equals("N") && checkKnight(m, n, k, l, 1))
                                System.out.println(m + " " + n + " -> " + k + " " +l);
        }
        else
            for(int m = 0; m < 8; m++)
                for (int n = 0; n < 8; n++)
                    for (int k = 0; k < 8; k++)
                        for (int l = 0; l < 8; l++)
                            if (boardArray[m][n].equals("n") && checkKnight(m, n, k, l, -1))
                                System.out.println(m + " " + n + " -> " + k + " " +l);
    }

    public boolean checkKnight(int last_i, int last_j, int i, int j, int color){
        int dx = abs(i - last_i);
        int dy = abs(j - last_j);
        return (((dx == 1 && dy == 2) || (dx == 2 && dy == 1)) && eats(i, j, color));
    }

    public boolean checkKing(int last_i, int last_j, int i, int j, int color){
        return (abs(last_i - i) <= 1 && abs(last_j - j) <= 1) && eats(i, j, color);
    }

    public boolean checkBishop(int last_i, int last_j, int i, int j, int color){
        if((abs(i - last_i) == abs(j - last_j)) && eats(i, j, color))
            if(i > last_i)
                if(j > last_j)
                    for (int i5 = 1; i5 < j-last_j; i5++)
                        if (eatsEverything(last_i + i5, last_j + i5))
                            return false;
                else
                    for (int i2 = 1; i2 < last_j - j; i2++)
                        if (eatsEverything(last_i + i5, last_j - i5))
                            return false;
            else
                if(j > last_j)
                    for (int i3 = 1; i3 < j - last_j; i3++)
                        if (eatsEverything(last_i - i5, last_j + i5))
                            return false;
                else
                    for (int i4 = 1; i4 < last_j - j; i4++)
                        if (eatsEverything(last_i - i4, last_j - i4))
                            return false;
            return true;
    }

}
