package repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}

