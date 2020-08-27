package org.TraveLency.controller;

import org.TraveLency.model.BookRoom;
import org.TraveLency.model.User;
import org.TraveLency.model.dto.BookRoomDto;
import org.TraveLency.model.dto.BookedRoomsDto;
import org.TraveLency.service.BookRoomService;
import org.TraveLency.service.HotelService;
import org.TraveLency.service.UserService;
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
public class BookController {

    private final HotelService hotelService;
    private final UserService userService;
    private final BookRoomService bookRoomService;

    public BookController(HotelService hotelService, UserService userService, BookRoomService bookRoomService) {
        this.hotelService = hotelService;
        this.userService = userService;
        this.bookRoomService = bookRoomService;
    }

    @RequestMapping(value = "/book/{hotelId}", method = RequestMethod.GET)
    public ModelAndView bookHotelGET(@PathVariable("hotelId") Long hotelId, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("bookHotel");
        modelAndView.addObject("hotelId", hotelId);
        return modelAndView;
    }

    @RequestMapping(value = "/bookedRooms", method = RequestMethod.GET)
    public ModelAndView bookedRooms(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession(true);
        List<BookRoom> bookRooms = bookRoomService.getByUser(userService.getByLogin((String)session.getAttribute("login")));
        List<BookedRoomsDto> bookedRoomsDtos = new ArrayList<>();
        for (BookRoom bookRoom: bookRooms) {
            BookedRoomsDto bookedRoomsDto = new BookedRoomsDto();
            bookedRoomsDto.setBookRoomId(bookRoom.getId());
            bookedRoomsDto.setHotelName(bookRoom.getHotel().getName());
            bookedRoomsDto.setDateFrom(bookRoom.getFromDate());
            bookedRoomsDto.setDateTo(bookRoom.getToDate());
            bookedRoomsDto.setCountRooms(bookRoom.getNumberBookedRooms());
            bookedRoomsDtos.add(bookedRoomsDto);
        }

        modelAndView.addObject("bookedRooms", bookedRoomsDtos);
        modelAndView.setViewName("bookedRooms");
        return modelAndView;
    }

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public ModelAndView bookHotelPOST(@ModelAttribute("bookRoomDto") BookRoomDto bookRoomDto, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();

        HttpSession session = request.getSession(true);

        BookRoom bookRoom = new BookRoom();
        bookRoom.setUser(userService.getByLogin((String)session.getAttribute("login")));
        bookRoom.setHotel(hotelService.getById(bookRoomDto.getHotelId()));
        bookRoom.setFromDate(bookRoomDto.getDateFrom());
        bookRoom.setToDate(bookRoomDto.getDateTo());
        bookRoom.setNumberBookedRooms(bookRoomDto.getCountRooms());

        bookRoomService.add(bookRoom);

        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

    @RequestMapping(value = "/bookedRooms/{bookedRoomId}", method = RequestMethod.GET)
    public ModelAndView bookedRoomsDelete(@PathVariable("bookedRoomId") Long bookedRoomId, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        bookRoomService.delete(bookedRoomId);

        modelAndView.setViewName("redirect:/bookedRooms");

        return modelAndView;
    }

}