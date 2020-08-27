package org.TraveLency.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HotelEditDto {

    private Long hotelId;

    private String hotelName;

    private Long availableRooms;
}
