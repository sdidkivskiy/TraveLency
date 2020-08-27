package org.TraveLency.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookRoomDto {

    private Long hotelId;

    private String dateFrom;

    private String dateTo;

    private Long countRooms;

}
