package org.TraveLency.service;

import org.TraveLency.model.Hotel;

import java.util.List;

public interface HotelService {

        List<Hotel> allHotels();

        Hotel add(Hotel hotel);

        void delete(Hotel hotel);

        Hotel edit(Hotel hotel);

        Hotel getById(Long id);
}
