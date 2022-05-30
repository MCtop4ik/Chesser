package com.example.chesser;

public class Move {
    Square from;
    Square to;

    public Move(Square from, Square to) {
        this.from = from;
        this.to = to;
    }

    public Move(int from_i, int from_j, int i, int j) {
        this.from = new Square(from_i, from_j);
        this.to = new Square(i, j);
    }

    @Override
    public String toString() {
        return "Move{" +
                "(" + from.i + ", " + from.j + ") -> (" +
                "(" + to.i + ", " + to.j + ")}";
    }
}
