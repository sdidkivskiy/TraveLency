package org.TraveLency.service.impl;

import org.TraveLency.exceptions.MainException;
import org.TraveLency.model.User;
import org.TraveLency.repository.UserRepository;
import org.TraveLency.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.TraveLency.constants.ErrorConstants.USER_BY_SUCH_ID_IS_NOT_FOUND;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User add(User entity) {
        return userRepository.save(entity);
    }

    @Override
    public User update(User entity, Long id) {
        return null;
    }

    @Override
    public User get(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new MainException(USER_BY_SUCH_ID_IS_NOT_FOUND, 404L));
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public User getByLogin(String login) {
        return userRepository.findByLogin(login);
    }
}
