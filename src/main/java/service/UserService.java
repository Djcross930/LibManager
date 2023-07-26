package service;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);  // Returns null if the user does not exist
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User updateUser(User user) {
        // In this case, the id of the user passed to this method should be set to the id of the user you want to update.
        // If the user exists, the existing user will be updated with the fields of the passed user.
        // If the user does not exist, a new user will be created with the fields of the passed user.
        return userRepository.save(user);
    }

    // You can continue to add more methods here based on your application needs...
}

