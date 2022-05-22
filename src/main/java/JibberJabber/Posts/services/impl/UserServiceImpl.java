package JibberJabber.Posts.services.impl;

import JibberJabber.Posts.exceptions.UserNotFoundException;
import JibberJabber.Posts.model.User;
import JibberJabber.Posts.repositories.UserRepository;
import JibberJabber.Posts.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository userRepository) {repository = userRepository;}

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public User save(User newUser) {
        return repository.save(newUser);
    }

    @Override
    public User find(Long id) {
        return repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public User replace(User newUser, Long id) {
        return repository.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setPassword(newUser.getPassword());
                    user.setFollowing(newUser.getFollowing());
                    return repository.save(user);
                }).orElseGet(() -> {
                    newUser.setId(id);
                    return repository.save(newUser);
                });    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
