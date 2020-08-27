package org.TraveLency.model.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HotelCityDto {

    private String hotelName;

    private Long availableRooms;

    private String countryName;

    private String cityName;

}
