package br.com.imobzi.batch.service;

import br.com.imobzi.batch.domain.ImmobileResponse;
import br.com.imobzi.batch.domain.Property;
import java.util.*;

public interface ImobziService {
    ImmobileResponse postImmobile(List<Property> property);
}
