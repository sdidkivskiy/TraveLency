package org.TraveLency.repository;

import org.TraveLency.model.BookRoom;
import org.TraveLency.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRoomRepository extends JpaRepository<BookRoom, Long> {

    List<BookRoom> findByUser(User user);

}
