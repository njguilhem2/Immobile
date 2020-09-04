package br.com.imobzi.batch.controller;

import br.com.imobzi.batch.domain.Immobile;
import br.com.imobzi.batch.service.ImmobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/immobile")
public class ImmobileController {
    @Autowired
    private ImmobileService immobileService;

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Immobile>> saveImmobile(
            @RequestParam(value = "files") MultipartFile[] files) {
        try {
            for (final MultipartFile file : files) {
                this.immobileService.postImmobileInImobzi(file);
            }
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (final Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
