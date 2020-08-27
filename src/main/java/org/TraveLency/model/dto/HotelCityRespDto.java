package org.TraveLency.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HotelCityRespDto {

    private Long hotelId;

    private String hotelName;

    private Long availableRooms;

    private String countryName;

    private String cityName;

}
