package br.com.imobzi.batch.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Owners {
    private String code;
    private List<String> email;
    private Integer id;
    private String name;
    private String percentage;
    private String profile_image_url;
    private String rate;
    private String type;
}
