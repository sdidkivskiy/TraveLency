package org.TraveLency.service.impl;

import org.TraveLency.exceptions.MainException;
import org.TraveLency.model.Hotel;
import org.TraveLency.repository.HotelRepository;
import org.TraveLency.service.HotelService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static org.TraveLency.constants.ErrorConstants.USER_BY_SUCH_ID_IS_NOT_FOUND;

@ComponentScan(basePackages = "org.TraveLency")
@Service
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Transactional
    @Override
    public List<Hotel> allHotels() {
        return hotelRepository.findAll();
    }

    @Transactional
    @Override
    public Hotel add(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Transactional
    @Override
    public void delete(Hotel hotel) {
        hotelRepository.delete(hotel);
    }

    @Transactional
    @Override
    public Hotel edit(Hotel hotel) {
        hotelRepository.save(hotel);
        return hotel;
    }

    @Override
    public Hotel getById(Long id) {
        return hotelRepository.findById(id)
                .orElseThrow(() -> new MainException(USER_BY_SUCH_ID_IS_NOT_FOUND, 404L));
    }
}
