package com.example.chesser;

import static java.lang.Math.abs;

import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.content.Context;

public class TestSurfaceView extends SurfaceView implements SurfaceHolder.Callback, Runnable{
    String colorfully = MainActivity.colorful_palette;
    String colors = MainActivity.colors;
    String switcher = MainActivity.switcher;
    String bg = MainActivity.backgrounds_font;
    static String pgn = "1. c4 ";
    static int count = 1;
    int x = -100;
    int y = -100;
    int width_dp = 0;
    int height_dp = 0;
    int test = 0;
    int next_line = 0;
    int last_x = 0;
    int last_y = 0;
    int last_i = 8;
    int last_j = 0;
    int queue = 0;
    int swi = 0;
    String taken_piece = "";
    boolean rightToCastleShortWhite = true;
    boolean rightToCastleShortBlack = true;
    boolean rightToCastleLongWhite = true;
    boolean rightToCastleLongBlack = true;
    String name = "";
    String new_name = "";

    String[][] twoDimArray = {
            {"r", "n", "b", "q", "k", "b", "n", "r"},
            {"p", "p", "p", "p", "p", "p", "p", "p"},
            {"", "", "", "", "", "", "", ""},
            {"", "", "", "", "", "", "", ""},
            {"", "", "", "", "", "", "", ""},
            {"", "", "", "", "", "", "", ""},
            {"P", "P", "P", "P", "P", "P", "P", "P"},
            {"R", "N", "B", "Q", "K", "B", "N", "R"},
            {""}};

    private final Bitmap bit_k;
    private final Bitmap bit_p;
    private final Bitmap bit_n;
    private final Bitmap bit_b;
    private final Bitmap bit_r;
    private final Bitmap bit_q;
    private final Bitmap my_bg;
    private final Bitmap bit_kb;
    private final Bitmap bit_pb;
    private final Bitmap bit_nb;
    private final Bitmap bit_bb;
    private final Bitmap bit_rb;
    private final Bitmap bit_qb;

