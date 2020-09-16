package br.com.imobzi.batch.controller;

import br.com.imobzi.batch.domain.Excel;
import br.com.imobzi.batch.domain.ImmobileRequest;
import br.com.imobzi.batch.domain.ImmobileResponse;
import br.com.imobzi.batch.facade.OrchestratorService;
import br.com.imobzi.batch.utils.ExcelValidation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/immobile")
public class ImmobileController {

    @Autowired
    private OrchestratorService orchestratorService;

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
    produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ImmobileResponse>> saveImmobile(
            @RequestParam(value = "files") MultipartFile[] files,
            String teste) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        ImmobileRequest immobileRequest = null;
        try {
            immobileRequest = mapper.readValue(teste, ImmobileRequest.class);
        } catch (IOException e) {
            return ResponseEntity.badRequest().body(null);
        }
        List<ImmobileResponse> immobileResponse = new ArrayList<>();
        for (final MultipartFile file : files) {
            immobileResponse = this.orchestratorService
                    .orchestrator(file, immobileRequest);
        }
        return new ResponseEntity(immobileResponse, HttpStatus.CREATED);
    }
}
