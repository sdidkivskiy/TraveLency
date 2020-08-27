package org.TraveLency.controller;

import org.TraveLency.model.City;
import org.TraveLency.model.Country;
import org.TraveLency.model.Hotel;
import org.TraveLency.model.dto.HotelCityDto;
import org.TraveLency.model.dto.HotelCityRespDto;
import org.TraveLency.service.CityService;
import org.TraveLency.service.CountryService;
import org.TraveLency.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HotelsController {

    private final CityService cityService;

    private final CountryService countryService;

    private final HotelService hotelService;

    public HotelsController(HotelService hotelService, CountryService countryService, CityService cityService) {
        this.hotelService = hotelService;
        this.countryService = countryService;
        this.cityService = cityService;
    }

//    @PreAuthorize("hasRole=('USER')")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allHotels(HttpServletRequest request) {
        List<Hotel> hotels = hotelService.allHotels();
        List<HotelCityRespDto> hotelCityRespDtos = new ArrayList<>();
        for (Hotel hotel: hotels) {
            HotelCityRespDto hotelCityRespDto = new HotelCityRespDto();
            hotelCityRespDto.setHotelId(hotel.getId());
            hotelCityRespDto.setHotelName(hotel.getName());
            hotelCityRespDto.setAvailableRooms(hotel.getAvailableRooms());
            hotelCityRespDto.setCityName(hotel.getCity().getName());
            hotelCityRespDto.setCountryName(hotel.getCountry().getName());
            hotelCityRespDtos.add(hotelCityRespDto);
        }

        ModelAndView modelAndView = new ModelAndView();

        HttpSession session = request.getSession(true);
        if(session.getAttribute("login") != null) {
            modelAndView.addObject("login", session.getAttribute("login"));
            modelAndView.addObject("role", session.getAttribute("role"));
        }

        modelAndView.setViewName("hotels");
        modelAndView.addObject("hotelDtos", hotelCityRespDtos);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") Long id) {
        Hotel hotel = hotelService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
//        modelAndView.addObject("hotel", hotel);
        modelAndView.addObject("hotel", hotelService.getById(id));
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editHotel(@ModelAttribute("hotel") Hotel hotel) {
        ModelAndView modelAndView = new ModelAndView();
        hotelService.edit(hotel);
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addHotelPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("hotel", new Hotel());
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addHotel(@ModelAttribute("hotel") HotelCityDto hotelCityDto) {
        ModelAndView modelAndView = new ModelAndView();

        Country country = countryService.add(new Country(hotelCityDto.getCountryName()));
        City city = cityService.add(new City(hotelCityDto.getCityName(), country));

        Hotel hotel = new Hotel();
        hotel.setAvailableRooms(hotelCityDto.getAvailableRooms());
        hotel.setName(hotelCityDto.getHotelName());

        hotel.setCity(city);
        hotel.setCountry(country);
        Hotel hotelResp = hotelService.add(hotel);

        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteHotel(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        Hotel hotel = hotelService.getById(id);
        hotelService.delete(hotel);
        return modelAndView;
    }


}