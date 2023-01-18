package com.github.deafmist.socksstore.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.deafmist.socksstore.exception.IllegalSizeException;

public enum Size {
    S(35, 38), M(39, 42), L(43, 46), XL(47, 49);

    private int from;

    private int to;

    Size(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public static Size convertIntToSize(@JsonProperty("size") int size){
        for (Size value : Size.values()) {
            if (value.from <= size && size <= value.to){
                return value;
            }
        }
        throw new IllegalSizeException("Такого размера носков не существует");
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }
}