    public TestSurfaceView(Context context) {
        super(context);
        getHolder().addCallback(this);
        if (colorfully.equals("first")){
            bit_k = BitmapFactory.decodeResource(context.getResources(), R.drawable.whiteking);
            bit_p = BitmapFactory.decodeResource(context.getResources(), R.drawable.pawnwhite);
            bit_n = BitmapFactory.decodeResource(context.getResources(), R.drawable.knightwhite);
            bit_b = BitmapFactory.decodeResource(context.getResources(), R.drawable.bishopwhite);
            bit_r = BitmapFactory.decodeResource(context.getResources(), R.drawable.rookwhite);
            bit_q = BitmapFactory.decodeResource(context.getResources(), R.drawable.queenwhite);
            bit_kb = BitmapFactory.decodeResource(context.getResources(), R.drawable.kingblack);
            bit_pb = BitmapFactory.decodeResource(context.getResources(), R.drawable.pawnblack);
            bit_nb = BitmapFactory.decodeResource(context.getResources(), R.drawable.knightblack);
            bit_bb = BitmapFactory.decodeResource(context.getResources(), R.drawable.bishopblack);
            bit_rb = BitmapFactory.decodeResource(context.getResources(), R.drawable.rookblack);
            bit_qb = BitmapFactory.decodeResource(context.getResources(), R.drawable.queenblack);
        }else if(colorfully.equals("second")){
            bit_k = BitmapFactory.decodeResource(context.getResources(), R.drawable.wk1);
            bit_p = BitmapFactory.decodeResource(context.getResources(), R.drawable.wp1);
            bit_n = BitmapFactory.decodeResource(context.getResources(), R.drawable.wn1);
            bit_b = BitmapFactory.decodeResource(context.getResources(), R.drawable.wb1);
            bit_r = BitmapFactory.decodeResource(context.getResources(), R.drawable.wr1);
            bit_q = BitmapFactory.decodeResource(context.getResources(), R.drawable.wq1);
            bit_kb = BitmapFactory.decodeResource(context.getResources(), R.drawable.bk1);
            bit_pb = BitmapFactory.decodeResource(context.getResources(), R.drawable.bp1);
            bit_nb = BitmapFactory.decodeResource(context.getResources(), R.drawable.bn1);
            bit_bb = BitmapFactory.decodeResource(context.getResources(), R.drawable.bb1);
            bit_rb = BitmapFactory.decodeResource(context.getResources(), R.drawable.br1);
            bit_qb = BitmapFactory.decodeResource(context.getResources(), R.drawable.bq1);
        }else if(colorfully.equals("third")){
            bit_k = BitmapFactory.decodeResource(context.getResources(), R.drawable.wk2);
            bit_p = BitmapFactory.decodeResource(context.getResources(), R.drawable.wp2);
            bit_n = BitmapFactory.decodeResource(context.getResources(), R.drawable.wn2);
            bit_b = BitmapFactory.decodeResource(context.getResources(), R.drawable.wb2);
            bit_r = BitmapFactory.decodeResource(context.getResources(), R.drawable.wr2);
            bit_q = BitmapFactory.decodeResource(context.getResources(), R.drawable.wq2);
            bit_kb = BitmapFactory.decodeResource(context.getResources(), R.drawable.bk2);
            bit_pb = BitmapFactory.decodeResource(context.getResources(), R.drawable.bp2);
            bit_nb = BitmapFactory.decodeResource(context.getResources(), R.drawable.bn2);
            bit_bb = BitmapFactory.decodeResource(context.getResources(), R.drawable.bb2);
            bit_rb = BitmapFactory.decodeResource(context.getResources(), R.drawable.br2);
            bit_qb = BitmapFactory.decodeResource(context.getResources(), R.drawable.bq2);
        }else if(colorfully.equals("forth")){
            bit_k = BitmapFactory.decodeResource(context.getResources(), R.drawable.wk);
            bit_p = BitmapFactory.decodeResource(context.getResources(), R.drawable.wp);
            bit_n = BitmapFactory.decodeResource(context.getResources(), R.drawable.wn);
            bit_b = BitmapFactory.decodeResource(context.getResources(), R.drawable.wb);
            bit_r = BitmapFactory.decodeResource(context.getResources(), R.drawable.wr);
            bit_q = BitmapFactory.decodeResource(context.getResources(), R.drawable.wq);
            bit_kb = BitmapFactory.decodeResource(context.getResources(), R.drawable.bk);
            bit_pb = BitmapFactory.decodeResource(context.getResources(), R.drawable.bp);
            bit_nb = BitmapFactory.decodeResource(context.getResources(), R.drawable.bn);
            bit_bb = BitmapFactory.decodeResource(context.getResources(), R.drawable.bb);
            bit_rb = BitmapFactory.decodeResource(context.getResources(), R.drawable.br);
            bit_qb = BitmapFactory.decodeResource(context.getResources(), R.drawable.bq);
        }else if(colorfully.equals("fifth")){
            bit_k = BitmapFactory.decodeResource(context.getResources(), R.drawable.wk14);
            bit_p = BitmapFactory.decodeResource(context.getResources(), R.drawable.wp14);
            bit_n = BitmapFactory.decodeResource(context.getResources(), R.drawable.wn14);
            bit_b = BitmapFactory.decodeResource(context.getResources(), R.drawable.wb14);
            bit_r = BitmapFactory.decodeResource(context.getResources(), R.drawable.wr14);
            bit_q = BitmapFactory.decodeResource(context.getResources(), R.drawable.wq14);
            bit_kb = BitmapFactory.decodeResource(context.getResources(), R.drawable.bk14);
            bit_pb = BitmapFactory.decodeResource(context.getResources(), R.drawable.bp14);
            bit_nb = BitmapFactory.decodeResource(context.getResources(), R.drawable.bn14);
            bit_bb = BitmapFactory.decodeResource(context.getResources(), R.drawable.bb14);
            bit_rb = BitmapFactory.decodeResource(context.getResources(), R.drawable.br14);
            bit_qb = BitmapFactory.decodeResource(context.getResources(), R.drawable.bq14);
        }else if (colorfully.equals("3d")) {
            bit_k = BitmapFactory.decodeResource(context.getResources(), R.drawable.dwk);
            bit_p = BitmapFactory.decodeResource(context.getResources(), R.drawable.dwp);
            bit_n = BitmapFactory.decodeResource(context.getResources(), R.drawable.dwn);
            bit_b = BitmapFactory.decodeResource(context.getResources(), R.drawable.dwb);
            bit_r = BitmapFactory.decodeResource(context.getResources(), R.drawable.dwr);
            bit_q = BitmapFactory.decodeResource(context.getResources(), R.drawable.dwq);
            bit_kb = BitmapFactory.decodeResource(context.getResources(), R.drawable.dbk);
            bit_pb = BitmapFactory.decodeResource(context.getResources(), R.drawable.dbp);
            bit_nb = BitmapFactory.decodeResource(context.getResources(), R.drawable.dbnf);
            bit_bb = BitmapFactory.decodeResource(context.getResources(), R.drawable.dbb);
            bit_rb = BitmapFactory.decodeResource(context.getResources(), R.drawable.dbr);
            bit_qb = BitmapFactory.decodeResource(context.getResources(), R.drawable.dbq);
        }else{
                bit_k = BitmapFactory.decodeResource(context.getResources(), R.drawable.wk3);
                bit_p = BitmapFactory.decodeResource(context.getResources(), R.drawable.wp3);
                bit_n = BitmapFactory.decodeResource(context.getResources(), R.drawable.wn3);
                bit_b = BitmapFactory.decodeResource(context.getResources(), R.drawable.wb3);
                bit_r = BitmapFactory.decodeResource(context.getResources(), R.drawable.wr3);
                bit_q = BitmapFactory.decodeResource(context.getResources(), R.drawable.wq3);
                bit_kb = BitmapFactory.decodeResource(context.getResources(), R.drawable.bk3);
                bit_pb = BitmapFactory.decodeResource(context.getResources(), R.drawable.bp3);
                bit_nb = BitmapFactory.decodeResource(context.getResources(), R.drawable.bn3);
                bit_bb = BitmapFactory.decodeResource(context.getResources(), R.drawable.bb3);
                bit_rb = BitmapFactory.decodeResource(context.getResources(), R.drawable.br3);
                bit_qb = BitmapFactory.decodeResource(context.getResources(), R.drawable.bq3);
            }
        if (bg.equals("1")){
            my_bg = BitmapFactory.decodeResource(context.getResources(), R.drawable.bg1);
        }else if(bg.equals("2")) {
            my_bg = BitmapFactory.decodeResource(context.getResources(), R.drawable.bg2);
        }else if(bg.equals("3")) {
            my_bg = BitmapFactory.decodeResource(context.getResources(), R.drawable.bg3);
        }else if(bg.equals("4")) {
            my_bg = BitmapFactory.decodeResource(context.getResources(), R.drawable.bg4);
        }else if(bg.equals("5")) {
            my_bg = BitmapFactory.decodeResource(context.getResources(), R.drawable.bg5);
        }else if(bg.equals("6")) {
            my_bg = BitmapFactory.decodeResource(context.getResources(), R.drawable.bg6);
        }else if(bg.equals("8")) {
            my_bg = BitmapFactory.decodeResource(context.getResources(), R.drawable.bg8);
        }else if(bg.equals("7")) {
            my_bg = BitmapFactory.decodeResource(context.getResources(), R.drawable.bg7);
        }else if(bg.equals("9")) {
            my_bg = BitmapFactory.decodeResource(context.getResources(), R.drawable.bg9);
        }else if(bg.equals("10")) {
            my_bg = BitmapFactory.decodeResource(context.getResources(), R.drawable.bg10);
        }else if(bg.equals("11")) {
            my_bg = BitmapFactory.decodeResource(context.getResources(), R.drawable.bg11);
        }else if(bg.equals("12")) {
            my_bg = BitmapFactory.decodeResource(context.getResources(), R.drawable.bg12);
        }else if(bg.equals("13")) {
            my_bg = BitmapFactory.decodeResource(context.getResources(), R.drawable.bg13);
        }else if(bg.equals("14")) {
            my_bg = BitmapFactory.decodeResource(context.getResources(), R.drawable.bg14);
        }else if(bg.equals("15")) {
            my_bg = BitmapFactory.decodeResource(context.getResources(), R.drawable.bg15);
        }else if(bg.equals("16")) {
            my_bg = BitmapFactory.decodeResource(context.getResources(), R.drawable.bg16);
        }else if(bg.equals("17")) {
            my_bg = BitmapFactory.decodeResource(context.getResources(), R.drawable.bg17);
        }else if(bg.equals("18")) {
            my_bg = BitmapFactory.decodeResource(context.getResources(), R.drawable.bg18);
        }else if(bg.equals("19")) {
            my_bg = BitmapFactory.decodeResource(context.getResources(), R.drawable.bg19);
        }else if(bg.equals("20")) {
            my_bg = BitmapFactory.decodeResource(context.getResources(), R.drawable.bg20);
        }else{
            my_bg = BitmapFactory.decodeResource(context.getResources(), R.drawable.__20160214_2052636593);
        }

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){
        height_dp = height;
        width_dp = width;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        new Thread(this).start();
        if (switcher.equals("BLACK")) {
            queue = 1;
            swi = 1;
            twoDimArray = new String[][]{{"r", "n", "b", "k", "q", "b", "n", "r"}, {"p", "p", "p", "p", "p", "p", "p", "p"}, {"", "", "", "", "", "", "", ""}, {"", "", "", "", "", "", "", ""}, {"", "", "", "", "", "", "", ""}, {"", "", "", "", "", "", "", ""}, {"P", "P", "P", "P", "P", "P", "P", "P"}, {"R", "N", "B", "K", "Q", "B", "N", "R"}, {""}};
            }
        }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder){
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        x = (int)event.getX();
        y = (int)event.getY();
        return false;
    }
    public void movePiece() {
        int square_height = (height_dp) / 40 - 150;
        int draw_width = width_dp / 8;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (x > draw_width * (j) && y > square_height + draw_width * (i + 3)
                        && x < draw_width * (j + 1) && y < square_height + draw_width * (i + 4)) {
                    if (last_x == 0 && last_y == 0) {
                        last_y = y;
                        last_x = x;
                        last_i = i;
                        last_j = j;
                        taken_piece = twoDimArray[i][j];
                    } else {
                        if (last_i != i || last_j != j){
                            if (taken_piece.equals("P") && checkWhitePawn(i, j) && queue == 0) {
                                twoDimArray[i][j] = taken_piece;
                                twoDimArray[last_i][last_j] = "";
                                queue = 1;
                            }
                            if (taken_piece.equals("p") && checkBlackPawn(i, j) && queue == 1){
                                twoDimArray[i][j] = taken_piece;
                                twoDimArray[last_i][last_j] = "";
                                queue = 0;
                            }
                            if (taken_piece.equals("N") && checkWhiteKnight(i, j) && queue == 0){
                                twoDimArray[i][j] = taken_piece;
                                twoDimArray[last_i][last_j] = "";
                                queue = 1;
                            }
                            if (taken_piece.equals("n") && checkBlackKnight(i, j) && queue == 1){
                                twoDimArray[i][j] = taken_piece;
                                twoDimArray[last_i][last_j] = "";
                                queue = 0;
                            }
                            if (taken_piece.equals("B") && checkWhiteBishop(i, j) && queue == 0){
                                twoDimArray[i][j] = taken_piece;
                                twoDimArray[last_i][last_j] = "";
                                queue = 1;
                            }
                            if (taken_piece.equals("b") && checkBlackBishop(i, j) && queue == 1){
                                twoDimArray[i][j] = taken_piece;
                                twoDimArray[last_i][last_j] = "";
                                queue = 0;
                            }
                            if (taken_piece.equals("R") && checkWhiteRook(i, j) && queue == 0){
                                twoDimArray[i][j] = taken_piece;
                                twoDimArray[last_i][last_j] = "";
                                queue = 1;
                            }
                            if (taken_piece.equals("r") && checkBlackRook(i, j) && queue == 1){
                                twoDimArray[i][j] = taken_piece;
                                twoDimArray[last_i][last_j] = "";
                                queue = 0;
                            }
                            if (taken_piece.equals("Q") && checkWhiteQueen(i, j) && queue == 0){
                                twoDimArray[i][j] = taken_piece;
                                twoDimArray[last_i][last_j] = "";
                                queue = 1;
                            }
                            if (taken_piece.equals("q") && checkBlackQueen(i, j) && queue == 1){
                                twoDimArray[i][j] = taken_piece;
                                twoDimArray[last_i][last_j] = "";
                                queue = 0;
                            }
                            if (taken_piece.equals("K") && checkWhiteKing(i, j) && queue == 0){
                                twoDimArray[i][j] = taken_piece;
                                twoDimArray[last_i][last_j] = "";
                                rightToCastleShortWhite = false;
                                rightToCastleLongWhite = false;
                                queue = 1;
                            }
                            if (taken_piece.equals("k") && checkBlackKing(i, j) && queue == 1){
                                twoDimArray[i][j] = taken_piece;
                                twoDimArray[last_i][last_j] = "";
                                rightToCastleShortBlack = false;
                                rightToCastleLongBlack = false;
                                queue = 0;
                            }
                            if (taken_piece.equals("K") && last_i == 7 && queue == 0
                                    && last_j == 4 && i == 7 && j == 6 && twoDimArray[7][5].equals("")
                            && twoDimArray[7][6].equals("") && twoDimArray[7][7].equals("R")
                                    && rightToCastleShortWhite){
                                castleWhiteShort();
                                queue = 1;
                            }
                            if (taken_piece.equals("K") && last_i == 7 && queue == 0
                                    && last_j == 4 && i == 7 && j == 2 && twoDimArray[7][3].equals("")
                                    && twoDimArray[7][2].equals("") && twoDimArray[7][0].equals("R")
                                    && rightToCastleLongWhite && twoDimArray[7][1].equals("")){
                                castleWhiteLong();
                                queue = 1;
                            }
                            if (taken_piece.equals("k") && last_i == 0 && queue == 1
                                    && last_j == 4 && i == 0 && j == 6 && twoDimArray[0][5].equals("")
                                    && twoDimArray[0][6].equals("") && twoDimArray[0][7].equals("r")
                                    && rightToCastleShortBlack){
                                castleBlackShort();
                                queue = 0;
                            }
                            if (taken_piece.equals("k") && last_i == 0 && queue == 1
                                    && last_j == 4 && i == 0 && j == 2 && twoDimArray[0][3].equals("")
                                    && twoDimArray[0][2].equals("") && twoDimArray[0][0].equals("r")
                                    && rightToCastleLongBlack && twoDimArray[0][1].equals("")){
                                castleBlackLong();
                                queue = 0;
                            }
                            if (taken_piece.equals("K") && last_i == 7 && queue == 0
                                    && last_j == 3 && i == 7 && j == 1 && twoDimArray[7][2].equals("")
                                    && twoDimArray[7][1].equals("") && twoDimArray[7][0].equals("R")
                                    && twoDimArray[7][3].equals("K")
                                    && rightToCastleShortWhite  && swi == 1){
                                castleSwitchWhiteShort();
                                queue = 1;}
                            if (taken_piece.equals("K") && last_i == 7 && queue == 0
                                    && last_j == 3 && i == 7 && j == 5 && twoDimArray[7][5].equals("")
                                    && twoDimArray[7][6].equals("") && twoDimArray[7][7].equals("R")
                                    && twoDimArray[7][3].equals("K") && twoDimArray[7][4].equals("")
                                    && rightToCastleShortWhite && swi == 1){
                                castleSwitchWhiteLong();
                                queue = 1;}
                            if (taken_piece.equals("k") && last_i == 0 && queue == 1
                                    && last_j == 3 && i == 0 && j == 1 && twoDimArray[0][2].equals("")
                                    && twoDimArray[0][1].equals("") && twoDimArray[0][0].equals("r")
                                    && twoDimArray[0][3].equals("k")
                                    && rightToCastleShortBlack && swi == 1){
                                castleSwitchBlackShort();
                                queue = 0;
                            }
                            if (taken_piece.equals("k") && last_i == 0 && queue == 1
                                    && last_j == 3 && i == 0 && j == 5 && twoDimArray[0][5].equals("")
                                    && twoDimArray[0][6].equals("") && twoDimArray[0][7].equals("r")
                                    && twoDimArray[0][3].equals("k") && twoDimArray[0][4].equals("")
                                    && swi == 1){
                                castleSwitchBlackLong();
                                queue = 0;
                            }
                            last_j = 0;
                            last_i = 8;
                            last_x = 0;
                            last_y = 0;
                            x = -100;
                            y = -100;
                            System.out.println(pgn);
                        }
                    }
                }
            }
        }
    }

    public String getCoordinate(int a, int j){
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
        System.out.println(a);
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

    public boolean checkWhitePawn(int i, int j){
        if (last_i == i+2 && last_i == 6 && twoDimArray[i][last_j].equals("") && last_j == j){
            pgn += count + ". " + getCoordinate(j, i) + " ";
            count += 1;
            return true;
        }else if (last_i == i+1 && twoDimArray[i][last_j].equals("") && last_j==j){
            pgn += count + ". " + getCoordinate(j, i) + " ";
            count += 1;
            return true;
        }else if (last_i == i+1 && (j == last_j+1 || j == last_j-1)
                && (twoDimArray[i][j].equals("p") ||
                twoDimArray[i][j].equals("n") ||
                twoDimArray[i][j].equals("b") ||
                twoDimArray[i][j].equals("r") ||
                twoDimArray[i][j].equals("q") ||
                twoDimArray[i][j].equals("k"))){
                pgn += count + ". " + getLetter(last_j) + "x" + getCoordinate(j, i) + " ";
                count += 1;
            return true;
        }
        else{
                return false;
            }
        }

    public boolean checkBlackPawn(int i, int j){
        if (last_i == i-2 && last_i == 1 && twoDimArray[i][last_j].equals("") && last_j == j){
            pgn += getCoordinate(j, i) + " ";
            return true;
        }else if (last_i == i-1 && twoDimArray[i][last_j].equals("") && last_j==j){
            pgn += getCoordinate(j, i) + " ";
            return true;
        }else if (last_i == i-1 && (j == last_j+1 || j == last_j-1)
                && (twoDimArray[i][j].equals("P") ||
                twoDimArray[i][j].equals("N") ||
                twoDimArray[i][j].equals("B") ||
                twoDimArray[i][j].equals("R") ||
                twoDimArray[i][j].equals("Q") ||
                twoDimArray[i][j].equals("K"))){
            pgn += getLetter(last_j) + "x" + getCoordinate(j, i) + " ";
            return true;
        }
        else{
            return false;
        }
    }

    public boolean checkWhiteKnight(int i, int j){
        int dx = abs(i - last_i);
        int dy = abs(j - last_j);
        if(((dx == 1 && dy == 2) || (dx == 2 && dy == 1)) && whiteEats(i, j)){
            return true;
        }else{
            return false;
        }
    }

    public boolean checkBlackKnight(int i, int j){
        int dx = abs(i - last_i);
        int dy = abs(j - last_j);
        if(((dx == 1 && dy == 2) || (dx == 2 && dy == 1)) && blackEats(i, j)){
            return true;
        }else{
            return false;
        }
    }

    public boolean checkWhiteBishop(int i, int j){
        if((abs(i - last_i) == abs(j - last_j)) && whiteEats(i, j)){
            return true;
        }else{
            return false;
        }
    }

    public boolean checkBlackBishop(int i, int j){
        if((abs(i - last_i) == abs(j - last_j)) && blackEats(i, j)){
            return true;
        }else{
            return false;
        }
    }

    public boolean checkWhiteRook(int i, int j){
        if(((i == last_i) || (j == last_j)) && whiteEats(i, j)){
            if (last_i == 7 && last_j == 0){
                rightToCastleLongWhite = false;
            }
            if (last_i == 7 && last_j == 7){
                rightToCastleShortWhite = false;
            }
            return true;

        }else{
            return false;
        }
    }

    public boolean checkBlackRook(int i, int j){
        if(((i == last_i) || (j == last_j)) && blackEats(i, j)){
            if (last_i == 0 && last_j == 0){
                rightToCastleLongBlack = false;
            }
            if (last_i == 0 && last_j == 7){
                rightToCastleShortBlack = false;
            }
            return true;
        }else{
            return false;
        }
    }

    public boolean checkWhiteQueen(int i, int j){
        if(((abs(i - last_i) == abs(j - last_j)) || ((i == last_i) || (j == last_j))) && whiteEats(i, j)){
            return true;
        }else{
            return false;
        }
    }

    public boolean checkBlackQueen(int i, int j){
        if(((abs(i - last_i) == abs(j - last_j)) || ((i == last_i) || (j == last_j))) && blackEats(i, j)){
            return true;
        }else{
            return false;
        }
    }
    public boolean checkWhiteKing(int i, int j){
        if((abs(last_i - i) <= 1 && abs(last_j - j) <= 1) && whiteEats(i, j)){
            return true;
        }else{
            return false;
        }
    }

    public boolean checkBlackKing(int i, int j){
        if((abs(last_i - i) <= 1 && abs(last_j - j) <= 1) && blackEats(i, j)){
            return true;
        }else{
            return false;
        }
    }

    public boolean whiteEats(int i, int j){
        if (twoDimArray[i][j].equals("p") ||
                twoDimArray[i][j].equals("n") ||
                twoDimArray[i][j].equals("b") ||
                twoDimArray[i][j].equals("r") ||
                twoDimArray[i][j].equals("q") ||
                twoDimArray[i][j].equals("k") ||
                twoDimArray[i][j].equals("")){
            return true;
        }else{
            return false;
        }
    }

    public boolean blackEats(int i, int j){
        if((twoDimArray[i][j].equals("P") ||
                        twoDimArray[i][j].equals("N") ||
                        twoDimArray[i][j].equals("B") ||
                        twoDimArray[i][j].equals("R") ||
                        twoDimArray[i][j].equals("Q") ||
                        twoDimArray[i][j].equals("K") ||
                        twoDimArray[i][j].equals(""))){
            return true;
        }else{
            return false;
        }
    }

    public void castleWhiteShort(){
        twoDimArray[7][6] = "K";
        twoDimArray[7][4] = "";
        twoDimArray[7][5] = "R";
        twoDimArray[7][7] = "";
        rightToCastleShortWhite = false;
    }
    public void castleWhiteLong(){
        twoDimArray[7][2] = "K";
        twoDimArray[7][4] = "";
        twoDimArray[7][3] = "R";
        twoDimArray[7][0] = "";
        rightToCastleLongWhite = false;
    }
    public void castleBlackShort(){
        twoDimArray[0][6] = "k";
        twoDimArray[0][4] = "";
        twoDimArray[0][5] = "r";
        twoDimArray[0][7] = "";
        rightToCastleShortBlack = false;
    }
    public void castleBlackLong(){
        twoDimArray[0][2] = "k";
        twoDimArray[0][4] = "";
        twoDimArray[0][3] = "r";
        twoDimArray[0][0] = "";
        rightToCastleLongBlack = false;
    }

    public void castleSwitchWhiteShort(){
        twoDimArray[7][1] = "K";
        twoDimArray[7][0] = "";
        twoDimArray[7][2] = "R";
        twoDimArray[7][3] = "";
        rightToCastleShortWhite = false;
    }
    public void castleSwitchWhiteLong(){
        twoDimArray[7][5] = "K";
        twoDimArray[7][3] = "";
        twoDimArray[7][4] = "R";
        twoDimArray[7][7] = "";
        rightToCastleLongWhite = false;
    }
    public void castleSwitchBlackShort(){
        twoDimArray[0][1] = "k";
        twoDimArray[0][0] = "";
        twoDimArray[0][2] = "r";
        twoDimArray[0][3] = "";
        rightToCastleShortBlack = false;
    }
    public void castleSwitchBlackLong(){
        twoDimArray[0][5] = "k";
        twoDimArray[0][3] = "";
        twoDimArray[0][4] = "r";
        twoDimArray[0][7] = "";
        rightToCastleLongBlack = false;
    }

    public void enPassantWhite(){

    }

    public void II(){

    }

    @Override
    public void run(){
        Paint paint = new Paint();
        Paint paint_square = new Paint();
        Paint paint_circles = new Paint();
        Paint FontPaint= new Paint();
        int ft = getResources().getColor(R.color.turkish);
        FontPaint.setColor(ft);
        FontPaint.setTextSize(42);
        FontPaint.setTypeface(Typeface.create("Arial", Typeface.BOLD_ITALIC));
        paint.setColor(Color.RED);
        paint_square.setColor(Color.WHITE);
        while(true){
            Canvas canvas = getHolder().lockCanvas();
            int square_height = (height_dp)/40-150;
            int draw_width = width_dp/8;
            int draw_height = width_dp/8;
            int color_sq;
            if(colors.equals("hibiscus")) {
                color_sq = getResources().getColor(R.color.hibiscus);
            }else if(colors.equals("thistle")) {
                color_sq = getResources().getColor(R.color.thistle);
            }else if(colors.equals("orchid")) {
                color_sq = getResources().getColor(R.color.orchid);
            }else if(colors.equals("african")) {
                color_sq = getResources().getColor(R.color.african);
            }else if(colors.equals("salmon")) {
                color_sq = getResources().getColor(R.color.salmon);
            }else if(colors.equals("raspberry")) {
                color_sq = getResources().getColor(R.color.raspberry);
            }else if(colors.equals("cornflower")) {
                color_sq = getResources().getColor(R.color.cornflower);
            }else if(colors.equals("turkish")) {
                color_sq = getResources().getColor(R.color.flax);
            }else if(colors.equals("lemon")) {
                color_sq = getResources().getColor(R.color.lemon);
            }else if(colors.equals("tea")) {
                color_sq = getResources().getColor(R.color.tea);
            }else {
                color_sq = getResources().getColor(R.color.sea);
            }
            Bitmap K = Bitmap.createScaledBitmap(bit_k,
                    draw_width,
                    draw_height,
                    false);
            Bitmap P = Bitmap.createScaledBitmap(bit_p,
                    draw_width,
                    draw_height,
                    false);
            Bitmap N = Bitmap.createScaledBitmap(bit_n,
                    draw_width,
                    draw_height,
                    false);
            Bitmap B = Bitmap.createScaledBitmap(bit_b,
                    draw_width,
                    draw_height,
                    false);
            Bitmap R = Bitmap.createScaledBitmap(bit_r,
                    draw_width,
                    draw_height,
                    false);
            Bitmap Q = Bitmap.createScaledBitmap(bit_q,
                    draw_width,
                    draw_height,
                    false);
            Bitmap k = Bitmap.createScaledBitmap(bit_kb,
                    draw_width,
                    draw_height,
                    false);
            Bitmap p = Bitmap.createScaledBitmap(bit_pb,
                    draw_width,
                    draw_height,
                    false);
            Bitmap n = Bitmap.createScaledBitmap(bit_nb,
                    draw_width,
                    draw_height,
                    false);
            Bitmap b = Bitmap.createScaledBitmap(bit_bb,
                    draw_width,
                    draw_height,
                    false);
            Bitmap r = Bitmap.createScaledBitmap(bit_rb,
                    draw_width,
                    draw_height,
                    false);
            Bitmap q = Bitmap.createScaledBitmap(bit_qb,
                    draw_width,
                    draw_height,
                    false);
            if (switcher.equals("BLACK")){
                K = Bitmap.createScaledBitmap(bit_kb,
                        draw_width,
                        draw_width,
                        false);
                P = Bitmap.createScaledBitmap(bit_pb,
                        draw_width,
                        draw_width,
                        false);
                N = Bitmap.createScaledBitmap(bit_nb,
                        draw_width,
                        draw_width,
                        false);
                B = Bitmap.createScaledBitmap(bit_bb,
                        draw_width,
                        draw_width,
                        false);
                R = Bitmap.createScaledBitmap(bit_rb,
                        draw_width,
                        draw_width,
                        false);
                Q = Bitmap.createScaledBitmap(bit_qb,
                        draw_width,
                        draw_width,
                        false);
                k = Bitmap.createScaledBitmap(bit_k,
                        draw_width,
                        draw_width,
                        false);
                p = Bitmap.createScaledBitmap(bit_p,
                        draw_width,
                        draw_width,
                        false);
                n = Bitmap.createScaledBitmap(bit_n,
                        draw_width,
                        draw_width,
                        false);
                b = Bitmap.createScaledBitmap(bit_b,
                        draw_width,
                        draw_width,
                        false);
                r = Bitmap.createScaledBitmap(bit_r,
                        draw_width,
                        draw_width,
                        false);
                q = Bitmap.createScaledBitmap(bit_q,
                        draw_width,
                        draw_width,
                        false);
            }

            if (canvas!=null) {
                try {
                    canvas.drawBitmap(my_bg, 0, 0, paint);
                    for (int i = 3; i < 11; i++) {
                        if (next_line == 1) {
                            test = 1;
                            next_line = 0;
                        } else {
                            test = 0;
                            next_line += 1;
                        }
                        for (int j = 0; j < 8; j++) {
                            if (test == 1) {
                                paint_square.setColor(color_sq);
                                test = 0;
                            } else {
                                paint_square.setColor(Color.WHITE);
                                test += 1;
                            }
                            canvas.drawRect(draw_width * (j), square_height + draw_width * i, draw_width * (j + 1), square_height + draw_width * (i + 1), paint_square);
                            switch (twoDimArray[i - 3][j]) {
                                case "K":
                                    canvas.drawBitmap(K, draw_width * (j), (square_height + draw_width * i), paint);
                                    break;
                                case "N":
                                    canvas.drawBitmap(N, draw_width * (j), (square_height + draw_width * i), paint);
                                    break;
                                case "P":
                                    canvas.drawBitmap(P, draw_width * (j), (square_height + draw_width * i), paint);
                                    break;
                                case "B":
                                    canvas.drawBitmap(B, draw_width * (j), (square_height + draw_width * i), paint);
                                    break;
                                case "Q":
                                    canvas.drawBitmap(Q, draw_width * (j), (square_height + draw_width * i), paint);
                                    break;
                                case "R":
                                    canvas.drawBitmap(R, draw_width * (j), (square_height + draw_width * i), paint);
                                    break;
                                case "k":
                                    canvas.drawBitmap(k, draw_width * (j), (square_height + draw_width * i), paint);
                                    break;
                                case "n":
                                    canvas.drawBitmap(n, draw_width * (j), (square_height + draw_width * i), paint);
                                    break;
                                case "p":
                                    canvas.drawBitmap(p, draw_width * (j), (square_height + draw_width * i), paint);
                                    break;
                                case "b":
                                    canvas.drawBitmap(b, draw_width * (j), (square_height + draw_width * i), paint);
                                    break;
                                case "q":
                                    canvas.drawBitmap(q, draw_width * (j), (square_height + draw_width * i), paint);
                                    break;
                                case "r":
                                    canvas.drawBitmap(r, draw_width * (j), (square_height + draw_width * i), paint);
                                    break;
                                default:
                            }
                        }
                    }

                    while (last_x == x || last_y == y){
                        II();
                    }
                    movePiece();
                    if (colorfully.equals("sea") || colorfully.equals("turkish")){
                        paint_circles.setColor(Color.RED);
                    }else if (colorfully.equals("raspberry")){
                        paint_circles.setColor(Color.BLUE);
                    }else{
                        paint_circles.setColor(Color.GREEN);
                    }
                    name = MainActivity.name;
                    for (int i = 0; i < name.length(); i++){
                        new_name = new_name +  name;
                    }
                    canvas.drawText(name, 20, draw_width/2, FontPaint);
                    canvas.drawCircle(last_x, last_y, 10 , paint_circles);
                }finally{
                    getHolder().unlockCanvasAndPost(canvas);
                }
            }
        }
    }
}