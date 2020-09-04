package br.com.imobzi.batch.service;

import br.com.imobzi.batch.domain.Immobile;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImmobileService {
    List<Immobile> postImmobileInImobzi(final MultipartFile inputStream) throws Exception;
}
