package com.github.deafmist.socksstore.controller;

import com.github.deafmist.socksstore.dto.SocksRequest;
import com.github.deafmist.socksstore.model.Color;
import com.github.deafmist.socksstore.model.Size;
import com.github.deafmist.socksstore.model.Socks;
import com.github.deafmist.socksstore.service.SocksService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/socks")
public class SocksController {
    private SocksService socksService;

    public SocksController(SocksService socksService) {
        this.socksService = socksService;
    }

    @PostMapping
    public ResponseEntity<Socks> addSocks(@RequestBody SocksRequest socksRequest) {
        return ResponseEntity.ok(socksService.add(socksRequest));
    }

    @PutMapping
    public ResponseEntity<Socks> updateSocks(@RequestBody SocksRequest socksRequest) {
        return ResponseEntity.ok(socksService.update(socksRequest));
    }

    @GetMapping
    public ResponseEntity<Integer> getSocks(@RequestParam Color color,
                                   @RequestParam int size,
                                   @RequestParam(required = false, defaultValue = "0") int cottonMin,
                                   @RequestParam(required = false, defaultValue = "100") int cottonMax) {
        return ResponseEntity.ok(socksService.get(color, size, cottonMin, cottonMax));
    }

    @DeleteMapping
    public ResponseEntity<Socks> deleteSocks(@RequestBody SocksRequest socksRequest) {
        return ResponseEntity.ok(socksService.update(socksRequest));
    }
}
