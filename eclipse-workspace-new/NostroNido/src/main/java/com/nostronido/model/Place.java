package com.nostronido.model;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Place {
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
}