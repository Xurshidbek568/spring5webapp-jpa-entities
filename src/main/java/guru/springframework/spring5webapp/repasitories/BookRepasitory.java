package guru.springframework.spring5webapp.repasitories;

import guru.springframework.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepasitory extends CrudRepository<Book,Long> {
}
