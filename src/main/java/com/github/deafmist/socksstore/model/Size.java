package com.github.deafmist.socksstore.model;

public enum Size {
    S(35, 38), M(39, 42), L(43, 46), XL(47, 49);

    private int from;

    private int to;

    Size(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }
}
