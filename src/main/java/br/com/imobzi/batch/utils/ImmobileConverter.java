package br.com.imobzi.batch.utils;

import br.com.imobzi.batch.domain.*;
import org.springframework.boot.actuate.endpoint.web.Link;

import java.util.*;

public class ImmobileConverter {
    public static List<Photos> withPhotos(String photos){
        Photos photosList = new Photos();
        photosList.setUrl(photos);
        return new ArrayList<Photos>(Arrays.asList(photosList));
    }
    public static List<Owners> withOwners(String owners){
        Owners ownersList = new Owners();
        ownersList.setName(owners);
        return new ArrayList<Owners>(Arrays.asList(ownersList));
    }
    public static List<Multimidias> withMultimidias(String multimidias){
        Multimidias multimidiasList = new Multimidias();
        multimidiasList.setUrl(multimidias);
        return new ArrayList<Multimidias>(Arrays.asList(multimidiasList));
    }
    public static String withUrls(String state,String city,
                                  Integer bathroom,Integer bedroom){
        String urlsBuilder = state + city + bathroom.toString()+bedroom.toString();
        String urls = urlsBuilder.replace(" ", "_");
        return urls;
    }
    public static List<Links> withLinks(String captador){
        Links links = new Links();
        Contact contact = new Contact();
        contact.setName(captador);
        links.setContact(contact);
        return new ArrayList<Links>(Arrays.asList(links));
    }
}
