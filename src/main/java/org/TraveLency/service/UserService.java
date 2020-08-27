package org.TraveLency.service;

import org.TraveLency.model.User;

public interface UserService extends BasicOperations<User> {

    User getByLogin(String login);

}
