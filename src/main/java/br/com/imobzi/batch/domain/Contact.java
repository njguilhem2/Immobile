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
public class Contact {
    @JsonProperty("contact_code")
    private String contactCode;
    @JsonProperty("contact_id")
    private String contactId;
    @JsonProperty("contact_type")
    private String contactType;
    private String email;
    @JsonProperty("link_type")
    private String linkType;
    private String name;
    @JsonProperty("profile_image_url")
    private String profileImageUrl;
}
