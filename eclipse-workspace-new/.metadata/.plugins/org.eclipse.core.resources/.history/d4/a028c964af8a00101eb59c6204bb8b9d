package com.nostronido.service;

import com.nostronido.db.InMemoryPlaceDatabase;
import com.nostronido.model.Place;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Service
public class PlaceService {

    private final InMemoryPlaceDatabase database;

    public PlaceService(InMemoryPlaceDatabase database) {
        this.database = database;
    }

    public List<Place> findPlaces(Map<String, String> filters) {
        // Começa com um Stream de todos os locais no banco de dados
        Stream<Place> placesStream = database.getPlaces().stream();

        // Aplica cada filtro dinamicamente
        for (Map.Entry<String, String> entry : filters.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            if (value != null && !value.isEmpty()) {
                placesStream = switch (key) {
                    case "budget" -> placesStream.filter(p -> p.getBudget().equals(value));
                    case "neighborhood" -> placesStream.filter(p -> p.getNeighborhood().equals(value));
                    case "periods" -> placesStream.filter(p -> p.getPeriods().contains(value));
                    case "dateTypes" -> placesStream.filter(p -> p.getDateTypes().contains(value));
                    case "vibes" -> placesStream.filter(p -> p.getVibes().contains(value));
                    default -> placesStream;
                };
            }
        }

        // Coleta os resultados filtrados em uma lista e a retorna
        return placesStream.toList();
    }
}