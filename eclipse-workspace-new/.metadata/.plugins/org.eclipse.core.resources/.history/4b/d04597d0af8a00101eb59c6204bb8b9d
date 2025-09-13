package com.nostronido.controller;

import com.nostronido.model.Place;
import com.nostronido.service.PlaceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/places")
@CrossOrigin(origins = "*") // Permite requisições de qualquer origem
public class PlaceController {

    private final PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping
    public List<Place> getPlaces(@RequestParam Map<String, String> allParams) {
        return placeService.findPlaces(allParams);
    }
}