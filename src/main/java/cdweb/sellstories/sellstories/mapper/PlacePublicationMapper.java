package cdweb.sellstories.sellstories.mapper;

import cdweb.sellstories.sellstories.dto.PlacePublicationDTO;
import cdweb.sellstories.sellstories.entity.PlacePublication;

public class PlacePublicationMapper {

 public static PlacePublicationDTO mapToPlacePublicationDTO(PlacePublication placePublication) {
     return PlacePublicationDTO.builder()
             .id(placePublication.getId())
             .name(placePublication.getName())
             .build();
 }
}
