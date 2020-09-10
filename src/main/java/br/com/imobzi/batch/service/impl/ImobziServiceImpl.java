package br.com.imobzi.batch.service.impl;

import br.com.imobzi.batch.domain.Immobile;
import br.com.imobzi.batch.domain.ImmobileResponse;
import br.com.imobzi.batch.domain.Property;
import br.com.imobzi.batch.handler.BadRequestException;
import br.com.imobzi.batch.handler.ForbiddenException;
import br.com.imobzi.batch.handler.GenericError;
import br.com.imobzi.batch.service.ImobziService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
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
    public List<ImmobileResponse> postImmobile(List<Property> property) {
        List<ImmobileResponse> immobileResponseList = new ArrayList<>();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(this.SECRET_NAME, this.secret);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        this.restTemplate.getMessageConverters()
                .add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));

        property.forEach(immobile -> {
            try {
                HttpEntity httpEntity = new HttpEntity(immobile, httpHeaders);
                log.info("===============================================");
                log.info("Making request for the imobzi");
                ResponseEntity<ImmobileResponse> immobileResponseResponseEntity =
                        this.restTemplate.exchange(this.url, HttpMethod.POST,
                                httpEntity, ImmobileResponse.class);
                immobileResponseList.add(immobileResponseResponseEntity.getBody());
            } catch (HttpStatusCodeException e) {
                genericErrorHttpExceptions(e, immobile.getProperty().getAddress());
            }
        });
        return immobileResponseList;
    }
    private GenericError genericErrorHttpExceptions(HttpStatusCodeException ex, String address) {
        if (ex.getStatusCode() == HttpStatus.FORBIDDEN) {
            throw new ForbiddenException("Empreendimento já utilizado " +
                    "o qual refere-se a esse Endereço: "+ address + ", por gentileza " +
                    "revisar a planilha");
        }else if (ex.getStatusCode() == HttpStatus.BAD_REQUEST){
            throw new BadRequestException("Campo requerido não inserido no Endereço: "+address);
        }
        throw new ForbiddenException("");
    }
}
