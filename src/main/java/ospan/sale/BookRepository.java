package ospan.sale.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import ospan.sale.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}