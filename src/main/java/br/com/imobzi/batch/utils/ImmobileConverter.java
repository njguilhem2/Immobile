package br.com.imobzi.batch.utils;

import br.com.imobzi.batch.domain.Multimidias;
import br.com.imobzi.batch.domain.Owners;
import br.com.imobzi.batch.domain.Photos;
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
}
