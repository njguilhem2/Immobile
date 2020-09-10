package br.com.imobzi.batch.utils;

import br.com.imobzi.batch.handler.BadRequestException;
import org.springframework.util.ObjectUtils;

import java.text.MessageFormat;
import java.util.*;
import java.util.logging.Formatter;


public class ExcelValidation {
    //TODO verificar quais campos ele vai ter, se não vou ter q mockar
    //TODO fazer um validador para linha do erro e Validador de processamento 
    public static Boolean validBuilding(String string){
        if (ObjectUtils.isEmpty(string)){
            return false;
        }
        return true;
    }
    public static String validAddress(String valid){
        if(!ObjectUtils.isEmpty(valid)){
            return valid;
        }
        throw new BadRequestException("Endereço nulo ou inválido");
    }
    public static String validCity(String valid){
        if(!ObjectUtils.isEmpty(valid)){
            return valid;
        }
        throw new BadRequestException("Cidade nula ou inválido");
    }
    public static String validCountry(String valid){
        if(!ObjectUtils.isEmpty(valid)){
            return valid;
        }
        throw new BadRequestException("Pais nulo ou inválido");
    }
    public static String validFinality(String valid){
        if(!ObjectUtils.isEmpty(valid)){
            if (valid.equals("residential") || valid.equals("commercial")
                    || valid.equals("rural")) {
                return valid;
            }
        }
        throw new BadRequestException("tipo não pode ser nula ou inválido");
    }
    public static String validNeighborhood(String valid){
        if(!ObjectUtils.isEmpty(valid)){
            return valid;
        }
        throw new BadRequestException("Vizinhança nula ou inválido");
    }
    public static String validZipcode(Integer valid){
        if(!ObjectUtils.isEmpty(valid)){
            return valid.toString();
        }
        throw new BadRequestException("CEP nula ou inválido");
    }
    public static Double validRentalValue(Double valid){
        if(!ObjectUtils.isEmpty(valid)){
            return valid;
        }
        throw new BadRequestException("Valor da locação não pode ser nul ou está inválido");
    }
    public static Double validSaleValue(Double valid){
        if(!ObjectUtils.isEmpty(valid)){
            return valid;
        }
        throw new BadRequestException("Valor da locação não pode ser nul ou está inválido");
    }
    public static String validState(String valid){
        if(!ObjectUtils.isEmpty(valid)){
            return valid;
        }
        throw new BadRequestException("Estado não pode ser nulo ou está inválido");
    }
    public static String validDescription(String valid){
        Integer teste = 120;
        Integer teste2= 130;
        String teste3 = MessageFormat
                .format("ola...aslkdçsalksdksa sdajdsaildsajierqweoqw 2113123",teste,teste2);
        System.out.println(teste3);
        return "ola";
    }
}
