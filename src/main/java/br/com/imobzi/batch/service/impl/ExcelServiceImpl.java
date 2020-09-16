package br.com.imobzi.batch.service.impl;

import br.com.imobzi.batch.domain.Excel;
import br.com.imobzi.batch.handler.BadRequestException;
import br.com.imobzi.batch.service.ExcelService;
import br.com.imobzi.batch.utils.ExcelValidation;
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
public class ExcelServiceImpl implements ExcelService {
    @Override
    public List<Excel> readList(final MultipartFile inputStream, String description)
            throws Exception {
        return parseXlsxToImmobileList(inputStream,description);
    }

    public List<Excel> parseXlsxToImmobileList(MultipartFile file, String description)
            throws Exception {
        List<Excel> excelList = new ArrayList<>();
        log.info("opening excel information");
        Workbook workbook;
        String lowerCaseFileName = file.getOriginalFilename().toLowerCase();
        if (lowerCaseFileName.endsWith(".xlsx")) {
            workbook = new XSSFWorkbook(file.getInputStream());
        } else {
            workbook = new HSSFWorkbook(file.getInputStream());
        }
        Sheet sheet = workbook.getSheetAt(0);
        List<Row> rows = (List<Row>) toList(sheet.iterator());
        rows.remove(0);
        log.info("Reading excel information");
        rows.forEach(row -> {
            Excel excel = new Excel();
            List<Cell> cells = (List<Cell>) toList(row.cellIterator());
            try {
                excel = Excel.builder()
                        .address(ExcelValidation.validAddress(cells.get(0).getStringCellValue()))
                        .address_complement(cells.get(1).getStringCellValue())
                        .neighborhood(ExcelValidation.validNeighborhood(
                                cells.get(2).getStringCellValue()))
                        .city(ExcelValidation.validCity(cells.get(3).getStringCellValue()))
                        .state(ExcelValidation.validState
                                (cells.get(4).getStringCellValue()))
                        .zipcode(ExcelValidation.validZipcode((int) cells.get(5).getNumericCellValue()))
                        .country(ExcelValidation.validCountry(cells.get(6).getStringCellValue()))
                        .finality(ExcelValidation.validFinality(cells.get(7).getStringCellValue()))
                        .property_type(cells.get(8).getStringCellValue())
                        .building_name(cells.get(9).getStringCellValue())
                        .building(ExcelValidation.validBuilding(cells.get(9).getStringCellValue()))
                        .alternative_code(cells.get(10).getStringCellValue())
                        .bedroom((int) cells.get(11).getNumericCellValue())
                        .suite((int) cells.get(12).getNumericCellValue())
                        .bathroom((int) cells.get(13).getNumericCellValue())
                        .garage((int) cells.get(14).getNumericCellValue())
                        .useful_area((int) cells.get(15).getNumericCellValue())
                        .lot_area((int) cells.get(16).getNumericCellValue())
                        .area((int) cells.get(17).getNumericCellValue())
                        .description(ExcelValidation.validDescription(description,
                                cells.get(0).getStringCellValue(),
                                cells.get(1).getStringCellValue(),
                                cells.get(2).getStringCellValue(),
                                cells.get(3).getStringCellValue(),
                                cells.get(4).getStringCellValue(),
                                (int) cells.get(5).getNumericCellValue(),
                                cells.get(6).getStringCellValue(),
                                cells.get(7).getStringCellValue(),
                                cells.get(8).getStringCellValue(),
                                cells.get(9).getStringCellValue(),
                                cells.get(10).getStringCellValue(),
                                (int) cells.get(11).getNumericCellValue(),
                                (int) cells.get(12).getNumericCellValue(),
                                (int) cells.get(13).getNumericCellValue(),
                                (int) cells.get(14).getNumericCellValue(),
                                (int) cells.get(15).getNumericCellValue(),
                                (int) cells.get(16).getNumericCellValue(),
                                (int) cells.get(17).getNumericCellValue(),
                                cells.get(18).getStringCellValue(),
                                cells.get(19).getNumericCellValue(),
                                cells.get(20).getNumericCellValue(),
                                cells.get(21).getNumericCellValue(),
                                (int) cells.get(22).getNumericCellValue(),
                                cells.get(23).getStringCellValue(),
                                cells.get(24).getStringCellValue(),
                                cells.get(25).getStringCellValue(),
                                cells.get(26).getStringCellValue(),
                                cells.get(27).getNumericCellValue(),
                                cells.get(28).getNumericCellValue()
                                ))
                        .sale_value(ExcelValidation.validSaleValue
                                (cells.get(19).getNumericCellValue()))
                        .rental_value(ExcelValidation.validRentalValue
                                (cells.get(20).getNumericCellValue()))
                        .iptu(cells.get(21).getNumericCellValue())
                        .built((int) cells.get(22).getNumericCellValue())
                        .owners(cells.get(23).getStringCellValue())
                        .captador(cells.get(24).getStringCellValue())
                        .photos(cells.get(25).getStringCellValue())
                        .multimidias(cells.get(26).getStringCellValue())
                        .avaliation_value(cells.get(27).getNumericCellValue())
                        .discount(cells.get(28).getNumericCellValue())
                        .status("available")
                        .build();
                excelList.add(excel);
            } catch (RuntimeException e) {
                throw new BadRequestException(
                        "Erro na execução da planilha, planilha não enviada" +
                                "verificar o Endereço:" + cells.get(0).getStringCellValue());
            }
        });
        log.info("Finish reading excel");
        return excelList;
    }

    public List<?> toList(Iterator<?> iterator) {
        return IteratorUtils.toList(iterator);
    }
}
