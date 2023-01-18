package com.github.deafmist.socksstore.dto;

import com.github.deafmist.socksstore.model.Color;
import com.github.deafmist.socksstore.model.Socks;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocksRequest {
    private Color color;

    private int size;

    private int cottonPart;

    private int quantity;
}
