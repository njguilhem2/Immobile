package br.com.imobzi.batch.utils;

import br.com.imobzi.batch.handler.BadRequestException;
import org.springframework.util.ObjectUtils;
import java.text.MessageFormat;

public class ExcelValidation {

    public static Boolean validBuilding(String string) {
        if (ObjectUtils.isEmpty(string)) {
            return false;
        }
        return true;
    }

    public static String validAddress(String valid) {
        if (!ObjectUtils.isEmpty(valid)) {
            return valid;
        }
        throw new BadRequestException("Endereço nulo ou inválido");
    }

    public static String validCity(String valid) {
        if (!ObjectUtils.isEmpty(valid)) {
            return valid;
        }
        throw new BadRequestException("Cidade nula ou inválido");
    }

    public static String validCountry(String valid) {
        if (!ObjectUtils.isEmpty(valid)) {
            return valid;
        }
        throw new BadRequestException("Pais nulo ou inválido");
    }

    public static String validFinality(String valid) {
        if (!ObjectUtils.isEmpty(valid)) {
            if (valid.equals("residential") || valid.equals("commercial")
                    || valid.equals("rural")) {
                return valid;
            }
        }
        throw new BadRequestException("tipo não pode ser nula ou inválido");
    }

    public static String validNeighborhood(String valid) {
        if (!ObjectUtils.isEmpty(valid)) {
            return valid;
        }
        throw new BadRequestException("Vizinhança nula ou inválido");
    }

    public static String validZipcode(Integer valid) {
        if (!ObjectUtils.isEmpty(valid)) {
            return valid.toString();
        }
        throw new BadRequestException("CEP nula ou inválido");
    }

    public static Double validRentalValue(Double valid) {
        if (!ObjectUtils.isEmpty(valid)) {
            return valid;
        }
        throw new BadRequestException("Valor da locação não pode ser nul ou está inválido");
    }

    public static Double validSaleValue(Double valid) {
        if (!ObjectUtils.isEmpty(valid)) {
            return valid;
        }
        throw new BadRequestException("Valor da locação não pode ser nul ou está inválido");
    }

    public static String validState(String valid) {
        if (!ObjectUtils.isEmpty(valid)) {
            return valid;
        }
        throw new BadRequestException("Estado não pode ser nulo ou está inválido");
    }

    public static String validDescription(String description,
                                          String address,
                                          String addressComplement,
                                          String neighborhood,
                                          String city,
                                          String state,
                                          Integer zipcode,
                                          String country,
                                          String finality,
                                          String propertyType,
                                          String buildingName,
                                          String alternativeCode,
                                          Integer bedroom,
                                          Integer suite,
                                          Integer bathroom,
                                          Integer garage,
                                          Integer usefulArea,
                                          Integer lotArea,
                                          Integer area,
                                          String descriptionExcel,
                                          Double saleValue,
                                          Double rentalValue,
                                          Double iptu,
                                          Integer built,
                                          String owners,
                                          String captador,
                                          String photos,
                                          String multimidias,
                                          Double avaliation_value,
                                          Double discount) {

        if (!ObjectUtils.isEmpty(description)) {
            String descriptionFinal = MessageFormat
                    .format(description, address,addressComplement,neighborhood,city,
                            state,zipcode,country,finality,propertyType,buildingName,
                            alternativeCode,bedroom,suite,bathroom,garage,usefulArea,
                            lotArea,area,descriptionExcel,saleValue,rentalValue,iptu,built,owners,captador,
                            photos,multimidias,avaliation_value,discount);
            return descriptionFinal;
        }
        return descriptionExcel;
    }
}
