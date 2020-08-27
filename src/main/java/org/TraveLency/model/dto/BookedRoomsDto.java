package org.TraveLency.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookedRoomsDto {

    private Long bookRoomId;

    private String hotelName;

    private String dateFrom;

    private String dateTo;

    private Long countRooms;
}
