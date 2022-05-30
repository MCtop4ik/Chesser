package com.example.chesser;

public class Square {
    int i;
    int j;

    public Square(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public String toString() {
        return "Square{" +
                "i=" + i +
                ", j=" + j +
                '}';
    }
}
