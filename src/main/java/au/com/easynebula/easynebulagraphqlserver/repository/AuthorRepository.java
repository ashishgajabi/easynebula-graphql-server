package au.com.easynebula.easynebulagraphqlserver.repository;

import au.com.easynebula.easynebulagraphqlserver.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
