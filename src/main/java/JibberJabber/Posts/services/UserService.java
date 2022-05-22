package JibberJabber.Posts.services;

import JibberJabber.Posts.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User save(User newUser);

    User find(Long id);

    User replace(User newUser, Long id);

    void delete(Long id);
}
