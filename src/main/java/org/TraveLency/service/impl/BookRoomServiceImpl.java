package org.TraveLency.service.impl;

import org.TraveLency.exceptions.MainException;
import org.TraveLency.model.BookRoom;
import org.TraveLency.model.User;
import org.TraveLency.repository.BookRoomRepository;
import org.TraveLency.service.BookRoomService;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.TraveLency.constants.ErrorConstants.BOOK_ROOM_BY_SUCH_ID_IS_NOT_FOUND;

@Service
public class BookRoomServiceImpl implements BookRoomService {

    private final BookRoomRepository bookRoomRepository;

    public BookRoomServiceImpl(BookRoomRepository bookRoomRepository) {
        this.bookRoomRepository = bookRoomRepository;
    }

    @Override
    public BookRoom add(BookRoom entity) {
        return bookRoomRepository.save(entity);
    }

    @Override
    public BookRoom update(BookRoom entity, Long id) {
        return null;
    }

    @Override
    public BookRoom get(Long id) {
        return null;
    }

    @Override
    public List<BookRoom> getAll() {
        return null;
    }

    @Override
    public void delete(Long id) {
        BookRoom bookRoom = bookRoomRepository.findById(id).orElseThrow(() -> new MainException(BOOK_ROOM_BY_SUCH_ID_IS_NOT_FOUND, 404L));
        bookRoomRepository.delete(bookRoom);
    }

    @Override
    public List<BookRoom> getByUser(User user) {
        return bookRoomRepository.findByUser(user);
    }
}
