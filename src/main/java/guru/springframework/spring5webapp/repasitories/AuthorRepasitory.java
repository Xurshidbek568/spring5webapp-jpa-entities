package guru.springframework.spring5webapp.repasitories;

import guru.springframework.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepasitory extends CrudRepository<Author,Long> {
}
