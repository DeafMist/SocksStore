package com.github.deafmist.socksstore.service;

import com.github.deafmist.socksstore.model.Color;
import com.github.deafmist.socksstore.model.Size;
import com.github.deafmist.socksstore.model.Socks;

public interface SocksService {
    Socks add(Socks socks);

    Socks update(Socks socks);

    int get(Color color, Size size, int cottonMin, int cottonMax);
}
