package br.com.imobzi.batch.facade;

import br.com.imobzi.batch.domain.*;
import br.com.imobzi.batch.service.ExcelService;
import br.com.imobzi.batch.service.ImobziService;
import br.com.imobzi.batch.utils.ImmobileConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrchestratorService {
    @Autowired
    private ImobziService imobziService;
    @Autowired
    private ExcelService excelService;

    public ImmobileResponse orchestrator(final MultipartFile inputStream) throws Exception {
        List<Excel> excelList = this.excelService.postImmobileInImobzi(inputStream);
        List<Property> property = excelListToImmobile(excelList);
        return this.imobziService.postImmobile(property);
    }

    private List<Property> excelListToImmobile(List<Excel> execelList) {
        List<Property> property = execelList.parallelStream().map(
                excel -> new Property(new Immobile()
                        .withActive(Boolean.TRUE)
                        .withStatus(excel.getStatus())
                        .withAddress(excel.getAddress())
                        .withAddressCompl(excel.getAddress_complement())
                        .withAlternativeCode(excel.getAlternative_code())
                        .withBedroom(excel.getBedroom())
                        .withSuite(excel.getSuite())
                        .withBathroom(excel.getBathroom())
                        .withGarage(excel.getGarage())
                        .withUsefulArea(excel.getUseful_area())
                        .withLotArea(excel.getLot_area())
                        .withArea(excel.getArea())
                        //formatter java
                        .withDescriptions(excel.getDescription() + excel.getIptu().toString()
                                + excel.getCaptador() + excel.getDiscount())
                        .withSaleValue(excel.getSale_value())
                        .withRentalValue(excel.getRental_value())
                        .withBuilt(excel.getBuilt())
                        .withNeighborhood(excel.getNeighborhood())
                        .withCity(excel.getCity())
                        .withState(excel.getState())
                        .withZipcode(excel.getZipcode())
                        .withCountry(excel.getCountry())
                        .withFinality(excel.getFinality())
                        .withPropertyType(excel.getProperty_type())
                        .withBuildingName(excel.getBuilding_name())
                        .withBuilding(excel.getBuilding())
                        .withOwners(ImmobileConverter.withOwners(excel.getOwners()))
                        .withPhotos(ImmobileConverter.withPhotos(excel.getPhotos()))
                        .withMultimidias(ImmobileConverter.withMultimidias(excel.getMultimidias()))
                )).collect(Collectors.toList());
        return property;
    }
}
