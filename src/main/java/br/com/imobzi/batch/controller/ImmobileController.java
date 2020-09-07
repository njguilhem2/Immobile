package br.com.imobzi.batch.controller;

import br.com.imobzi.batch.domain.Excel;
import br.com.imobzi.batch.domain.ImmobileResponse;
import br.com.imobzi.batch.facade.OrchestratorService;
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
    private OrchestratorService orchestratorService;

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Excel>> saveImmobile(
            @RequestParam(value = "files") MultipartFile[] files) throws Exception {

            ImmobileResponse immobileResponse=  new ImmobileResponse();
            for (final MultipartFile file : files) {
                immobileResponse = this.orchestratorService.orchestrator(file);
            }
            return new ResponseEntity(immobileResponse,HttpStatus.CREATED);
    }
}
