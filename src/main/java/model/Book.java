package model;
import javax.persistence.*;
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String author;
    private String isbn;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=true)
    private User checkedOutBy;

    // Default constructor is needed by JPA
    protected Book() {
    }

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public User getCheckedOutBy() {
        return checkedOutBy;
    }

    public void setCheckedOutBy(User checkedOutBy) {
        this.checkedOutBy = checkedOutBy;
    }

}

