package cdweb.sellstories.sellstories.mapper;

import cdweb.sellstories.sellstories.dto.PlacePublicationDTO;
import cdweb.sellstories.sellstories.entity.PlacePublication;

public class PlacePublicationMapper {

 public static PlacePublicationDTO mapToPlacePublicationDTO(PlacePublication placePublication) {
     return PlacePublicationDTO.builder()
             .name(placePublication.getName())
             .build();
 }
}
