package br.com.imobzi.batch.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Multimidias {
    private String category;
    private Integer db_id;
    private String description;
    private String image_key;
    private Integer position;
    private String url;
}
