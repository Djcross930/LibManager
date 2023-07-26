package service;

import model.User;
import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;
import repository.BookRepository;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    @Autowired
    public UserService(UserRepository userRepository, BookRepository bookRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public void checkoutBook(User user, Book book) {
        if(!book.isCheckedOut()) {
            book.setCheckedOutBy(user);
            book.setCheckedOut(true);
            bookRepository.save(book);
        } else {
            throw new IllegalStateException("This book is already checked out.");
        }
    }

    public void returnBook(User user, Book book) {
        if(book.isCheckedOut() && user.equals(book.getCheckedOutBy())) {
            book.setCheckedOutBy(null);
            book.setCheckedOut(false);
            bookRepository.save(book);
        } else {
            throw new IllegalStateException("This book is not checked out by the current user.");
        }
    }



}
