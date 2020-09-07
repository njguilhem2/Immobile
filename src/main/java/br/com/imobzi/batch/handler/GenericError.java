package br.com.imobzi.batch.handler;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GenericError {
    private String code;
    private String message;
    private String level;
    private String description;
}
