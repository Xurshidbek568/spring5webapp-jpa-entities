package guru.springframework.spring5webapp.repasitories;

import guru.springframework.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepasitory extends CrudRepository<Publisher, Long> {
}
