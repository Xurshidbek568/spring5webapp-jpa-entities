package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repasitories.AuthorRepasitory;
import guru.springframework.spring5webapp.repasitories.BookRepasitory;
import guru.springframework.spring5webapp.repasitories.PublisherRepasitory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepasitory authorRepasitory;
    private BookRepasitory bookRepasitory;
    private PublisherRepasitory publisherRepasitory;

    public DevBootstrap(AuthorRepasitory authorRepasitory, BookRepasitory bookRepasitory, PublisherRepasitory publisherRepasitory) {
        this.authorRepasitory = authorRepasitory;
        this.bookRepasitory = bookRepasitory;
        this.publisherRepasitory = publisherRepasitory;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData() {

        Publisher publisher = new Publisher();
        publisher.setName("foo");

        publisherRepasitory.save(publisher);

        //Sardor
        Author sardor = new Author("Sardor", "Matkarimov");
        Book ddd = new Book("Domain Driven Design", "12340", publisher);
        sardor.getBooks().add(ddd);
        ddd.getAuthors().add(sardor);

        authorRepasitory.save(sardor);
        bookRepasitory.save(ddd);

        //Ibrat
        Author ibrat = new Author("Ibrat", "Urinov");
        Book aaa = new Book("Dasturlash asoslari", "131", publisher);
        ibrat.getBooks().add(aaa);
        aaa.getAuthors().add(ibrat);

        authorRepasitory.save(ibrat);
        bookRepasitory.save(aaa);

    }
}
