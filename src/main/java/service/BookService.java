package service;

import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.BookRepository;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBook(Long id) {
        return bookRepository.findById(id).orElse(null);  // Returns null if the book does not exist
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public Book updateBook(Book book) {
        // In this case, the id of the book passed to this method should be set to the id of the book you want to update.
        // If the book exists, the existing book will be updated with the fields of the passed book.
        // If the book does not exist, a new book will be created with the fields of the passed book.
        return bookRepository.save(book);
    }

    // You can continue to add more methods here based on your application needs...
}
