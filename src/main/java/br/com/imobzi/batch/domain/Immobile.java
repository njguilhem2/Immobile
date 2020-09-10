package br.com.imobzi.batch.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.util.*;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Immobile implements Serializable {

    private Boolean active;
    private String address;
    private String address_complement;
    private String alternative_code;
    private Integer area;
    private Integer bathroom;
    private Integer bedroom;
    private Boolean building;
    private String building_name;
    private Integer built;
    private String city;
    private String country;
    private String description;
    private Boolean exclusivity;
    private List<FeaturesValues> features_values;
    private List<FieldValues> field_values;
    private String finality;
    private Integer garage;
    private Integer latitude;
    private Integer longitude;
    private Integer lot_area;
    private Integer lot_measure_behind;
    private Integer lot_measure_front;
    private Integer lot_measure_left;
    private Integer lot_measure_radius;
    private Integer lot_measure_right;
    private String lot_measure_type;
    private String measure_type;
    private List<Multimidias> multimidias;
    private List<String> nearby;
    private String neighborhood;
    private String new_code;
    private List<Owners> owners;
    private List<Photos> photos;
    private List<PropertyCalendar> property_calendar;
    private String property_situation;
    private String property_type;
    private Double rental_value;
    private Double sale_value;
    private String site_description;
    private String site_meta_description;
    private Boolean site_publish;
    private Boolean site_publish_price;
    private String site_title;
    private String site_url;
    private String stage;
    private String state;
    private String status;
    private Integer suite;
    private String sun_position;
    private Integer useful_area;
    private Boolean vacation_rental;
    private Boolean visit_only_realtor;
    private String visit_time;
    private String with_plaque;
    private String zipcode;

    public Immobile withActive(Boolean active){
        this.active = active;
        return this;
    }
    public Immobile withAddress(String address){
        this.address = address;
        return this;
    }
    public Immobile withAddressCompl(String address_complement){
        this.address_complement = address_complement;
        return this;
    }
    public Immobile withNeighborhood(String neighborhood){
        this.neighborhood = neighborhood;
        return this;
    }
    public Immobile withCity(String city){
        this.city = city;
        return this;
    }
    public Immobile withState(String state){
        this.state = state;
        return this;
    }
    public Immobile withZipcode(String zipcode){
        this.zipcode = zipcode;
        return this;
    }
    public Immobile withCountry(String country){
        this.country = country;
        return this;
    }
    public Immobile withFinality(String finality){
        this.finality = finality;
        return this;
    }
    public Immobile withPropertyType(String propertyType){
        this.property_type = propertyType;
        return this;
    }
    public Immobile withBuildingName(String buildingName){
        this.building_name = buildingName;
        return this;
    }
    public Immobile withBuilding(Boolean building){
        this.building = building;
        return this;
    }
    public Immobile withAlternativeCode(String alternativeCode){
        this.alternative_code = alternativeCode;
        return this;
    }
    public Immobile withBedroom(Integer bedroom){
        this.bedroom = bedroom;
        return this;
    }
    public Immobile withSuite(Integer suite){
        this.suite = suite;
        return this;
    }
    public Immobile withBathroom(Integer bathroom){
        this.bathroom = bathroom;
        return this;
    }
    public Immobile withGarage(Integer garage){
        this.garage = garage;
        return this;
    }
    public Immobile withUsefulArea(Integer useful_area){
        this.useful_area = useful_area;
        return this;
    }
    public Immobile withLotArea(Integer lot_area){
        this.lot_area = lot_area;
        return this;
    }
    public Immobile withArea(Integer area){
        this.area = area;
        return this;
    }
    public Immobile withDescriptions(String description){
        this.description = description;
        return this;
    }
    public Immobile withSaleValue(Double saleValue){
        this.sale_value =saleValue;
        return this;
    }
    public Immobile withRentalValue(Double rentalValue){
        this.rental_value = rentalValue;
        return this;
    }
    public Immobile withBuilt(Integer built){
        this.built = built;
        return this;
    }
    public Immobile withPhotos(List<Photos> photos){
        this.photos = photos;
        return this;
    }
    public Immobile withOwners(List<Owners> owners){
        this.owners = owners;
        return this;
    }
    public Immobile withMultimidias(List<Multimidias> multimidias){
        this.multimidias = multimidias;
        return this;
    }

    public Immobile withStatus(String status) {
        this.status = status;
        return this;
    }
    public Immobile withSiteUrl(String url){
        this.site_url = url;
        return this;
    }
}
