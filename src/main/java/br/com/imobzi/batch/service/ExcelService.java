package br.com.imobzi.batch.service;

import br.com.imobzi.batch.domain.Excel;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ExcelService {
    List<Excel> readList(final MultipartFile inputStream, String description) throws Exception;
}
