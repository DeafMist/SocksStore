package com.github.deafmist.socksstore.service;

import com.github.deafmist.socksstore.dto.SocksRequest;
import com.github.deafmist.socksstore.model.Color;
import com.github.deafmist.socksstore.model.Socks;

public interface SocksService {
    Socks add(SocksRequest socksRequest);

    Socks update(SocksRequest socksRequest);

    int get(Color color, int size, int cottonMin, int cottonMax);
}
