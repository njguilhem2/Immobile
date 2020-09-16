package br.com.imobzi.batch.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImmobileRequest {
    @JsonProperty("titulo")
    private String title;
    @JsonProperty("descricao")
    private String description;
}
