package com.github.deafmist.socksstore.model;

public enum Color {
    BLACK("black"), WHITE("white"), RED("red"), GREEN("green"), BLUE("blue"), YELLOW("yellow"), PINK("pink"), GRAY("gray");

    private String color;

    Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
