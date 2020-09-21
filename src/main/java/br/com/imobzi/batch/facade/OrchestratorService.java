package br.com.imobzi.batch.facade;

import br.com.imobzi.batch.domain.ImmobileRequest;
import br.com.imobzi.batch.domain.ImmobileResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface OrchestratorService {
     List<ImmobileResponse> orchestrator(final MultipartFile inputStream,
                                               ImmobileRequest immobileRequest )throws Exception;
}
