package br.com.imobzi.batch.service;

import br.com.imobzi.batch.domain.Immobile;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.IteratorUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Slf4j
public class ImmobileServiceImpl implements ImmobileService {
    @Override
    public List<Immobile> postImmobileInImobzi(final MultipartFile inputStream) throws Exception {
        return parseCSVFile(inputStream);
    }

    public List<Immobile> parseCSVFile(MultipartFile file) throws Exception {
        List<Immobile> immobileList = new ArrayList<>();

        //recuperando o arquivo
        Workbook workbook;
        String lowerCaseFileName = file.getOriginalFilename().toLowerCase();
        if (lowerCaseFileName.endsWith(".xlsx")) {
            workbook = new XSSFWorkbook(file.getInputStream());
        } else {
            workbook = new HSSFWorkbook(file.getInputStream());
        }

        //Setando a aba
        Sheet sheet = workbook.getSheetAt(0);
        List<Row> rows = (List<Row>) toList(sheet.iterator());

        rows.remove(0);
        //pegando as rows
        rows.forEach(row ->{
            //setando as celulas
            List<Cell> cells= (List<Cell>) toList(row.cellIterator());

            //Atribuindo Valores
            Immobile immobile = Immobile.builder()
                    .address(cells.get(0).getStringCellValue())
                    .address_complement(cells.get(1).getStringCellValue())
                    .area((int)cells.get(2).getNumericCellValue())
                    .build();
            immobileList.add(immobile);
        });
        System.out.printf(immobileList.get(0).toString());
        return immobileList;
    }
    public List<?> toList(Iterator<?> iterator){
        System.out.println("Chupa Casa");
        return IteratorUtils.toList(iterator);
    }
}
