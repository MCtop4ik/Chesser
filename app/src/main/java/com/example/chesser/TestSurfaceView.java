package com.example.chesser;

import static java.lang.Math.abs;

import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class TestSurfaceView extends SurfaceView implements SurfaceHolder.Callback, Runnable{
    String colorfully = MainActivity.colorful_palette;
    String colors = MainActivity.colors;
    String switcher = MainActivity.switcher;
    String bg = MainActivity.backgrounds_font;
    int x = -100;
    int y = -100;
    int width_dp = 0;
    int height_dp = 0;
    int test = 0;
    static int next_line = 0;
    static int last_x = 0;
    static int last_y = 0;
    static int last_i = 8;
    static int last_j = 0;
    int queue;
    static int swi = 0;
    static int saved_i;
    static int saved_j;
    static String taken_piece = "";
    static String name = "";
    static String new_name = " ";
    static String wm = "";
    Desk d = new Desk();

    public static String[][] twoDimArray = Desk.boardArray;

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
        switch (colorfully) {
            case "first":
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
                break;
            case "second":
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
                break;
            case "third":
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
                break;
            case "forth":
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
                break;
            case "fifth":
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
                break;
            case "3d":
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
                break;
            default:
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
                break;
        }
        switch (bg) {
            case "1":
                my_bg = BitmapFactory.decodeResource(context.getResources(), R.drawable.bg1);
                break;
            case "2":
                my_bg = BitmapFactory.decodeResource(context.getResources(), R.drawable.bg2);
                break;
            case "3":
                my_bg = BitmapFactory.decodeResource(context.getResources(), R.drawable.bg3);
                break;
            case "4":
                my_bg = BitmapFactory.decodeResource(context.getResources(), R.drawable.bg4);
                break;
            case "5":
                my_bg = BitmapFactory.decodeResource(context.getResources(), R.drawable.bg5);
                break;
            case "6":
                my_bg = BitmapFactory.decodeResource(context.getResources(), R.drawable.bg6);
                break;
            case "8":
                my_bg = BitmapFactory.decodeResource(context.getResources(), R.drawable.bg8);
                break;
            case "7":
                my_bg = BitmapFactory.decodeResource(context.getResources(), R.drawable.bg7);
                break;
            case "9":
                my_bg = BitmapFactory.decodeResource(context.getResources(), R.drawable.bg9);
                break;
            case "10":
                my_bg = BitmapFactory.decodeResource(context.getResources(), R.drawable.bg10);
                break;
            case "11":
                my_bg = BitmapFactory.decodeResource(context.getResources(), R.drawable.bg11);
                break;
            case "12":
                my_bg = BitmapFactory.decodeResource(context.getResources(), R.drawable.bg12);
                break;
            case "13":
                my_bg = BitmapFactory.decodeResource(context.getResources(), R.drawable.bg13);
                break;
            case "14":
                my_bg = BitmapFactory.decodeResource(context.getResources(), R.drawable.bg14);
                break;
            case "15":
                my_bg = BitmapFactory.decodeResource(context.getResources(), R.drawable.bg15);
                break;
            case "16":
                my_bg = BitmapFactory.decodeResource(context.getResources(), R.drawable.bg16);
                break;
            case "17":
                my_bg = BitmapFactory.decodeResource(context.getResources(), R.drawable.bg17);
                break;
            case "18":
                my_bg = BitmapFactory.decodeResource(context.getResources(), R.drawable.bg18);
                break;
            case "19":
                my_bg = BitmapFactory.decodeResource(context.getResources(), R.drawable.bg19);
                break;
            case "20":
                my_bg = BitmapFactory.decodeResource(context.getResources(), R.drawable.bg20);
                break;
            default:
                my_bg = BitmapFactory.decodeResource(context.getResources(), R.drawable.__20160214_2052636593);
                break;
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
        if(MainActivity.game.equals("horde")){
            Desk.boardArray = new String[][]{
                    {"r", "n", "b", "q", "k", "b", "n", "r"},
                    {"p", "p", "p", "p", "p", "p", "p", "p"},
                    {"", "", "", "", "", "", "", ""},
                    {"", "P", "P", "", "", "P", "P", ""},
                    {"P", "P", "P", "P", "P", "P", "P", "P"},
                    {"P", "P", "P", "P", "P", "P", "P", "P"},
                    {"P", "P", "P", "P", "P", "P", "P", "P"},
                    {"P", "P", "P", "P", "P", "P", "P", "P"},
                    {""}};
        }else if(MainActivity.game.equals("normal") && NotationHelper.pgn.equals("")){
            Desk.boardArray = new String[][]{
                    {"r", "n", "b", "q", "k", "b", "n", "r"},
                    {"p", "p", "p", "p", "p", "p", "p", "p"},
                    {"", "", "", "", "", "", "", ""},
                    {"", "", "", "", "", "", "", ""},
                    {"", "", "", "", "", "", "", ""},
                    {"", "", "", "", "", "", "", ""},
                    {"P", "P", "P", "P", "P", "P", "P", "P"},
                    {"R", "N", "B", "Q", "K", "B", "N", "R"},
                    {""}};
            if (switcher.equals("BLACK")) {
                queue = 1;
                swi = 1;
                Desk.boardArray = new String[][]{{"r", "n", "b", "k", "q", "b", "n", "r"}, {"p", "p", "p", "p", "p", "p", "p", "p"}, {"", "", "", "", "", "", "", ""}, {"", "", "", "", "", "", "", ""}, {"", "", "", "", "", "", "", ""}, {"", "", "", "", "", "", "", ""}, {"P", "P", "P", "P", "P", "P", "P", "P"}, {"R", "N", "B", "K", "Q", "B", "N", "R"}, {""}};
            }
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
        queue = Desk.color;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (x > draw_width * (j) && y > square_height + draw_width * (i + 3)
                        && x < draw_width * (j + 1) && y < square_height + draw_width * (i + 4)) {
                    if (last_x == 0 && last_y == 0) {
                        last_y = y;
                        last_x = x;
                        last_i = i;
                        last_j = j;
                    } else {
                        if (last_i != i || last_j != j){
                            saved_i = i;
                            saved_j = j;
                            d.makeMove(last_i, last_j, i, j);
                            last_j = 0;
                            last_i = 8;
                            last_x = 0;
                            last_y = 0;
                            x = -100;
                            y = -100;
                        }
                    }
                }
            }
        }
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
            switch (colors) {
                case "hibiscus":
                    color_sq = getResources().getColor(R.color.hibiscus);
                    break;
                case "thistle":
                    color_sq = getResources().getColor(R.color.thistle);
                    break;
                case "orchid":
                    color_sq = getResources().getColor(R.color.orchid);
                    break;
                case "african":
                    color_sq = getResources().getColor(R.color.african);
                    break;
                case "salmon":
                    color_sq = getResources().getColor(R.color.salmon);
                    break;
                case "raspberry":
                    color_sq = getResources().getColor(R.color.raspberry);
                    break;
                case "cornflower":
                    color_sq = getResources().getColor(R.color.cornflower);
                    break;
                case "turkish":
                    color_sq = getResources().getColor(R.color.flax);
                    break;
                case "lemon":
                    color_sq = getResources().getColor(R.color.lemon);
                    break;
                case "tea":
                    color_sq = getResources().getColor(R.color.tea);
                    break;
                default:
                    color_sq = getResources().getColor(R.color.sea);
                    break;
            }
            Bitmap K = Bitmap.createScaledBitmap(bit_k, draw_width, draw_height, false);
            Bitmap P = Bitmap.createScaledBitmap(bit_p, draw_width, draw_height, false);
            Bitmap N = Bitmap.createScaledBitmap(bit_n, draw_width, draw_height, false);
            Bitmap B = Bitmap.createScaledBitmap(bit_b, draw_width, draw_height, false);
            Bitmap R = Bitmap.createScaledBitmap(bit_r, draw_width, draw_height, false);
            Bitmap Q = Bitmap.createScaledBitmap(bit_q, draw_width, draw_height, false);
            Bitmap k = Bitmap.createScaledBitmap(bit_kb, draw_width, draw_height, false);
            Bitmap p = Bitmap.createScaledBitmap(bit_pb, draw_width, draw_height, false);
            Bitmap n = Bitmap.createScaledBitmap(bit_nb, draw_width, draw_height, false);
            Bitmap b = Bitmap.createScaledBitmap(bit_bb, draw_width, draw_height, false);
            Bitmap r = Bitmap.createScaledBitmap(bit_rb, draw_width, draw_height, false);
            Bitmap q = Bitmap.createScaledBitmap(bit_qb, draw_width, draw_height, false);
            if (switcher.equals("BLACK") && MainActivity.game.equals("normal")){
                K = Bitmap.createScaledBitmap(bit_kb, draw_width, draw_height, false);
                P = Bitmap.createScaledBitmap(bit_pb, draw_width, draw_height, false);
                N = Bitmap.createScaledBitmap(bit_nb, draw_width, draw_height, false);
                B = Bitmap.createScaledBitmap(bit_bb, draw_width, draw_height, false);
                R = Bitmap.createScaledBitmap(bit_rb, draw_width, draw_height, false);
                Q = Bitmap.createScaledBitmap(bit_qb, draw_width, draw_height, false);
                k = Bitmap.createScaledBitmap(bit_k, draw_width, draw_height, false);
                p = Bitmap.createScaledBitmap(bit_p, draw_width, draw_height, false);
                n = Bitmap.createScaledBitmap(bit_n, draw_width, draw_height, false);
                b = Bitmap.createScaledBitmap(bit_b, draw_width, draw_height, false);
                r = Bitmap.createScaledBitmap(bit_r, draw_width, draw_height, false);
                q = Bitmap.createScaledBitmap(bit_q, draw_width, draw_height, false);
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
                            switch (Desk.boardArray[i - 3][j]) {
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
                    new_name = name + ": ";
                    String[] words = new_name.split(":");
                    FontPaint.setColor(ft);
                    int bugFixing = draw_width / 2;
                    canvas.drawText(MainActivity.eco + " " + words[0], 20, bugFixing, FontPaint);
                    FontPaint.setColor(Color.WHITE);
                    wm = ">>>" + words[1];
                    canvas.drawText(wm, 20, bugFixing + 60, FontPaint);
                    canvas.drawCircle(last_x, last_y, 10 , paint_circles);
                    FontPaint.setColor(Color.BLUE);
                    canvas.drawText(NotationHelper.pgn, 20, draw_width * 9 + bugFixing + 60, FontPaint);
                }finally{
                    getHolder().unlockCanvasAndPost(canvas);
                }
            }
        }
    }
}