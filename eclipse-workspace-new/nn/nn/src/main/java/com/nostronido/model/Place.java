package com.nostronido.model;

import java.util.List;
import java.util.Objects;

public class Place {

    // --- 1. ATRIBUTOS (Fields) ---
    private String name;
    private String neighborhood;
    private String address;
    private String mainImageUrl;
    private List<String> galleryImageUrls;
    private String curatedDescription;
    private String proTip;
    private String googleMapsUrl;
    private String reservationUrl;
    private String budget;
    private List<String> periods;
    private List<String> dateTypes;
    private List<String> vibes;

    // --- 2. CONSTRUTORES (Constructors) ---

    /**
     * Construtor público sem argumentos.
     * Necessário para frameworks e bibliotecas de serialização.
     */
    public Place() {
    }

    /**
     * Construtor privado que recebe o Builder.
     * Usado internamente pelo padrão Builder para construir o objeto.
     */
    private Place(PlaceBuilder builder) {
        this.name = builder.name;
        this.neighborhood = builder.neighborhood;
        this.address = builder.address;
        this.mainImageUrl = builder.mainImageUrl;
        this.galleryImageUrls = builder.galleryImageUrls;
        this.curatedDescription = builder.curatedDescription;
        this.proTip = builder.proTip;
        this.googleMapsUrl = builder.googleMapsUrl;
        this.reservationUrl = builder.reservationUrl;
        this.budget = builder.budget;
        this.periods = builder.periods;
        this.dateTypes = builder.dateTypes;
        this.vibes = builder.vibes;
    }


    // --- 3. GETTERS E SETTERS ---
    // Métodos para acessar e modificar cada um dos atributos.

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getNeighborhood() { return neighborhood; }
    public void setNeighborhood(String neighborhood) { this.neighborhood = neighborhood; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getMainImageUrl() { return mainImageUrl; }
    public void setMainImageUrl(String mainImageUrl) { this.mainImageUrl = mainImageUrl; }

    public List<String> getGalleryImageUrls() { return galleryImageUrls; }
    public void setGalleryImageUrls(List<String> galleryImageUrls) { this.galleryImageUrls = galleryImageUrls; }

    public String getCuratedDescription() { return curatedDescription; }
    public void setCuratedDescription(String curatedDescription) { this.curatedDescription = curatedDescription; }

    public String getProTip() { return proTip; }
    public void setProTip(String proTip) { this.proTip = proTip; }

    public String getGoogleMapsUrl() { return googleMapsUrl; }
    public void setGoogleMapsUrl(String googleMapsUrl) { this.googleMapsUrl = googleMapsUrl; }

    public String getReservationUrl() { return reservationUrl; }
    public void setReservationUrl(String reservationUrl) { this.reservationUrl = reservationUrl; }

    public String getBudget() { return budget; }
    public void setBudget(String budget) { this.budget = budget; }

    public List<String> getPeriods() { return periods; }
    public void setPeriods(List<String> periods) { this.periods = periods; }

    public List<String> getDateTypes() { return dateTypes; }
    public void setDateTypes(List<String> dateTypes) { this.dateTypes = dateTypes; }



    public List<String> getVibes() { return vibes; }
    public void setVibes(List<String> vibes) { this.vibes = vibes; }


    // --- 4. MÉTODOS PADRÃO (equals, hashCode, toString) ---

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place place = (Place) o;
        return Objects.equals(name, place.name) &&
                Objects.equals(neighborhood, place.neighborhood) &&
                Objects.equals(address, place.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, neighborhood, address);
    }

    @Override
    public String toString() {
        return "Place{" +
                "name='" + name + '\'' +
                ", neighborhood='" + neighborhood + '\'' +
                ", budget='" + budget + '\'' +
                '}';
    }

    // --- 5. PADRÃO BUILDER (Builder Pattern) ---

    /**
     * Ponto de entrada para o Builder.
     * Retorna uma nova instância da classe PlaceBuilder.
     */
    public static PlaceBuilder builder() {
        return new PlaceBuilder();
    }

    /**
     * Classe interna estática que implementa o padrão Builder.
     */
    public static class PlaceBuilder {
        private String name;
        private String neighborhood;
        private String address;
        private String mainImageUrl;
        private List<String> galleryImageUrls;
        private String curatedDescription;
        private String proTip;
        private String googleMapsUrl;
        private String reservationUrl;
        private String budget;
        private List<String> periods;
        private List<String> dateTypes;
        private List<String> vibes;

        // Métodos "fluentes" para setar cada atributo
        public PlaceBuilder name(String name) { this.name = name; return this; }
        public PlaceBuilder neighborhood(String neighborhood) { this.neighborhood = neighborhood; return this; }
        public PlaceBuilder address(String address) { this.address = address; return this; }
        public PlaceBuilder mainImageUrl(String mainImageUrl) { this.mainImageUrl = mainImageUrl; return this; }
        public PlaceBuilder galleryImageUrls(List<String> galleryImageUrls) { this.galleryImageUrls = galleryImageUrls; return this; }
        public PlaceBuilder curatedDescription(String curatedDescription) { this.curatedDescription = curatedDescription; return this; }
        public PlaceBuilder proTip(String proTip) { this.proTip = proTip; return this; }
        public PlaceBuilder googleMapsUrl(String googleMapsUrl) { this.googleMapsUrl = googleMapsUrl; return this; }
        public PlaceBuilder reservationUrl(String reservationUrl) { this.reservationUrl = reservationUrl; return this; }
        public PlaceBuilder budget(String budget) { this.budget = budget; return this; }
        public PlaceBuilder periods(List<String> periods) { this.periods = periods; return this; }
        public PlaceBuilder dateTypes(List<String> dateTypes) { this.dateTypes = dateTypes; return this; }
        public PlaceBuilder vibes(List<String> vibes) { this.vibes = vibes; return this; }
        
        /**
         * Método final que constrói e retorna o objeto Place.
         */
        public Place build() {
            return new Place(this);
        }
    }
}