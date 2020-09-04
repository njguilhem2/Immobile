package br.com.imobzi.batch.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PropertyCalendar {
    private Integer db_id;
    private String event_type;
    private String final_date;
    private String initial_date;
    private String observation;
}
