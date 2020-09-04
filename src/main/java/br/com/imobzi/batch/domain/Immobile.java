package br.com.imobzi.batch.domain;

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
    private Integer rental_value;
    private Integer sale_value;
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
}
