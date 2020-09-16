package br.com.imobzi.batch.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Excel {
    private String address;
    private String address_complement;
    private String neighborhood;
    private String city;
    private String state;
    private String status;
    private String zipcode;
    private String country;
    private String finality;
    private String property_type;
    private String building_name;
    private Boolean building;
    private String alternative_code;
    private Integer bedroom;
    private Integer suite;
    private Integer bathroom;
    private Integer garage;
    private Integer useful_area;
    private Integer lot_area;
    private Integer area;
    private String description;
    private Double sale_value;
    private Double rental_value;
    private Double iptu;
    private Integer built;
    private String owners;
    private String captador;
    private String photos;
    private String multimidias;
    private Double avaliation_value;
    private Double discount;
    private String tittle;
}
