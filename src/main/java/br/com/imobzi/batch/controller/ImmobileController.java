package br.com.imobzi.batch.controller;

import br.com.imobzi.batch.domain.Excel;
import br.com.imobzi.batch.domain.ImmobileResponse;
import br.com.imobzi.batch.facade.OrchestratorService;
import br.com.imobzi.batch.utils.ExcelValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

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
            @RequestParam(value = "description") String description) throws Exception {
            List<ImmobileResponse> immobileResponse=  new ArrayList<>();
            for (final MultipartFile file : files) {
                immobileResponse = this.orchestratorService.orchestrator(file,description);
            }
            return new ResponseEntity(immobileResponse,HttpStatus.CREATED);
    }
}
