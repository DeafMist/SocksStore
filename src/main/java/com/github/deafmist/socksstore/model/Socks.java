package com.github.deafmist.socksstore.model;

import com.github.deafmist.socksstore.exception.IllegalCottonPartException;
import com.github.deafmist.socksstore.exception.IllegalQuantityException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
public class Socks {
    private Color color;

    private Size size;

    private int cottonPart;

    private int quantity;

    public Socks(Color color, int size, int cottonPart, int quantity) {
        this.color = color;
        this.size = Size.convertIntToSize(size);
        this.cottonPart = cottonPart;
        this.quantity = quantity;
    }

    public void setCottonPart(int cottonPart) {
        if (cottonPart < 0 || cottonPart > 100) {
            throw new IllegalCottonPartException("Процентное содержание хлопка в носках не может быть меньше 0 или больше 100");
        }
        this.cottonPart = cottonPart;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalQuantityException("Количество носков на складе не может быть меньше нуля");
        }
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Socks socks = (Socks) o;
        return cottonPart == socks.cottonPart && color == socks.color && size == socks.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, size, cottonPart);
    }
}
