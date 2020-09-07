package br.com.imobzi.batch.service.impl;

import br.com.imobzi.batch.domain.Immobile;
import br.com.imobzi.batch.domain.ImmobileResponse;
import br.com.imobzi.batch.domain.Property;
import br.com.imobzi.batch.service.ImobziService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.nio.charset.StandardCharsets;

@Service
@Slf4j
public class ImobziServiceImpl implements ImobziService {
    @Value("${url.imobzi.post}")
    private String url;
    @Value("${secret.imobzi}")
    private String secret;
    private final static String SECRET_NAME = "X-Imobzi-Secret";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ImmobileResponse postImmobile(List<Property> property) {
        HttpHeaders httpHeaders = new HttpHeaders();

        //TODO ajustar o envio agora 1 por 1

        httpHeaders.add(this.SECRET_NAME, this.secret);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity httpEntity = new HttpEntity(null, httpHeaders);
        this.restTemplate.getMessageConverters()
                .add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        log.info("Making request for the imobzi");
        ResponseEntity<ImmobileResponse> immobileResponseResponseEntity =
                this.restTemplate.exchange(this.url, HttpMethod.POST, httpEntity, ImmobileResponse.class);
        return immobileResponseResponseEntity.getBody();
    }
}
