package org.TraveLency.service;

import org.TraveLency.model.BookRoom;
import org.TraveLency.model.User;

import java.util.List;

public interface BookRoomService extends BasicOperations<BookRoom>{

    List<BookRoom> getByUser(User user);

}
