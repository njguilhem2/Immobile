package br.com.imobzi.batch.service;

import br.com.imobzi.batch.domain.Excel;
import br.com.imobzi.batch.domain.Immobile;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ExcelService {
    List<Excel> postImmobileInImobzi(final MultipartFile inputStream) throws Exception;
}
