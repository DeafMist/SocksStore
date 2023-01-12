package com.github.deafmist.socksstore.service.impl;

import com.github.deafmist.socksstore.exception.NoSuchSocksCountException;
import com.github.deafmist.socksstore.model.Color;
import com.github.deafmist.socksstore.model.Size;
import com.github.deafmist.socksstore.model.Socks;
import com.github.deafmist.socksstore.service.SocksService;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class SocksServiceImpl implements SocksService {
    private List<Socks> socksList = new LinkedList<>();

    @Override
    public Socks add(Socks socks) {
        int index = socksList.indexOf(socks);
        if (index != -1) {
            int quantity = socksList.get(index).getQuantity() + socks.getQuantity();
            socks.setQuantity(quantity);
            socksList.set(index, socks);
        }
        else {
            socksList.add(socks);
            return socks;
        }

        return socksList.get(index);
    }

    @Override
    public Socks update(Socks socks) {
        int index = socksList.indexOf(socks);
        if (index != -1) {
            int quantity = socksList.get(index).getQuantity() - socks.getQuantity();
            if (quantity > 0) {
                socks.setQuantity(quantity);
                socksList.set(index, socks);
            }
            else if (quantity == 0) {
                socks.setQuantity(quantity);
                socksList.remove(index);
                return socks;
            }
            else {
                throw new NoSuchSocksCountException("К отпуску востребовано больше носков, чем имеется на складе");
            }
        }
        else {
            throw new NoSuchSocksCountException("К отпуску востребованы носки, которых нет на складе");
        }

        return socksList.get(index);
    }

    @Override
    public int get(Color color, Size size, int cottonMin, int cottonMax) {
        int total = 0;
        for (Socks socks : socksList) {
            if (socks.getColor().equals(color) && socks.getSize().equals(size) &&
                    socks.getCottonPart() >= cottonMin && socks.getCottonPart() <= cottonMax) {
                total += socks.getQuantity();
            }
        }
        return total;
    }
}
