package com.nostronido.db;

import com.nostronido.model.Place;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryPlaceDatabase {

    private final List<Place> places = new ArrayList<>();

    // O método anotado com @PostConstruct roda uma vez após a inicialização do componente
    @PostConstruct
    public void init() {
        System.out.println(">>> Criando banco de dados em memória...");

        Place place1 = Place.builder()
            .name("Enoteca Decanter")
            .neighborhood("Moinhos de Vento")
            .address("R. Dinarte Ribeiro, 125 - Moinhos de Vento")
            .mainImageUrl("https://example.com/image1.jpg")
            .curatedDescription("Um charmoso bar de vinhos, perfeito para conversas longas e um primeiro encontro sem pressão.")
            .proTip("Peça a tábua de frios da casa, harmoniza com quase todos os vinhos.")
            .budget("budget_$$")
            .periods(List.of("tarde", "noite"))
            .dateTypes(List.of("primeiroEncontro", "soParaConversar"))
            .vibes(List.of("romanticoIntimo", "descontraidoCasual"))
            .build();

        Place place2 = Place.builder()
            .name("Passeio na Orla do Guaíba")
            .neighborhood("Orla")
            .address("Av. Edvaldo Pereira Paiva - Praia de Belas")
            .mainImageUrl("https://example.com/image2.jpg")
            .curatedDescription("Um clássico de Porto Alegre. Ideal para um encontro casual durante o dia, caminhando e apreciando o pôr do sol.")
            .proTip("Leve uma canga e compre um café nos quiosques para um momento relaxante.")
            .budget("budget_$")
            .periods(List.of("manha", "tarde"))
            .dateTypes(List.of("primeiroEncontro"))
            .vibes(List.of("aoArLivre", "descontraidoCasual"))
            .build();
        
        Place place3 = Place.builder()
            .name("Puppi Baggio")
            .neighborhood("Moinhos de Vento")
            .address("R. Dinarte Ribeiro, 155 - Moinhos de Vento")
            .mainImageUrl("https://example.com/image3.jpg")
            .curatedDescription("Restaurante italiano clássico e sofisticado. Perfeito para comemorar uma data especial com massas incríveis.")
            .proTip("Faça uma reserva, especialmente para o jantar de fim de semana.")
            .budget("budget_$$$")
            .periods(List.of("noite"))
            .dateTypes(List.of("comemorarAniversario"))
            .vibes(List.of("romanticoIntimo", "sofisticado"))
            .build();

        this.places.add(place1);
        this.places.add(place2);
        this.places.add(place3);
        
        System.out.println(">>> Banco de dados em memória populado com " + this.places.size() + " locais.");
    }

    public List<Place> getPlaces() {
        return this.places;
    }
}