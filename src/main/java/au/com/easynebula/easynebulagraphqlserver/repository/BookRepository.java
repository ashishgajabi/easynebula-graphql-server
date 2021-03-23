package au.com.easynebula.easynebulagraphqlserver.repository;

import au.com.easynebula.easynebulagraphqlserver.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
